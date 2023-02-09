package dataprovider;

import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import config.DBConfig;
import config.EmployeeClass;
import utilities.ExcelUtilitiesClass;

public class DataProviderClass {

	@DataProvider(name = "login")
	public Object[][] logindata() {
		return new Object[][] { { "Dashboard" }, { "Dashboard" }, { "Dashboard123" } };
	}

	@DataProvider(name = "exceldatadp")
	public Object[][] exceldata() throws Exception {

		{
			return ExcelUtilitiesClass.readData();
		}
	}

	@DataProvider(name = "dbdata")
	public Iterator<EmployeeClass> dbdetails() throws Exception {

		{
			Iterator<EmployeeClass> itr = DBConfig.dbconfig().iterator();
			return itr;
		}
	}
}
