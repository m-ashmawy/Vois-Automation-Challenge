package utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * ExtentManager class manages the creation of ExtentReports instance for test reporting.
 */
public class ExtentManager {
	
	// Static variables for extent reports instance and spark reporter
	private static ExtentReports extent;
	private static ExtentSparkReporter spark;

	// File path for the report file
	private static String filePath = System.getProperty("user.dir")+"\\src\\test\\resources\\reports\\report-"+new SimpleDateFormat("yyyy-MM-dd-HHmmss").format(new Date())+".html";

    /**
     * Method to get the instance of ExtentReports.
     * @return ExtentReports instance.
     */
	public static ExtentReports getInstance() {
		if (extent == null)
			createInstance();
		return extent;
	}

	/**
     * Method to create the instance of ExtentReports.
     * @return ExtentReports instance.
     */
	private static ExtentReports createInstance() {
		extent = new ExtentReports();
		spark = new ExtentSparkReporter(filePath);
		extent.attachReporter(spark);
		return extent;
	}
	


}
