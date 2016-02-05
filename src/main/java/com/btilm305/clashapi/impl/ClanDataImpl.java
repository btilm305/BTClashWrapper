package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.ClanData;
import com.btilm305.clashapi.IconSet;
import org.json.JSONObject;

public class ClanDataImpl implements ClanData {

    protected String tag;
    protected String name;
    protected IconSet badgeIcons;

    protected ClanDataImpl(JSONObject root) {
        tag = root.getString("tag");
        name = root.getString("name");
        badgeIcons = new IconSetImpl(root.getJSONObject("badgeUrls"));
    }

    public IconSet getBadgeIcons() {
        return badgeIcons;
    }

    public String getName() {
        return name;
    }

    public String getTag() {
        return tag;
    }

    @Override
    public String toString() {
        return "ClanDataImpl{" +
                "tag='" + tag + '\'' +
                ", name='" + name + '\'' +
                ", badgeIcons=" + badgeIcons +
                '}';
    }
}
