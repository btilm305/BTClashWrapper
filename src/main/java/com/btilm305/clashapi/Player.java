package com.btilm305.clashapi;

/**
 * The simplest representation of a Player. The data in the class will always be present when any sort of player or member
 * data is requested using the API.
 */
public interface Player {

    /**
     * Returns the experience level of a player
     *
     * @return the experience level of a player
     */
    int getExpLevel();

    /**
     * Returns the league a player is in
     *
     * @return the league a player is in, or {@code null} if the player is not in a league
     */
    League getLeague();

    /**
     * Returns the name of the player
     *
     * @return the name of the player
     */
    String getName();

    /**
     * Returns the number of trophies the player has
     *
     * @return the number of trophies the player has
     */
    int getTrophies();
}
