package in.automationtesting.practice.pageObjects;

import java.nio.file.spi.FileSystemProvider;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	public WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(xpath=".//ul[@class='main-nav']/li[contains(.,'Shop')]")
	 WebElement shop;
	
	@FindBy(xpath=".//ul[@class='main-nav']/li[contains(.,'My Account')]")
	 WebElement myAccount;
	
	@FindBy(xpath=".//ul[@class='main-nav']/li[contains(.,'Test Cases')]")
	 WebElement testCases;
	
	@FindBy(xpath=".//ul[@class='main-nav']/li[contains(.,'AT Site')]")
	 WebElement atSites;
	
	@FindBy(xpath=".//ul[@class='main-nav']/li[contains(.,'Demo Site')]")
	 WebElement demoSite;
	
	//Shop Page WebElements
	@FindBy(xpath=".//nav[@class='woocommerce-breadcrumb']/a[contains(.,'Home')]")
	WebElement navToHomePage;
	
	@FindBy(xpath=".//div[@class='n2-ss-slide-background']")
	WebElement sliders;
		
     public void clickOnMainNav(String Nav) throws Exception {
    	 if(Nav.equalsIgnoreCase("shop")) {
    		 shop.click(); 
    	 }
    	 else if (Nav.equalsIgnoreCase("My Account")) {
			myAccount.click();
		}
    	 else if (Nav.equalsIgnoreCase("Test Cases")) {
    		 testCases.click();
		}
    	 else if (Nav.equalsIgnoreCase("AT Site")) {
			atSites.click();
		}
    	 else if (Nav.equalsIgnoreCase("Demo Site")) {
			demoSite.click();
		}
    	 else {
			throw new Exception("Navigation title should be provided");
		}
     }
     
     public void clickOnNav(String dir) throws Exception {
    	 if (dir.equalsIgnoreCase("Home")) {
			navToHomePage.click();
		}
    	 else {
			throw new Exception("Navigation need to be provided");
		}
     }
     
     public void getSliders() {
 		Dimension Slider = sliders.getSize();
 		System.out.println(sliders.getSize());
 	}
     
     
     
}
