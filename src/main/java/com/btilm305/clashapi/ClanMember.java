package com.btilm305.clashapi;

/**
 * A representation of the data of clan members.
 */
public interface ClanMember extends Player {

    /**
     * Returns the player's rank in the clan (higher # of trophies = higher rank)
     *
     * @return the player's rank in the clan
     */
    int getClanRank();

    /**
     * Returns the number of troops the player has donated during the current season
     *
     * @return the number of troops the player has donated during the current season
     */
    int getNumberOfTroopsDonated();

    /**
     * Returns the number of troops the player has received from clan members during the current season
     *
     * @return the number of troops the player has received from clan members during the current season
     */
    int getNumberOfTroopsReceived();

    /**
     * Returns the player's previous rank in the clan. This is used to determine how far a player has
     * risen or fallen in the clan's player ranks
     *
     * @return the player's previous rank in the clan
     */
    int getPreviousClanRank();

    /**
     * Returns the leadership role of the player
     *
     * @return the leadership role of the player
     */
    ClanMemberRole getRole();
}
