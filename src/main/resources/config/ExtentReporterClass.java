package config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.testng.ITestContext;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterClass {

	public static ExtentSparkReporter htmlreporter;
	public static ExtentReports reporter;
	public static ExtentTest test;

	public static void extentreporterconfig() {

		htmlreporter = new ExtentSparkReporter(
				System.getProperty("user.dir") + "//Reports//" + datetime() + "_report.html");
		reporter = new ExtentReports();
		reporter.attachReporter(htmlreporter);

		reporter.setSystemInfo("Machine", "testmachine");
		reporter.setSystemInfo("OS", System.getProperty("windows.os"));
		reporter.setSystemInfo("user", "Srikanth");
		reporter.setSystemInfo("Browser", "chrome");

		htmlreporter.config().setDocumentTitle("Extent Demo Report");
		htmlreporter.config().setReportName("Test Report");
		htmlreporter.config().setTheme(Theme.DARK);
		htmlreporter.config().setTimeStampFormat("MM:DD:YY:hh:mm:s");
	}

	public static ExtentTest extentTest(ITestContext method) {
		return ExtentReporterClass.reporter.createTest(method.getName());
	}

	public static String datetime() {
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd_MM_yyyy_hh_mm_ss");
		String formattedDate = myDateObj.format(myFormatObj);
		return formattedDate;

	}

}
