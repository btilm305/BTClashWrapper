# BTClashWrapper

`BTClashWrapper` is a java implementation of v1 the Clash of Clans REST API found at [https://developer.clashofclans.com/#/documentation](https://developer.clashofclans.com/#/documentation).

### Usage

Download the latest jar jar at [https://github.com/btilm305/BTClashWrapper/releases](https://github.com/btilm305/BTClashWrapper/releases) and include it in your project.

	    public static void main(String[] args) {
            ClashAPI clashAPI = BTClashWrapper.getAPIInstance(API_TOKEN);
            // use ClashAPI here
        }

To use the API, first generate a [`ClashAPI`](btilm305.github.io/BTClashWrapper/com/btilm305/clashapi/ClashAPI.html]) object using your API token as seen in the above example. This class allows you to
use all of the API features without having to worry about making HTTP requests on your own.

### Documentation

Documentation for the API can be found at [http://btilm305.github.io/BTClashWrapper/index.html](http://btilm305.github.io/BTClashWrapper/index.html).