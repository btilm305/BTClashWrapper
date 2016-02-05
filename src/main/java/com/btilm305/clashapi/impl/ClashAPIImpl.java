package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.*;
import com.btilm305.clashapi.exception.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ClashAPIImpl implements ClashAPI {

    private static final String API_BASE = "https://api.clashofclans.com/";
    private static final String API_VERSION = "v1";

    private String apiToken;

    public ClashAPIImpl(String apiToken) {
        this.apiToken = apiToken;
    }

    public Clan requestClan(ClanData clan) throws IOException, ClashException {
        return requestClan(clan.getTag());
    }

    public Clan requestClan(String clanTag) throws IOException, ClashException {
        return new ClanImpl(performAPIRequest("clans/%s", clanTag));
    }

    public List<ClanMember> requestClanMembers(ClanData clan) throws IOException, ClashException {
        return requestClanMembers(clan.getTag());
    }

    public List<ClanMember> requestClanMembers(String clanTag) throws IOException, ClashException {
        JSONObject response = performAPIRequest("clans/%s/members", clanTag);
        JSONArray array = response.getJSONArray("items");
        List<ClanMember> members = new ArrayList<ClanMember>();
        for (int i = 0; i < array.length(); i++) {
            members.add(new ClanMemberImpl(array.getJSONObject(i)));
        }
        return members;
    }

    public List<ClanLocation> requestLocations() throws IOException, ClashException {
        JSONObject response = performAPIRequest("locations");
        JSONArray array = response.getJSONArray("items");
        List<ClanLocation> locations = new ArrayList<ClanLocation>();
        for (int i = 0; i < array.length(); i++) {
            locations.add(new ClanLocationImpl(array.getJSONObject(i)));
        }
        return locations;
    }

    public List<AbbreviatedClan> requestTopClans(ClanLocation location) throws IOException, ClashException {
        return requestTopClans(location.getId());
    }

    public List<AbbreviatedClan> requestTopClans(int locationId) throws IOException, ClashException {
        JSONObject response = performAPIRequest("locations/%s/rankings/clans", locationId + "");
        JSONArray array = response.getJSONArray("items");
        List<AbbreviatedClan> clans = new ArrayList<AbbreviatedClan>();
        for (int i = 0; i < array.length(); i++) {
            clans.add(new AbbreviatedClanImpl(array.getJSONObject(i)));
        }
        return clans;
    }

    public List<LeaderboardPlayer> requestTopPlayers(ClanLocation location) throws IOException, ClashException {
        return requestTopPlayers(location.getId());
    }

    public List<LeaderboardPlayer> requestTopPlayers(int locationId) throws IOException, ClashException {
        JSONObject response = performAPIRequest("locations/%s/rankings/players", locationId + "");
        JSONArray array = response.getJSONArray("items");
        List<LeaderboardPlayer> players = new ArrayList<LeaderboardPlayer>();
        for (int i = 0; i < array.length(); i++) {
            players.add(new LeaderboardPlayerImpl(array.getJSONObject(i)));
        }
        return players;
    }

    public List<AbbreviatedClan> searchClans(ClanSearchRequest request) throws IOException, ClashException {
        HashMap<String, String> params = new HashMap<String, String>();
        insertIfNotNull(params, "name", request.getName());
        insertIfNotNull(params, "warFrequency", request.getWarFrequency());
        insertIfNotNull(params, "minMembers", request.getMinMembers());
        insertIfNotNull(params, "maxMembers", request.getMaxMembers());
        insertIfNotNull(params, "minClanPoints", request.getMinClanPoints());
        insertIfNotNull(params, "minClanLevel", request.getMinClanLevel());
        insertIfNotNull(params, "limit", request.getLimit());
        insertIfNotNull(params, "after", request.getAfter());
        insertIfNotNull(params, "before", request.getBefore());

        StringBuilder paramBuilder = new StringBuilder();
        for (Map.Entry<String, String> entry : params.entrySet()) {
            if (paramBuilder.length() == 0) {
                paramBuilder.append("?");
            } else {
                paramBuilder.append("&");
            }
            paramBuilder.append(entry.getKey());
            paramBuilder.append("=");
            paramBuilder.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        JSONObject response = performAPIRequest("clans/" + paramBuilder.toString());
        JSONArray array = response.getJSONArray("items");
        List<AbbreviatedClan> clans = new ArrayList<AbbreviatedClan>();
        for (int i = 0; i < array.length(); i++) {
            clans.add(new AbbreviatedClanImpl(array.getJSONObject(i)));
        }
        return clans;
    }

    private void insertIfNotNull(Map<String, String> map, String key, Object value) {
        if (value != null) {
            map.put(key, value.toString());
        }
    }

    private void insertIfNotNull(Map<String, String> map, String key, int value) {
        if (value != Integer.MIN_VALUE) {
            map.put(key, value + "");
        }
    }

    private JSONObject performAPIRequest(String format, String... arguments) throws IOException, ClashException {
        for (int i = 0; i < arguments.length; i++) {
            arguments[i] = URLEncoder.encode(arguments[0], "UTF-8");
        }
        String suffix = String.format(format, arguments);
        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(API_BASE + API_VERSION + "/" + suffix).openConnection();
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("authorization", "Bearer " + apiToken);

            InputStream input = null;
            int statusCode = connection.getResponseCode();
            if (statusCode >= 200 && statusCode < 400) {
                input = connection.getInputStream();
            } else {
                input = connection.getErrorStream();
            }

            String response = null;
            try {
                response = inputStreamToString(input);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JSONObject json = null;
            if (response != null && !response.isEmpty()) {
                try {
                    json = new JSONObject(response);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                response = response.replace("\n", "");
            }

            switch (statusCode) {
                case 400:
                    throw new BadRequestException(response);
                case 403:
                    throw new AuthenticationException(response);
                case 404:
                    throw new NotFoundException(response);
                case 429:
                    throw new RateLimitExceededException(response);
                case 200:
                    return json;
                default:
                    throw new UnknownErrorException(statusCode + ": " + response);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private String inputStreamToString(InputStream in) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.close();
        in.close();
        return new String(out.toByteArray());
    }
}