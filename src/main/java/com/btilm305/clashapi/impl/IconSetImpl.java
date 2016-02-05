package com.btilm305.clashapi.impl;

import com.btilm305.clashapi.IconSet;
import org.json.JSONObject;

public class IconSetImpl implements IconSet {

    private String tinyURL;
    private String smallURL;
    private String mediumURL;
    private String largeURL;

    protected IconSetImpl(JSONObject root) {
        if (root.has("tiny")) {
            tinyURL = root.getString("tiny");
        }
        if (root.has("small")) {
            smallURL = root.getString("small");
        }
        if (root.has("medium")) {
            mediumURL = root.getString("medium");
        }
        if (root.has("large")) {
            largeURL = root.getString("large");
        }
    }

    public boolean hasLargeURL() {
        return largeURL != null;
    }

    public boolean hasMediumURL() {
        return mediumURL != null;
    }

    public boolean hasSmallURL() {
        return smallURL != null;
    }

    public boolean hasTinyURL() {
        return tinyURL != null;
    }

    public String getTinyURL() {
        return tinyURL;
    }

    public String getSmallURL() {
        return smallURL;
    }

    public String getMediumURL() {
        return mediumURL;
    }

    public String getLargeURL() {
        return largeURL;
    }
}
