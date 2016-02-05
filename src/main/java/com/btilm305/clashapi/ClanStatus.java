package com.btilm305.clashapi;

/**
 * An enum representing the different status a clan can have
 */
public enum ClanStatus {

    OPENED("open"),
    INVITE_ONLY("inviteOnly"),
    CLOSED("closed");

    private String id;

    ClanStatus(String id) {
        this.id = id;
    }

    public static ClanStatus fromId(String id) {
        for (ClanStatus status : values()) {
            if (status.id.equals(id)) {
                return status;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
