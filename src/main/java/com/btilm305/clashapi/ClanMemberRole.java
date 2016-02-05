package com.btilm305.clashapi;

/**
 * An enum representing the possible leadership roles that clan members can have
 */
public enum ClanMemberRole {

    LEADER("leader"),
    CO_LEADER("coLeader"),
    ELDER("admin"),
    MEMBER("member");

    private String id;

    ClanMemberRole(String id) {
        this.id = id;
    }

    public static ClanMemberRole fromId(String id) {
        for (ClanMemberRole role : values()) {
            if (role.id.equals(id)) {
                return role;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return id;
    }
}
