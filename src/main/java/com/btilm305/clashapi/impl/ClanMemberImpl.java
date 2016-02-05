package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.ClanMember;
import com.btilm305.clashapi.ClanMemberRole;
import org.json.JSONObject;

public class ClanMemberImpl extends PlayerImpl implements ClanMember {

    private ClanMemberRole role;
    private int clanRank;
    private int previousClanRank;
    private int troopsDonated;
    private int troopsReceived;

    protected ClanMemberImpl(JSONObject root) {
        super(root);
        role = ClanMemberRole.fromId(root.getString("role"));
        clanRank = root.getInt("clanRank");
        previousClanRank = root.getInt("previousClanRank");
        troopsDonated = root.getInt("donations");
        troopsReceived = root.getInt("donationsReceived");
    }

    public int getClanRank() {
        return clanRank;
    }

    public int getNumberOfTroopsDonated() {
        return troopsDonated;
    }

    public int getNumberOfTroopsReceived() {
        return troopsReceived;
    }

    public int getPreviousClanRank() {
        return previousClanRank;
    }

    public ClanMemberRole getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "ClanMemberImpl{" +
                "role=" + role +
                ", clanRank=" + clanRank +
                ", previousClanRank=" + previousClanRank +
                ", troopsDonated=" + troopsDonated +
                ", troopsReceived=" + troopsReceived +
                "} " + super.toString();
    }
}
