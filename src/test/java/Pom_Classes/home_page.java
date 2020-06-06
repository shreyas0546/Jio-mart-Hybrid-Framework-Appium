package Pom_Classes;

import org.openqa.selenium.support.PageFactory;

import Generic.base_page;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;


public class home_page extends base_page {
	
	public AndroidDriver<AndroidElement> driver;
	
	@AndroidFindBy(xpath="//android.widget.Button[@text='Accept & continue']")
	private AndroidElement accept;
	@AndroidFindBy(xpath="//android.widget.Button[@text='No, thanks']")
	private AndroidElement noThanks;
	@AndroidFindBy(xpath="//android.widget.Button[@text='Next']")
	private AndroidElement next;
	@AndroidFindBy(xpath="//android.widget.EditText[@text='Search or type web address']")
	private AndroidElement search;
	@AndroidFindBy(xpath="//android.widget.TextView[@text='https://www.flipkart.com']")
	private AndroidElement flipkart;
	
	public home_page(AndroidDriver<AndroidElement> driver) {
		super(driver);
	}
	
	
	public void clickOnAccept() {
		accept.click();
	}
	public void clickOnNext() {
		next.click();
	}
	public void clickOnNoThanks() {
		noThanks.click();
	}
	public void clickOnSearch() throws InterruptedException {
		search.click();
		search.sendKeys("https://www.flipkart.com");
		flipkart.click();
	}
}
