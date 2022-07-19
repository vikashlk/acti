package Mavenproject.ActiTime;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class Helper {
	
	
	
	public static String Capturescreeshot(WebDriver driver) {
		String ScreanShotpath;
		
		ScreanShotpath=System.getProperty("user.dir")+"/Screenshot/Actitime"+currentDate()+".jpg";
		
		TakesScreenshot shot=(TakesScreenshot) driver;
		
		File src = shot.getScreenshotAs(OutputType.FILE);
		File dest= new File(ScreanShotpath);
		try {
			FileUtils.copyFile(src, dest);
			
		} catch (IOException e) {
			System.out.println("unable to take Screenshot");
		}
		return ScreanShotpath;
		
		
		
	}
	
	public static String currentDate() {
		Date d= new Date();
		
	DateFormat	currentdate= new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
	
	return currentdate.format(d);
		
	}
	
//	public ExtentReports Reports() {
//		ExtentSparkReporter report= new ExtentSparkReporter("./Report/result"+currentDate()+".html");
//		
//		report.config().setDocumentTitle("ActiReport");
//		report.config().setReportName("Login case report");
//		ExtentReports r= new ExtentReports();
//		r.attachReporter(report);
//		r.setSystemInfo("Test engineer","vikas kumar M");
//		return r;	
//		
//	}
	

}
