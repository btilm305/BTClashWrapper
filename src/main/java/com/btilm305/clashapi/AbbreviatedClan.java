package com.btilm305.clashapi;

/**
 * A representation of a clan containing data returned by most API calls. Includes most of the information about a clan.
 * <p/>
 * <p>More information about a clan can be requested with {@link ClashAPI#requestClan(ClanData)}</p>
 */
public interface AbbreviatedClan extends ClanData {

    /**
     * Returns the level of a clan
     *
     * @return the level of a clan, also known as clan XP level
     */
    int getClanLevel();

    /**
     * Returns the number of points that a clan has
     *
     * @return the number of clan points, determined using a weighed sum. Also known as the "clan trophy level"
     */
    int getClanPoints();

    /**
     * Returns the location of the clan
     *
     * @return the location of the clan
     */
    ClanLocation getLocation();

    /**
     * Returns the number of members that a clan has
     *
     * @return the number of members that a clan has
     */
    int getNumberOfMembers();

    /**
     * Returns the number of trophies required in order to join a clan
     *
     * @return the number of trophies required in order to join a clan
     */
    int getRequiredTrophies();

    /**
     * Returns the status of the clan
     *
     * @return the status of the clan, also known as "openness" (invite, open, closed)
     */
    ClanStatus getStatus();

    /**
     * Returns the war frequency of the clan
     *
     * @return the war frequency of the clan
     */
    ClanWarFrequency getWarFrequency();

    /**
     * Returns the number of war wins that the clan has
     *
     * @return the number of war wins that the clan has
     */
    int getWarWins();
}
