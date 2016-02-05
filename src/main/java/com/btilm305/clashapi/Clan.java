package com.btilm305.clashapi;

import java.util.List;

/**
 * A representation of all possible clan data provided by the API.
 */
public interface Clan extends AbbreviatedClan {

    /**
     * Returns the clan description
     *
     * @return the clan description
     */
    String getDescription();

    /**
     * Returns a list of members in the clan
     *
     * @return the list of clan members
     */
    List<ClanMember> getMembers();
}
