package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Class contains logger instance. Output configuration and other preferences in file 'log4j2.xml'
 */
public class CommonLogger {

    private static final Logger log = LogManager.getLogger(CommonLogger.class);

    /**
     * Returns Logger instance
     */
    public static Logger getLogger() {
        return log;
    }
}
