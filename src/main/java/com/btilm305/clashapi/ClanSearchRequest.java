package com.btilm305.clashapi;

/**
 * A wrapper for available clan search values. Use setters to narrow search results.
 */
public class ClanSearchRequest {

    private String name;
    private ClanWarFrequency warFrequency;
    private ClanLocation location;
    private int minMembers = Integer.MIN_VALUE;
    private int maxMembers = Integer.MIN_VALUE;
    private int minClanPoints = Integer.MIN_VALUE;
    private int minClanLevel = Integer.MIN_VALUE;
    private int limit = Integer.MIN_VALUE;
    private int after = Integer.MIN_VALUE;
    private int before = Integer.MIN_VALUE;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ClanWarFrequency getWarFrequency() {
        return warFrequency;
    }

    public void setWarFrequency(ClanWarFrequency warFrequency) {
        this.warFrequency = warFrequency;
    }

    public ClanLocation getLocation() {
        return location;
    }

    public void setLocation(ClanLocation location) {
        this.location = location;
    }

    public int getMinMembers() {
        return minMembers;
    }

    public void setMinMembers(int minMembers) {
        this.minMembers = minMembers;
    }

    public int getMaxMembers() {
        return maxMembers;
    }

    public void setMaxMembers(int maxMembers) {
        this.maxMembers = maxMembers;
    }

    public int getMinClanPoints() {
        return minClanPoints;
    }

    public void setMinClanPoints(int minClanPoints) {
        this.minClanPoints = minClanPoints;
    }

    public int getMinClanLevel() {
        return minClanLevel;
    }

    public void setMinClanLevel(int minClanLevel) {
        this.minClanLevel = minClanLevel;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getAfter() {
        return after;
    }

    public void setAfter(int after) {
        this.after = after;
    }

    public int getBefore() {
        return before;
    }

    public void setBefore(int before) {
        this.before = before;
    }
}
