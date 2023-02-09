package Utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter(ConstantUtils.EXTENT_FOLDER + SeleniumUtils.getReportName());
        reporter.config().setReportName("BikeXpert REPORT");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("AUTHOR", "Maria Stransky");
        extentReports.setSystemInfo("ENV", "local");
        extentReports.setSystemInfo("OS NAME", System.getProperty("os.name"));
        extentReports.setSystemInfo("OS VERSION", System.getProperty("os.version"));
        return extentReports;
    }

}
