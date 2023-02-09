package test;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;
import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import baseclass.BaseClass;
import commonfunctions.CommonFunctionClass;
import config.EmployeeClass;
import config.LoggerClass;
import dataprovider.DataProviderClass;

public class TestClass extends BaseClass {

	private static final Logger logger = LoggerClass.logger(TestClass.class);

	// @Test(dataProvider = "exceldatadp", dataProviderClass =
	// DataProviderClass.class)
	public void test1(Method method, String run, String uname, String pswd, String validate_txt) throws Exception {
		if (run.equalsIgnoreCase("yes")) {
			Actions act = new Actions(d);
			WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
			try {
				CommonFunctionClass.getElement(By.name("username")).sendKeys(uname);
				logger.info("Entered username");
				test.info("Entered username");
				CommonFunctionClass.getElement(By.name("password")).sendKeys(pswd);
				logger.info("Entered password");
				test.info("Entered password");
				CommonFunctionClass.getElement(By.xpath("//button[@type='submit']")).click();
				logger.info("Clicked on submit");
				test.info("Clicked on submit");
				String text = d.findElement(By.xpath("//span//h6")).getText();
				assertEquals(validate_txt, text);
				logger.info("Home page content matched");
				test.log(Status.PASS, "Page content matched");
				WebElement profilepic = CommonFunctionClass
						.getElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
				act.moveToElement(profilepic).pause(2000).click(profilepic).build().perform();
				WebElement logout = CommonFunctionClass.getElement(By.xpath("//li/a[text()='Logout']"));
				act.moveToElement(logout).pause(2000).click(logout).build().perform();
				Thread.sleep(5000);
			}

			catch (Exception e) {
				logger.error("Home page content not matched");
				test.log(Status.FAIL, "Home page content not matched");
				WebElement profilepic = CommonFunctionClass
						.getElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
				act.moveToElement(profilepic).pause(2000).click(profilepic).build().perform();
				WebElement logout = CommonFunctionClass.getElement(By.xpath("//li/a[text()='Logout']"));
				act.moveToElement(logout).pause(2000).click(logout).build().perform();
				Thread.sleep(5000);
			}
			/*
			 * finally { WebElement profilepic = CommonFunctionClass
			 * .getElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
			 * act.moveToElement(profilepic).pause(2000).click(profilepic).build().perform()
			 * ; WebElement logout =
			 * CommonFunctionClass.getElement(By.xpath("//li/a[text()='Logout']"));
			 * act.moveToElement(logout).pause(2000).click(logout).build().perform();
			 * Thread.sleep(5000); }
			 */
		} else {
			throw new SkipException("This test is not set for run !!");
		}
	}

	@Test(dataProvider = "dbdata", dataProviderClass = DataProviderClass.class)
	public void dbtest1(Method method, EmployeeClass edetails) throws Exception {
			// for (int i = 0; i < employeedetails.size(); i++) {
			Actions act = new Actions(d);
			WebDriverWait wait = new WebDriverWait(d, Duration.ofSeconds(30));
			try {
				CommonFunctionClass.getElement(By.name("username")).sendKeys(edetails.getUsername());
				logger.info("Entered username");
				test.info("Entered username");
				CommonFunctionClass.getElement(By.name("password")).sendKeys(edetails.getEpassword());
				logger.info("Entered password");
				test.info("Entered password");
				CommonFunctionClass.getElement(By.xpath("//button[@type='submit']")).click();
				logger.info("Clicked on submit");
				test.info("Clicked on submit");
				String text = d.findElement(By.xpath("//span//h6")).getText();
				Thread.sleep(3000);
				assertEquals("Dashboard", text);
				logger.info("Home page content matched");
				test.log(Status.PASS, "Page content matched");
				WebElement profilepic = CommonFunctionClass
						.getElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
				act.moveToElement(profilepic).pause(2000).click(profilepic).build().perform();
				WebElement logout = CommonFunctionClass.getElement(By.xpath("//li/a[text()='Logout']"));
				act.moveToElement(logout).pause(2000).click(logout).build().perform();
				Thread.sleep(5000);
			}

			catch (Exception e) {
				logger.error("Home page content not matched");
				test.log(Status.FAIL, "Home page content not matched");
				WebElement profilepic = CommonFunctionClass
						.getElement(By.xpath("//span[@class='oxd-userdropdown-tab']"));
				act.moveToElement(profilepic).pause(2000).click(profilepic).build().perform();
				WebElement logout = CommonFunctionClass.getElement(By.xpath("//li/a[text()='Logout']"));
				act.moveToElement(logout).pause(2000).click(logout).build().perform();
				Thread.sleep(5000);
			}
		}

}
