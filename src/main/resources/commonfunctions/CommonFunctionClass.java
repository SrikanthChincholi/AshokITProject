package commonfunctions;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import baseclass.BaseClass;

public class CommonFunctionClass extends BaseClass {

	public static String captureScreenshot() throws Exception {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File srcfile = ((TakesScreenshot) d).getScreenshotAs(OutputType.FILE);
		File dest = new File(System.getProperty("user.dir") + "\\Screens\\" + format.format(cal.getTime()) + ".png");
		FileUtils.copyFile(srcfile, dest);
		return dest.getAbsolutePath();
	}

	public static WebElement getElement(By by) {
		WebElement ele = d.findElement(by);
		if (ele.isDisplayed()) 
			return ele;
		return null;
	}
		

}
