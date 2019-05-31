package com.eshel.frame.utils;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.net.UnknownHostException;
import java.util.Date;

/**
 * createBy Eshel
 * createTime: 2019/4/28 00:25
 * desc: TODO
 */
public class Log {

	/**
	 * Priority constant for the println method; use Log.v.
	 */
	public static final int VERBOSE = 2;
	public static final String V = "V";

	/**
	 * Priority constant for the println method; use Log.d.
	 */
	public static final int DEBUG = 3;
	public static final String D = "D";

	/**
	 * Priority constant for the println method; use Log.i.
	 */
	public static final int INFO = 4;
	public static final String I = "I";

	/**
	 * Priority constant for the println method; use Log.w.
	 */
	public static final int WARN = 5;
	public static final String W = "W";

	/**
	 * Priority constant for the println method; use Log.e.
	 */
	public static final int ERROR = 6;
	public static final String E = "E";

	/**
	 * Priority constant for the println method.
	 */
	public static final int ASSERT = 7;
	public static final String AST = "AST";


	public static int v(String tag, String msg) {
		return println_native(LOG_ID_MAIN, VERBOSE, tag, msg);
	}

	/**
	 * Send a {@link #VERBOSE} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static int v(String tag, String msg, Throwable tr) {
		return printlns(LOG_ID_MAIN, VERBOSE, tag, msg, tr);
	}

	/**
	 * Send a {@link #DEBUG} log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static int d(String tag, String msg) {
		return println_native(LOG_ID_MAIN, DEBUG, tag, msg);
	}

	/**
	 * Send a {@link #DEBUG} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static int d(String tag, String msg, Throwable tr) {
		return printlns(LOG_ID_MAIN, DEBUG, tag, msg, tr);
	}

	/**
	 * Send an {@link #INFO} log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static int i(String tag, String msg) {
		return println_native(LOG_ID_MAIN, INFO, tag, msg);
	}

	/**
	 * Send a {@link #INFO} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static int i(String tag, String msg, Throwable tr) {
		return printlns(LOG_ID_MAIN, INFO, tag, msg, tr);
	}

	/**
	 * Send a {@link #WARN} log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static int w(String tag, String msg) {
		return println_native(LOG_ID_MAIN, WARN, tag, msg);
	}

	/**
	 * Send a {@link #WARN} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static int w(String tag, String msg, Throwable tr) {
		return printlns(LOG_ID_MAIN, WARN, tag, msg, tr);
	}

	/**
	 * Checks to see whether or not a log for the specified tag is loggable at the specified level.
	 *
	 *  The default level of any tag is set to INFO. This means that any level above and including
	 *  INFO will be logged. Before you make any calls to a logging method you should check to see
	 *  if your tag should be logged. You can change the default level by setting a system property:
	 *      'setprop log.tag.&lt;YOUR_LOG_TAG> &lt;LEVEL>'
	 *  Where level is either VERBOSE, DEBUG, INFO, WARN, ERROR, ASSERT, or SUPPRESS. SUPPRESS will
	 *  turn off all logging for your tag. You can also create a local.prop file that with the
	 *  following in it:
	 *      'log.tag.&lt;YOUR_LOG_TAG>=&lt;LEVEL>'
	 *  and place that in /data/local.prop.
	 *
	 * @param tag The tag to check.
	 * @param level The level to check.
	 * @return Whether or not that this is allowed to be logged.
	 * @throws IllegalArgumentException is thrown if the tag.length() > 23
	 *         for Nougat (7.0) releases (API <= 23) and prior, there is no
	 *         tag limit of concern after this API level.
	 */
	public static boolean isLoggable(String tag, int level){
		return true;
	}

	/*
	 * Send a {@link #WARN} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param tr An exception to log
	 */
	public static int w(String tag, Throwable tr) {
		return printlns(LOG_ID_MAIN, WARN, tag, "", tr);
	}

	/**
	 * Send an {@link #ERROR} log message.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 */
	public static int e(String tag, String msg) {
		return println_native(LOG_ID_MAIN, ERROR, tag, msg);
	}

	/**
	 * Send a {@link #ERROR} log message and log the exception.
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @param tr An exception to log
	 */
	public static int e(String tag, String msg, Throwable tr) {
		return printlns(LOG_ID_MAIN, ERROR, tag, msg, tr);
	}


	/**
	 * Handy function to get a loggable stack trace from a Throwable
	 * @param tr An exception to log
	 */
	public static String getStackTraceString(Throwable tr) {
		if (tr == null) {
			return "";
		}

		// This is to reduce the amount of log spew that apps do in the non-error
		// condition of the network being unavailable.
		Throwable t = tr;
		while (t != null) {
			if (t instanceof UnknownHostException) {
				return "";
			}
			t = t.getCause();
		}

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw, false);
		tr.printStackTrace(pw);
		pw.flush();
		return sw.toString();
	}

	/**
	 * Low-level logging call.
	 * @param priority The priority/type of this log message
	 * @param tag Used to identify the source of a log message.  It usually identifies
	 *        the class or activity where the log call occurs.
	 * @param msg The message you would like logged.
	 * @return The number of bytes written.
	 */
	public static int println(int priority, String tag, String msg) {
		return println_native(LOG_ID_MAIN, priority, tag, msg);
	}

	 public static final int LOG_ID_MAIN = 0;
	 public static final int LOG_ID_RADIO = 1;
	 public static final int LOG_ID_EVENTS = 2;
	 public static final int LOG_ID_SYSTEM = 3;
	 public static final int LOG_ID_CRASH = 4;

	 public static final int LOG_STATE_ERROR = -1;
	 public static final int LOG_STATE_SUCCESS = 1;

	 public static int println_native(int bufID, int priority, String tag, String msg){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(TimeUtil.formatLogTime(new Date().getTime()))
					.append("-")
					.append(Thread.currentThread().getId())
					.append("-")
					.append(getLevleTag(priority))
					.append("-")
					.append(tag)
					.append(" : ")
					.append(msg);
			println(priority, sb.toString());
		    return LOG_STATE_SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			return LOG_STATE_ERROR;
		}
	 }

	/**
	 * Helper function for long messages. Uses the LineBreakBufferedWriter to break
	 * up long messages and stacktraces along newlines, but tries to write in large
	 * chunks. This is to avoid truncation.
	 * 00:24:12.812-204-V-TAG : hahahaha msg
	 */
	public static int printlns(int bufID, int priority, String tag, String msg, Throwable tr) {
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(tag)
					.append(TimeUtil.formatLogTime(new Date().getTime()))
					.append("-")
					.append(Thread.currentThread().getId())
					.append("-")
					.append(getLevleTag(priority))
					.append("-")
					.append(tag)
					.append(" : ")
					.append(msg)
					.append("\n")
					.append(getStackTraceString(tr));
			println(priority, sb.toString());
			return LOG_STATE_SUCCESS;
		}catch (Exception e){
			e.printStackTrace();
			return LOG_STATE_ERROR;
		}
	}

	private static void println(int priority, String logContent){
		if(priority < ERROR){
			System.out.println(logContent);
		}else {
			System.err.println(logContent);
		}
	}

	public static String getLevleTag(int priority){
		switch (priority){
			case VERBOSE:
				return V;
			case DEBUG:
				return D;
			case INFO:
				return I;
			case WARN:
				return W;
			case ERROR:
				return E;
			case ASSERT:
				return AST;
		}
		return "KNOWN";
	}

}
