package seleniumgrid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestLogger {
	private static final Logger logger = LogManager.getLogger(TestLogger.class);
	
	@Test
	public void test()
	{
		logger.info("Test info");
		logger.warn("Test warn");
		logger.error("Test error");
		logger.info("Test info");
	}
}
