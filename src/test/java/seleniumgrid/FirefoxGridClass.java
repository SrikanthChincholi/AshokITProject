package seleniumgrid;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

public class FirefoxGridClass extends GridConfig {

	@Test
	public void getTitle1() throws MalformedURLException, InterruptedException {
		setupBrowser("firefox");
		d.manage().window().maximize();
		d.get("https://www.google.com");
		System.out.println(d.getTitle());
		Thread.sleep(10000);
		d.quit();

	}
	@Test
	public void getTitle2() throws MalformedURLException, InterruptedException {
		setupBrowser("firefox");
		d.manage().window().maximize();
		d.get("https://www.google.com");
		System.out.println(d.getTitle());
		Thread.sleep(10000);
		d.quit();

	}
	@Test
	public void getTitle3() throws MalformedURLException, InterruptedException {
		setupBrowser("firefox");
		d.manage().window().maximize();
		d.get("https://www.google.com");
		System.out.println(d.getTitle());
		Thread.sleep(10000);
		d.quit();

	}

}
