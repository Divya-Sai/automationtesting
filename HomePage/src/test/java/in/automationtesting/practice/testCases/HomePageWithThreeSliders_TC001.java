package in.automationtesting.practice.testCases;

import java.awt.Dimension;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import in.automationtesting.practice.pageObjects.HomePage;
import in.automationtesting.practice.testBase.BaseClass;

public class HomePageWithThreeSliders_TC001  extends BaseClass{

	@Test(priority = 1,enabled = true,description = "setURL")
	public void setURL() throws Exception {
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();

		//driver.findElement(By.xpath(".//ul[@class='main-nav']/li[contains(.,'Shop')]")).click();
	}


	@Test(priority = 2,enabled = true,description = "Click on Shop Menu") 
	public void clickOnShopMenu() throws Exception {
		Thread.sleep(3000);
		homepage = new HomePage(driver);
		homepage.clickOnMainNav("shop");
		Thread.sleep(3000);
		takeScreenshot(driver, "ShopPage");
		Thread.sleep(3000);
		String titleofthepage  =driver.getTitle();
		System.out.println(titleofthepage);
		Assert.assertEquals("Products – Automation Practice Site", titleofthepage);
		homepage.clickOnNav("Home");
	}

	@Test(priority = 3,enabled=true,description = "Sliders")
	public void verifySlider() {
		homepage.getSliders();
		//Assert.assertEquals("3", expected);;
	}



}
