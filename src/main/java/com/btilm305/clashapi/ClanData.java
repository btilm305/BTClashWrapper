package com.btilm305.clashapi;

/**
 * The simplest representation of a Clan, containing only a few data fields. All API calls that return clan data contain
 * at least this amount of information.
 *
 * <p>More information about a clan can be requested with {@link ClashAPI#requestClan(ClanData)}</p>
 */
public interface ClanData {

    /**
     * Returns the URLs for the clan badge images
     *
     * @return the URLs for the clan badge images
     */
    IconSet getBadgeIcons();

    /**
     * Returns the name of the clan
     *
     * @return the name of the clan
     */
    String getName();

    /**
     * Returns the clan tag
     *
     * @return the clan tag, starting with #
     */
    String getTag();
}
