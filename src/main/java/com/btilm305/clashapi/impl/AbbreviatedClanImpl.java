package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.*;
import org.json.JSONObject;

public class AbbreviatedClanImpl extends ClanDataImpl implements AbbreviatedClan {

    protected ClanStatus status;
    protected ClanLocation location;
    protected ClanWarFrequency warFrequency;
    protected int clanLevel;
    protected int warWins;
    protected int clanPoints;
    protected int requiredTrophies;
    protected int numberOfMembers;

    protected AbbreviatedClanImpl(JSONObject root) {
        super(root);
        status = ClanStatus.fromId(root.getString("type"));
        if (root.has("location")) {
            location = new ClanLocationImpl(root.getJSONObject("location"));
        } else {
            location = ClanLocationImpl.NONE;
        }
        warFrequency = ClanWarFrequency.fromId(root.getString("warFrequency"));
        clanLevel = root.getInt("clanLevel");
        warWins = root.getInt("warWins");
        clanPoints = root.getInt("clanPoints");
        requiredTrophies = root.getInt("requiredTrophies");
        numberOfMembers = root.getInt("members");
    }

    public int getClanLevel() {
        return clanLevel;
    }

    public int getClanPoints() {
        return clanPoints;
    }

    public ClanLocation getLocation() {
        return location;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public int getRequiredTrophies() {
        return requiredTrophies;
    }

    public ClanStatus getStatus() {
        return status;
    }

    public ClanWarFrequency getWarFrequency() {
        return warFrequency;
    }

    public int getWarWins() {
        return warWins;
    }

    @Override
    public String toString() {
        return "AbbreviatedClanImpl{" +
                "status=" + status +
                ", location=" + location +
                ", warFrequency=" + warFrequency +
                ", clanLevel=" + clanLevel +
                ", warWins=" + warWins +
                ", clanPoints=" + clanPoints +
                ", requiredTrophies=" + requiredTrophies +
                ", numberOfMembers=" + numberOfMembers +
                "} " + super.toString();
    }
}
