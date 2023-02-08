package baseclass;

import java.lang.reflect.Method;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

import commonfunctions.CommonFunctionClass;
import config.DBConfig;
import config.EmployeeClass;
import config.ExtentReporterClass;
import config.PropertiesReaderClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
**@author Srikanth
* @params : testdata
* @category : testing
**/

public class BaseClass {

	protected static WebDriver d;
	public static ExtentTest test;
	public static List<EmployeeClass> employeedetails ;
	@BeforeSuite
	public void suiteConfig() throws Exception, SQLException {
		ExtentReporterClass.extentreporterconfig();
		employeedetails = DBConfig.dbconfig();
	}

	@BeforeTest
	@Parameters({ "browser" })
	public void setUp(ITestContext context, @Optional("edge") String browser) throws Exception {
		test = ExtentReporterClass.extentTest(context);
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			d = new ChromeDriver();
			test.info("Driver initialized!!");
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			d.get(PropertiesReaderClass.readValues("url"));
			test.info("URL entered !");
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			d = new FirefoxDriver();
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			d = new EdgeDriver();
			d.manage().window().maximize();
			d.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
			d.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		}
	}

	@AfterMethod
	public void ameth(Method m, ITestResult result) throws Exception {
		if (result.isSuccess()) {
			System.out.println(m.getName() + "Test passed ");
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName() + " Passed + ", ExtentColor.GREEN));
		} else if (!result.isSuccess()) {
			{
				if (result.getStatus() == result.SKIP) {
					System.out.println(m.getName() + " skipped ");
					test.log(Status.SKIP, "Test Skipped !!");
				} else if (result.getStatus() == result.FAILURE) {
					System.out.println(m.getName() + "Test failed ");
					test.log(Status.FAIL, result.getThrowable());
					test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Failed + ", ExtentColor.RED));
					String path = CommonFunctionClass.captureScreenshot();
					test.addScreenCaptureFromPath(path);
				}
			}
		}
		Thread.sleep(3000);

	}

	@AfterTest
	public void atest() {
		ExtentReporterClass.reporter.flush();
		d.quit();
	}

	public static WebDriver getdriver() {
		return d;

	}
}
