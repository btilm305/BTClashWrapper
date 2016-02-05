package com.btilm305.clashapi;

/**
 * A representation of the data returned by player leaderboard API calls.
 */
public interface LeaderboardPlayer extends Player {

    /**
     * Returns the number of attack wins of the player during the current season
     *
     * @return the number of attack wins of the player during the current season
     */
    int getAttackWins();

    /**
     * Returns the number of defense wins of the player during the current season
     *
     * @return the number of defense wins of the player during the current season
     */
    int getDefenseWins();

    /**
     * Returns the player's numerical rank on the leaderboard
     *
     * @return the player's numerical rank on the leaderboard
     */
    int getLeaderboardRank();

    /**
     * Returns the player's previous numerical rank on the leaderboard. This is used to determine how far a player has
     * risen or fallen on the leaderboards.
     *
     * @return the player's previous numerical rank on the leaderboard
     */
    int getPreviousLeaderboardRank();

    /**
     * Returns the player's clan information
     *
     * @return the player's clan information, or {@code null} if the player is not in a clan
     */
    ClanData getClanData();
}
