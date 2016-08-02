package com.icaikee.wrap.common.logger;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.net.SyslogAppender;

public class CounterLog {
	/**
	 * �̳�Level
	 * 
	 * @author Sevencm
	 * 
	 */
	private static class CounterLogLevel extends Level {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public CounterLogLevel(int level, String levelStr, int syslogEquivalent) {
			super(level, levelStr, syslogEquivalent);
		}
	}

	/**
	 * �Զ��弶�����ƣ��Լ�����Χ
	 */
	private static final Level counterLogLevel = new CounterLogLevel(60000, "X", SyslogAppender.LOG_LOCAL0);

	/**
	 * ʹ����־��ӡlogger�е�log����
	 * 
	 * @param logger
	 * @param objLogInfo
	 */
	public static void counterLog(Logger logger, Object objLogInfo) {
		logger.log(counterLogLevel, objLogInfo);
	}

}
