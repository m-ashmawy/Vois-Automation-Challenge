package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

/**
 * ReadExternalData class provides methods to read test data from an Excel file.
 */
public class ReadExternalData {

	/**
     * DataProvider method to fetch test data from an Excel file.
     * @param m The method for which test data is being fetched.
     * @return 2D array of test data.
     * @throws EncryptedDocumentException if the Excel file is encrypted.
     * @throws IOException if an I/O error occurs.
     */
	@DataProvider(name="testdata")
	public String[][] getXLSData(Method m) throws EncryptedDocumentException, IOException {

		// Path to the Excel file
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\testdata.xlsx");
		FileInputStream fis = new FileInputStream(f);
	    Workbook wb = WorkbookFactory.create(fis);

		// Get the sheet corresponding to the method name
	    Sheet sheetName = wb.getSheet(m.getName());
	    int totalRows = sheetName.getLastRowNum();
	    Row firstRow = sheetName.getRow(0);
	    int totalCols = firstRow.getLastCellNum();
	    
		// Initialize a DataFormatter to format and read cell values
	    DataFormatter format = new DataFormatter();
	    String[][] testData = new String[totalRows][totalCols];
	    for(int i=1;i<=totalRows;i++) {
	    	for(int j=0;j<totalCols;j++) {
	    		testData[i-1][j]=format.formatCellValue(sheetName.getRow(i).getCell(j));
	    	}
	    }
	    return testData;
	}

}
