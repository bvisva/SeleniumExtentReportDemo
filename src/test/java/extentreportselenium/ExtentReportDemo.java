package extentreportselenium;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportDemo {
	
	//public ExtentReports extent;
	//public ExtentSparkReporter spark;
	
	@Test
	public void loginTest() {

		//ExtentTest logger = extent.createTest("LoginTest");
		//logger.log(Status.INFO, "Login to amazon");
		//logger.log(Status.PASS, "Get Title amazon");
		//logger.log(Status.PASS, "Title verified");
	}

	@Test
	public void loginTestOne() {

		//ExtentTest logger1 = extent.createTest("LoginTest1");
		//logger1.log(Status.INFO, "Login to amazon");
		//logger1.log(Status.PASS, "Get Title amazon");
		//logger1.log(Status.PASS, "Title verified");
	}
	
	
	  @Test(dataProvider = "dp")
	  public void f(Integer n, String s) {
		  
		  System.out.println("I am in dataprovider parameter Method" +" - "+"f");
		  
	  }
	  
	  @BeforeSuite(alwaysRun = true)
	  public void beforeSuite(ITestContext context) {
		/* extent = new ExtentReports();
	       spark = new ExtentSparkReporter("target/Spark/Spark.html");
	       extent.attachReporter(spark);*/   
	       System.out.println("I am in beforeSuite Method" +" - "+"beforeSuite");
		  
	  }

	  @AfterSuite
	  public void afterSuite() {
		//  extent.flush();
		  System.out.println("I am in afterSuite Method" +" - "+"afterSuite");
	  }

	  
	  
	  @BeforeMethod
	  public void beforeMethod() {
		  System.out.println("I am in beforeMethod Method" +" - "+"beforeMethod"); 
	  }

	  @AfterMethod
	  public void afterMethod() {
		  System.out.println("I am in afterMethod Method" +" - "+"afterMethod"); 
	  }


	  //@factory annotaiton can be used to dynamically runtime run test classes with or without arguments passed by returning object array
	  // class may need to be registered in xml test suite file
	  //@factory cna be combined with @dataprovider in class constructor can be used
	  //to run the same test class test methods with different set of values 
	  
	  @DataProvider
	  public Object[][] dp() {
	    return new Object[][] {
	      new Object[] { 1, "a" },
	      new Object[] { 2, "b" },
	    };
	  }
	  
	  
	  @BeforeClass
	  public void beforeClass() {
		  System.out.println("I am in beforeClass Method" +" - "+"beforeClass"); 
	  }

	  @AfterClass
	  public void afterClass() {
		  System.out.println("I am in afterClass Method" +" - "+"afterClass");
	  }

	  @BeforeTest
	  public void beforeTest() {
		  
		 
		  
		  System.out.println("I am in beforeTest Method" +" - "+"beforeTest");
	  }

	  @AfterTest
	  public void afterTest() {
		  
		  System.out.println("I am in afterTest Method" +" - "+"afterTest");
	  }

	
	 

}
