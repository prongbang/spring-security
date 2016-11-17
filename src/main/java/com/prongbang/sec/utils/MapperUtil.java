package com.prongbang.sec.utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.Timestamp;

public class MapperUtil {

	public static String getString(ResultSet rs, String field) {
		
		try {

			return rs.getString(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static Integer getInteger(ResultSet rs, String field) {

		try {

			return rs.getInt(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static Timestamp getTimestamp(ResultSet rs, String field) {

		try {

			return rs.getTimestamp(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static Boolean getBoolean(ResultSet rs, String field) {

		try {

			return rs.getBoolean(field);

		} catch (Exception e) {

		}

		return null;
	}
	
	public static Long getLong(ResultSet rs, String field) {

		try {

			return rs.getLong(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static BigDecimal getBigDecimal(ResultSet rs, String field) {
		
		try {

			return rs.getBigDecimal(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static Double getDouble(ResultSet rs, String field) {
		
		try {

			return rs.getDouble(field);

		} catch (Exception e) {

		}

		return null;
	}

	public static Float getFloat(ResultSet rs, String field) {
		
		try {

			return rs.getFloat(field);

		} catch (Exception e) {

		}

		return null;
	}

}
