package in.automationtesting.practice.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import in.automationtesting.practice.pageObjects.HomePage;
import in.automationtesting.practice.pageObjects.MyAccountPage;
import in.automationtesting.practice.testBase.BaseClass;

public class MyAccountLogin_TC008  extends BaseClass{
	
	@Test(priority = 1,enabled = true,description = "setURL")
	public void setURL() throws Exception {
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		logger.info("Entering URL");

		//driver.findElement(By.xpath(".//ul[@class='main-nav']/li[contains(.,'Shop')]")).click();
	}


	@Test(priority = 2,enabled = true,description = "Click on My Account Menu") 
	public void clickOnMyAccMenu() throws Exception {
		Thread.sleep(3000);
		homepage = new HomePage(driver);
		homepage.clickOnMainNav("My Account");
		Thread.sleep(3000);
		takeScreenshot(driver, "MY Account");
		Thread.sleep(3000);
		String titleofthepage  =driver.getTitle();
		System.out.println(titleofthepage);
		Assert.assertEquals("My Account � Automation Practice Site", titleofthepage);
		logger.info("Successfully entered into My Account Menu");
		
	}

	
	@Test(priority = 3,enabled = false,description = "Click on Register")
	public void registeration() throws InterruptedException, IOException {
		
		/*
		 * accPage = new MyAccountPage(driver); String Email = accPage.generateEmail();
		 * 
		 * accPage.setRegister(Email, "Divvyaaa"); Thread.sleep(3000);
		 * takeScreenshot(driver, "Registration");
		 */
		
		accPage = new MyAccountPage(driver);
		accPage.setRegister("divya.1234@gmail.com", "SaiBa8kat");
		accPage.clickonRegister();
		
	
	}
	
	@Test(priority = 3,enabled = true,description = "Click on Register")
	public void Login() throws InterruptedException, IOException {
		
		/*
		 * accPage = new MyAccountPage(driver); String Email = accPage.generateEmail();
		 * 
		 * accPage.setRegister(Email, "Divvyaaa"); Thread.sleep(3000);
		 * takeScreenshot(driver, "Registration");
		 */
		
		accPage = new MyAccountPage(driver);
		accPage.getLogin("divya.1234@gmail.com", "SaiBa8kat");
		
		//accPage.clickonRegister();
		accPage.clickLogin();
		if(driver.getPageSource().contains("ERROR")) {
			driver.close();
			Assert.assertTrue(false);
			logger.info("Please login with valid credentials");
        } else {
            Assert.assertEquals("My Account � Automation Practice Site", driver.getTitle());
        }
        
		}
	
	@Test(priority = 4,enabled=true,description = "Logout")
	
	public void logOut() throws InterruptedException {
		accPage.clickLogout();
		driver.navigate().back();
		if(driver.getPageSource().contains("Username or email address ")) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
		}
	}
		
		
	
	}


