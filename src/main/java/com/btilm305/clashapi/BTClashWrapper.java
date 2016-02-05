package com.btilm305.clashapi;

import com.btilm305.clashapi.impl.ClashAPIImpl;

/**
 * API Factory class. This class should be accessed to create an instance of ClashAPI with your API token.
 */
public class BTClashWrapper {

    /**
     * Creates a ClashAPI instance with the provided API token
     *
     * @param apiToken the api token
     * @return an API instance
     */
    public static ClashAPI getAPIInstance(String apiToken) {
        return new ClashAPIImpl(apiToken);
    }
}
