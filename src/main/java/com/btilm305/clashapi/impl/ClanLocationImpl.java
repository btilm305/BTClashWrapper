package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.ClanLocation;
import org.json.JSONObject;

public class ClanLocationImpl implements ClanLocation {

    protected static final ClanLocation NONE = new ClanLocationImpl();

    private int id;
    private String name;
    private boolean country;
    private String countryCode;

    private ClanLocationImpl() {
    }

    public ClanLocationImpl(JSONObject root) {
        id = root.getInt("id");
        name = root.getString("name");
        country = root.getBoolean("isCountry");
        if (root.has("countryCode")) {
            countryCode = root.getString("countryCode");
        }
    }

    public String getCountryCode() {
        return countryCode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean isCountry() {
        return country;
    }

    @Override
    public String toString() {
        return "ClanLocationImpl{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", country=" + country +
                ", getCountryCode='" + countryCode + '\'' +
                '}';
    }
}
