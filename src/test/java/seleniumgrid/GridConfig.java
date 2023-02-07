package seleniumgrid;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GridConfig {

	static DesiredCapabilities cap;
	static RemoteWebDriver d;

	public static void setupBrowser(String browser) throws MalformedURLException {
		if (browser.equalsIgnoreCase("chrome")) {
			cap = new DesiredCapabilities();
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("chrome");

		} else if (browser.equalsIgnoreCase("firefox")) {
			cap = new DesiredCapabilities();
			cap.setPlatform(Platform.ANY);
			cap.setBrowserName("firefox");
		}

		d = new RemoteWebDriver(new URL("http://localhost:4444"), cap);

	}

}
