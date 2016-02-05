package com.btilm305.clashapi;

/**
 * An enum representing the possible war frequencies a clan can have
 */
public enum ClanWarFrequency {

    ALWAYS("always"),
    MORE_THAN_ONCE_PER_WEEK("moreThanOncePerWeek"),
    ONCE_PER_WEEK("oncePerWeek"),
    LESS_THAN_ONCE_PER_WEEK("lessThanOncePerWeek"),
    NEVER("never"),
    UNKNOWN("unknown");

    private String id;

    ClanWarFrequency(String id) {
        this.id = id;
    }

    public static ClanWarFrequency fromId(String id) {
        for (ClanWarFrequency frequency : values()) {
            if (frequency.id.equals(id)) {
                return frequency;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
