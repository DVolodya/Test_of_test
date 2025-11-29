package reportportal.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogger {
    private static final Logger logger = LoggerFactory.getLogger(TestLogger.class);

    public static void info(String message) {
        logger.info(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void warn(String message) {
        logger.warn(message);
    }
}