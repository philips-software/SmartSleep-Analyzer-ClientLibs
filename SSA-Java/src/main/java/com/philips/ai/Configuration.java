package com.philips.ai;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

public class Configuration {
	/**
	 * Current API environment
	 */
	public static Environments environment = Environments.PRODUCTION;

	/**
	 * defaultHost value
	 */
	public static String defaultHost = "philips-prod.apigee.net";

	public static String accessToken = "";

	public static String accessHost = "philips-prod.apigee.net";

	public static String api_route = "smartsleep-analyzer";

	public static String clientId = "";
	public static String clientSecret = "";

	/**
	 * Get base URI by current environment
	 * 
	 * @param server Server for which to get the base URI
	 * @return Processed base URI
	 */
	public static String getBaseUri(Servers server) {
		StringBuilder baseUrl = new StringBuilder(environmentMapper(Configuration.environment, server));
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("defaultHost", Configuration.defaultHost);
		APIHelper.appendUrlWithTemplateParameters(baseUrl, parameters);
		try {
			return URLDecoder.decode(baseUrl.toString(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * Get base URI by current environment
	 * 
	 * @return Processed base URI
	 */
	public static String getBaseUri() {
		return Configuration.getBaseUri(Servers.ENUM_DEFAULT) + "/" + api_route;
	}

	public static String getAccessTokenBaseUri() {
		return Configuration.getBaseUri(Servers.ENUM_DEFAULT);
	}

	/**
	 * Base URLs by environments and server aliases
	 */

	private static String environmentMapper(Environments environments, Servers servers) {
		String url = "";
		if (environments.equals(Environments.PRODUCTION)) {
			if (servers.equals(Servers.ENUM_DEFAULT))
				url = "https://{defaultHost}";
		}
		return url;
	}

}
