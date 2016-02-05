package com.btilm305.clashapi;

import com.btilm305.clashapi.exception.ClashException;

import java.io.IOException;
import java.util.List;

/**
 * An API that contains operations listed at <a href="https://developer.clashofclans.com/#/documentation">https://developer.clashofclans.com/#/documentation</a>
 * <p/>
 * <p>To get an instance of {@code ClashAPI}, invoke {@link BTClashWrapper#getAPIInstance(String apiToken)} with your API token</p>
 */
public interface ClashAPI {

    /**
     * Requests and returns full clan information of the specified clan
     *
     * @param clan the clan to request information on
     * @return a clan object with full clan data
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    Clan requestClan(ClanData clan) throws IOException, ClashException;

    /**
     * Requests and returns full clan information of the specified clan
     *
     * @param clanTag the tag of the clan to request information on
     * @return a clan object with full clan data
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    Clan requestClan(String clanTag) throws IOException, ClashException;

    /**
     * Requests and returns the list of members in the specified clan
     *
     * @param clan the clan to request members of
     * @return a list containing the members belonging to the specified clan
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<ClanMember> requestClanMembers(ClanData clan) throws IOException, ClashException;

    /**
     * Requests and returns the list of members in the specified clan
     *
     * @param clanTag the tag of the clan to request members of, which must start with #
     * @return a list containing the members belonging to the specified clan
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<ClanMember> requestClanMembers(String clanTag) throws IOException, ClashException;

    /**
     * Requests and returns the list of locations
     *
     * @return the list of locations
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<ClanLocation> requestLocations() throws IOException, ClashException;

    /**
     * Requests and returns the top leaderboard clans for a specified location
     *
     * @param location the location to request leaderboard information on
     * @return a list of the top clans with the specified location
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<AbbreviatedClan> requestTopClans(ClanLocation location) throws IOException, ClashException;

    /**
     * Requests and returns the top leaderboard clans for a specified location
     *
     * @param locationId the id of the location to request leaderboard information on
     * @return a list of the top clans with the specified location
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<AbbreviatedClan> requestTopClans(int locationId) throws IOException, ClashException;

    /**
     * Requests and returns the top leaderboard players for a specified location
     *
     * @param location the location to request leaderboard information on
     * @return a list of the top players with the specified location
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<LeaderboardPlayer> requestTopPlayers(ClanLocation location) throws IOException, ClashException;

    /**
     * Requests and returns the top leaderboard players for a specified location
     *
     * @param locationId the id of the location to request leaderboard information on
     * @return a list of the top players with the specified location
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<LeaderboardPlayer> requestTopPlayers(int locationId) throws IOException, ClashException;

    /**
     * Returns search results for a specified clan search request
     *
     * @param request a manually-instantiated @{link ClanSearchRequest} object that contains information on search paramaters
     * @return the list of clans returned by the search
     * @throws IOException    if an I/O error occurs
     * @throws ClashException if an error with the API call occurs
     */
    List<AbbreviatedClan> searchClans(ClanSearchRequest request) throws IOException, ClashException;
}