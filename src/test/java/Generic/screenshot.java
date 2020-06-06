package Generic;

import java.io.File;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class screenshot 
{
	public String capture(WebDriver driver, String test_name)
	{
		Date d=new Date();
		String date = d.toString().replace(":", "-");
		String path=System.getProperty("user.dir")+"./Defects/"+date+test_name+".jpeg";
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(path);
		try
		{
			FileHandler.copy(src, dest);
		}
		catch(Exception e)
		{
			Reporter.log("Failed to take screenshot", true);	
		}
		return path;
	}
}
