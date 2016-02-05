package com.btilm305.clashapi;

/**
 * A representation of a location used in game. API calls for leaderboard information require a location as a parameter.
 * If the location is not a country, {@code getCountryCode()} will return {@code null}
 */
public interface ClanLocation {

    /**
     * Returns the country code of a location
     *
     * @return the country code, or {@code null} if the location is not a country
     */
    String getCountryCode();

    /**
     * Returns the id of the location
     * @return the id of the location
     */
    int getId();

    /**
     * Returns the name of the location
     * @return the name of the location
     */
    String getName();

    /**
     * Returns whether the location is a country
     * @return {@code true} if the location is a country, {@code false} otherwise
     */
    boolean isCountry();
}
