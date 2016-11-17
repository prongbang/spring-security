package com.prongbang.sec.utils;

import java.util.Map;

public class MapUtil {

	/**
	 * Get Integer value from Map
	 * @param map
	 * @param key
	 * @return Integer
	 */
	public static Integer getInteger(Map<String, Object> map, String key) {
		
		return map.get(key) != null ? Integer.valueOf(String.valueOf(map.get(key))) : null;
	}
	
	/**
	 * Get String value from Map
	 * @param map
	 * @param key
	 * @return String
	 */
	public static String getString(Map<String, Object> map, String key) {
		
		return map.get(key) != null ? String.valueOf(map.get(key)) : null;
	}
	
	/**
	 * Get Boolean value from Map
	 * @param map
	 * @param key
	 * @return String
	 */
	public static Boolean getBoolean(Map<String, Object> map, String key) {
		
		return map.get(key) != null ? "1".equals(String.valueOf(map.get(key))) : null;
	}
	
	
}
