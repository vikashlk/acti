package Base.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import Mavenproject.ActiTime.Helper;
import browserfactory.Browserclass;



public class BaseClass {
	public  WebDriver  driver;
	public ExcelData  d;
	public  ConfigData configuration_data;
	public Helper h;
	public ExtentTest logg;
	public ExtentReports r;

	@BeforeSuite
	public  void getdata() throws Exception
	{
		Reporter.log("Test case configuring",true);
		
		d=new ExcelData();
		
		configuration_data= new ConfigData();
		
		ExtentSparkReporter report= new ExtentSparkReporter("./Report/result"+Helper.currentDate()+".html");
		report.config().setDocumentTitle("ActiReport");
		report.config().setReportName("Login case report");
		 r= new ExtentReports();
		r.attachReporter(report);
		r.setSystemInfo("Test engineer","vikas kumar M");
	}

	@Parameters("browser")
	@BeforeClass
	public  void base(String browser) throws Exception 
	{
		Browserclass b= new Browserclass();
		driver=b.browserLaunch(browser, configuration_data.config_url());

	}

	@AfterClass
	public  void  closebrowser() throws InterruptedException
	{
		
		Browserclass.tearDown(driver);
	}

	@AfterMethod
	public void capturesnap(ITestResult result ) {

		if(result.getStatus()==ITestResult.FAILURE) {

			Helper.Capturescreeshot(driver);

			logg.fail("Test is failed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreeshot(driver)).build());
			Reporter.log("Screenshot captured",true);
		}
		else if(result.getStatus()==ITestResult.SUCCESS) {
			Helper.Capturescreeshot(driver);
			logg.pass("Test is passed",MediaEntityBuilder.createScreenCaptureFromPath(Helper.Capturescreeshot(driver)).build());
			Reporter.log("Screenshot captured",true);
		}


		
		Reporter.log("Test case run is succesfull>>>..",true);

		r.flush();


	}

}
