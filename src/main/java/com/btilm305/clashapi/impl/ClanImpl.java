package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.BTClashWrapper;
import com.btilm305.clashapi.Clan;
import com.btilm305.clashapi.ClanMember;
import com.btilm305.clashapi.ClashAPI;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ClanImpl extends AbbreviatedClanImpl implements Clan {

    private String description;
    private List<ClanMember> members = new ArrayList<ClanMember>();

    public ClanImpl(JSONObject root) {
        super(root);
        description = root.getString("description");
        JSONArray memberList = root.getJSONArray("memberList");
        for (int i = 0; i < memberList.length(); i++) {
            members.add(new ClanMemberImpl(memberList.getJSONObject(i)));
        }
    }

    public String getDescription() {
        return description;
    }

    public List<ClanMember> getMembers() {
        return members;
    }

    @Override
    public String toString() {
        return "ClanImpl{" +
                "description='" + description + '\'' +
                ", members=" + members +
                "} " + super.toString();
    }
}
