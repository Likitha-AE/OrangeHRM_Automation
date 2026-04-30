package generic_utilities;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerImplementaion implements ITestListener {
	ExtentReports report;
	ExtentTest test;

	public static ThreadLocal<ExtentTest> extent=new ThreadLocal<ExtentTest>();

	@Override
	public void onTestStart(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		test = report.createTest(methodName);
		extent.set(test);
		extent.get().log(Status.INFO, methodName+" execution starts");

	}

	@Override
	public void onTestSuccess(ITestResult result) {

		String methodName = result.getMethod().getMethodName();
		extent.get().log(Status.PASS, methodName+" ---> passed");


	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			String methodName = result.getMethod().getMethodName();
			String fileName = methodName+new JavaUtils().sysDateTime();

			String filepath = "C:\\Users\\LikithaHE\\Downloads\\src\\test\\resources\\screenshot"+fileName+".png";
			TakesScreenshot ts=(TakesScreenshot)BaseClass.sdriver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			File des = new File(filepath);

			FileHandler.copy(src, des);
			String path = des.getAbsolutePath();

			extent.get().addScreenCaptureFromPath(path);

			extent.get().log(Status.FAIL, result.getThrowable());
			extent.get().log(Status.FAIL,methodName+"--->failed");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String methodName = result.getMethod().getMethodName();
		extent.get().log(Status.SKIP, methodName+"---->Skipped");

	}

	@Override
	public void onStart(ITestContext context) {
		ExtentSparkReporter htmlreport = new ExtentSparkReporter("./ExtentReport/report"+new JavaUtils().sysDateTime()+".html");
		htmlreport.config().setDocumentTitle("Automation_Report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setReportName("OrangHRM");

		report=new ExtentReports();
		report.attachReporter(htmlreport);
		report.setSystemInfo("base_browser", "chrome");
		report.setSystemInfo("base_platform", "windows");
		report.setSystemInfo("base_url", "https://opensource-demo.orangehrmlive.com/");
		report.setSystemInfo("reporter_Name", "Likitha");
	}

	@Override
	public void onFinish(ITestContext context) {

		report.flush();
	}
}