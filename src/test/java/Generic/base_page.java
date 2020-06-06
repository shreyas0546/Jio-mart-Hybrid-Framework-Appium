package Generic;



import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class base_page {
	
	public AndroidDriver<AndroidElement> driver;
	
	public base_page(AndroidDriver<AndroidElement> driver) {
		this.driver=driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
}
