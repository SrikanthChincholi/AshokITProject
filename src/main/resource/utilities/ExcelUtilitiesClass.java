package utilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilitiesClass {

	static String filepath = ".\\DataFiles\\LoginData.xlsx";
	static FileInputStream fis;

	public static Object[][] readData() throws Exception {
		fis = new FileInputStream(filepath);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("LoginData");
		XSSFRow row;
		XSSFCell cell;
		int rowcount = sh.getPhysicalNumberOfRows();
		int colcount = sh.getRow(0).getPhysicalNumberOfCells();

		Object[][] data = new Object[rowcount-1][colcount];

		for (int i = 0; i < rowcount-1; i++) {
			row = sh.getRow(i+1);
			for (int j = 0; j < colcount; j++) {
				cell = row.getCell(j);
				DataFormatter format = new DataFormatter();
				data[i][j] = format.formatCellValue(cell);

			}
		}
		return data;

	}

	//@Test
	public static void readDataFromExcel() throws Exception {
		Object[][] exceldata = readData();
		for (Object[] row : exceldata) {
			for (Object cell : row) {
				System.out.print(cell.toString()+ " ");
			}
			System.out.println();
		}
	}

}
