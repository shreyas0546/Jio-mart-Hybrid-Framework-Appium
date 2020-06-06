package Regression_Tests;

import org.testng.annotations.Test;
import Generic.generic_test;
import Pom_Classes.home_page;

public class Test1 extends generic_test{
	
	@Test
	public void scenario() throws InterruptedException {
		test=reports.createTest("Test started", "Sccenario1");
		test.info("Test started");
		home_page a=new home_page(driver);
		a.clickOnAccept();
		test.pass("Clicked on accept");
		a.clickOnNext();
		test.pass("Clicked on next");
		//a.clickOnNoThanks();
		test.pass("Clicked on No thanks");
		a.clickOnSearch();
		test.pass("Clicked on search");
		test.info("Test ended");
	}
}
