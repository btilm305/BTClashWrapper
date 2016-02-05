package com.btilm305.clashapi;

/**
 * A representation of a league. Leagues are determined by a player's trophy count
 */
public interface League {

    /**
     * Returns the URLs for the league icon images
     *
     * @return the URLs for the league icon images
     */
    IconSet getIcons();

    /**
     * Returns the id of the league
     *
     * @return the id of the league
     */
    int getId();

    /**
     * Returns the name of the league
     *
     * @return the name of the league
     */
    String getName();
}
