package Generic;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;


public class generic_test implements Auto_Const {
	
	public AndroidDriver<AndroidElement> driver;
	public static ExtentHtmlReporter htmlreporter;
	public static ExtentReports reports;
	public static ExtentTest test; 
	public screenshot sc=new screenshot();
	
	 @BeforeSuite
	 public void setup(){
		htmlreporter=new ExtentHtmlReporter("./Extent Reports/report.html");
	    reports=new ExtentReports();
	    reports.attachReporter(htmlreporter);
	 }
	 
	@BeforeMethod
	public void capabilities() throws MalformedURLException {
		
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.UDID, udid);
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, automation_name);
		cap.setCapability(MobileCapabilityType.VERSION, version);
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, platform);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device_name);
		cap.setCapability("appPackage", app_package);
		cap.setCapability("appActivity", app_activity);
		
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap); 
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@AfterMethod
	public void quit(ITestResult res) throws IOException {
		if(ITestResult.FAILURE==res.getStatus()){
			String test_name = res.getName();
			sc.capture(driver, test_name);
			test.fail("Test case failed",
					MediaEntityBuilder.createScreenCaptureFromPath(new screenshot().capture(driver, test_name)).build());
		}
			if(null != driver) {
				driver.quit();
			}
		
	}
	
	@AfterSuite
	public void tearDown() {
		reports.flush();
	}
}
