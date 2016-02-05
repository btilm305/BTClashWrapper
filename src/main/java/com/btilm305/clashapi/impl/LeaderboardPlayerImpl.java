package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.ClanData;
import com.btilm305.clashapi.LeaderboardPlayer;
import org.json.JSONObject;

public class LeaderboardPlayerImpl extends PlayerImpl implements LeaderboardPlayer {

    private int attackWins;
    private int defenseWins;
    private int leaderboardRank;
    private int previousLeaderboardRank;
    private ClanData clanData;

    protected LeaderboardPlayerImpl(JSONObject root) {
        super(root);
        attackWins = root.getInt("attackWins");
        defenseWins = root.getInt("defenseWins");
        leaderboardRank = root.getInt("rank");
        previousLeaderboardRank = root.getInt("previousRank");
        if (root.has("clan")) {
            clanData = new ClanDataImpl(root.getJSONObject("clan"));
        }
    }

    public int getAttackWins() {
        return attackWins;
    }

    public int getDefenseWins() {
        return defenseWins;
    }

    public int getLeaderboardRank() {
        return leaderboardRank;
    }

    public int getPreviousLeaderboardRank() {
        return previousLeaderboardRank;
    }

    public ClanData getClanData() {
        return clanData;
    }

    @Override
    public String toString() {
        return "LeaderboardPlayerImpl{" +
                "attackWins=" + attackWins +
                ", defenseWins=" + defenseWins +
                ", leaderboardRank=" + leaderboardRank +
                ", previousLeaderboardRank=" + previousLeaderboardRank +
                ", clanData=" + clanData +
                "} " + super.toString();
    }
}
