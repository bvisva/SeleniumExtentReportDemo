package extentreportselenium;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyTestListner implements ITestListener {	
	
	 protected static WebDriver driver;
	 protected static ExtentReports reports = new ExtentReports();
	 protected static ExtentSparkReporter spark;
	 protected static ExtentTest test;
	 //extent = new ExtentReports();
	     
	
	 public void onTestStart(ITestResult result) {
	 
	 System.out.println("on test start");
	 test = reports.createTest(result.getMethod().getMethodName());
	 test.log(Status.INFO, result.getMethod().getMethodName() + "test is started");
	 }
	
	 public void onTestSuccess(ITestResult result) {
	
	  System.out.println("on test success");
	  test.log(Status.PASS, result.getMethod().getMethodName() + "test is passed");
	}
	
	 public void onTestFailure(ITestResult result) {
	
	  System.out.println("on test failure");
	  test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed");
	  TakesScreenshot ts = (TakesScreenshot) driver;
	  File src = ts.getScreenshotAs(OutputType.FILE);
	  try {
      String imageFile = "target/Spark/Images/"+ result.getMethod().getMethodName() + ".png"; 		  
	  FileHandler.copy(src, new File(imageFile)); 		  
	  //FileHandler.copy(src, new File("C:\\images\\" + result.getMethod().getMethodName() + ".png"));
	  //String file = test.addScreenCaptureFromPath("C:\\images\\" + result.getMethod().getMethodName() + ".png");
	  test.addScreenCaptureFromPath(imageFile);
	  test.pass(MediaEntityBuilder.createScreenCaptureFromPath(imageFile).build());
	  //test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed", file);
	  test.log(Status.FAIL, result.getMethod().getMethodName() + "test is failed" + result.getThrowable().getMessage());
	  } catch (IOException e) {
	  e.printStackTrace();
	  }
	 }
	
	 public void onTestSkipped(ITestResult result) {
	 System.out.println("on test skipped");
	 test.log(Status.SKIP, result.getMethod().getMethodName() + "test is skipped");
	 }
	
	 public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	 System.out.println("on test sucess within percentage");
	 }
	
	 public void onStart(ITestContext context) {
		 spark = new ExtentSparkReporter("target/Spark/Spark.html");
    	 reports.attachReporter(spark);  
	 //System.out.println("on start");
	 //driver = new ChromeDriver(); // Set the drivers path in environment variables to avoid code(System.setProperty())
	 //reports = new ExtentReports(new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
	 }
	
	 public void onFinish(ITestContext context) {
	 System.out.println("on finish");
	 //driver.close();
	 //reports.endTest(test);
	 reports.flush();
	}
	
}
