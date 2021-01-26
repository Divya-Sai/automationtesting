package in.automationtesting.practice.testCases;

import org.testng.annotations.Test;

import in.automationtesting.practice.pageObjects.HomePage;
import in.automationtesting.practice.testBase.BaseClass;

public class HomePageWithThreeArrivals extends BaseClass {
	
	
	@Test(priority = 1,enabled=true,description="HomePageNavigation")
	public void homepagenav() throws Exception {
		homepage = new HomePage(driver);
		homepage.clickOnMainNav("shop");
		homepage.clickOnNav("Home");
	}

}
