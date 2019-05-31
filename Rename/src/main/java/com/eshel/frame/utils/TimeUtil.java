package com.eshel.frame.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Created by guoshiwen on 2019/3/20.
 */

public class TimeUtil {

	private static TimeUtil INSTANCE = new TimeUtil();

	public static TimeUtil getInstance() {
		if (INSTANCE == null) {
			synchronized (TimeUtil.class) {
				if (INSTANCE == null)
					INSTANCE = new TimeUtil();
			}
		}
		return INSTANCE;
	}

	public static final String PATTERN_DATE_ONLY = "yyyy/MM/dd";
	public static final String PATTERN_DATE_TEXT = "yyyy年MM月dd日";
	public static final String PATTERN_YEAR_ONLY = "yyyy";
	public static final String PATTERN_SECOND = "yyyy-MM-dd hh:mm:ss";
	public static final String PATTERN_MS = "hh:mm:ss:SSS";

	private Map<String, SimpleDateFormat> formatMap;

	public static String formatLogTime(long ms){
		return formatTime(ms, PATTERN_MS);
	}

	public static String formatTime(long ms, String pattern) {
		return INSTANCE.format(ms, pattern);
	}

	public static String formatYYMMdd(long ms) {
		return INSTANCE.format(ms, TimeUtil.PATTERN_DATE_ONLY);
	}

	public static String formatYMdhms(long ms) {
		return INSTANCE.format(ms, TimeUtil.PATTERN_SECOND);
	}

	public static String formatYearOnly(long ms) {
		return INSTANCE.format(ms, TimeUtil.PATTERN_YEAR_ONLY);
	}

	public TimeUtil() {
		formatMap = new HashMap<>(2);
		addFormat(PATTERN_DATE_ONLY);
	}

	public SimpleDateFormat addFormat(String pattern) {
		SimpleDateFormat format = formatMap.get(pattern);
		if (format == null) {
			format = new SimpleDateFormat(pattern, Locale.CHINA);
			formatMap.put(pattern, format);
		}
		return format;
	}

	public void removeFormat(String pattern) {
		formatMap.remove(pattern);
	}

	public SimpleDateFormat getFormat(String pattern) {
		SimpleDateFormat format = formatMap.get(pattern);
		if (format == null) {
			format = addFormat(pattern);
		}
		return format;
	}

	public String format(long ms, String pattern) {
		return getFormat(pattern).format(new Date(ms));
	}

}
