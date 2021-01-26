package in.automationtesting.practice.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MyAccountPage {
	
	public WebDriver driver;
	
	public MyAccountPage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
	}
	
	//WebElements
	@FindBy(id="reg_email")
	WebElement txtregEmail;
	
	@FindBy(id="reg_password")
	WebElement txtregPassword;
	
	@FindBy(xpath=".//input[@name='register']")
	WebElement btnRegister;
	
	@FindBy(id="username")
	WebElement txtuserName;
	
	@FindBy(id="password")
	WebElement txtPassword;

	@FindBy(xpath=".//input[@name='login']")
	WebElement btnlogin;	
	
	@FindBy(xpath=".//a[contains(.,'Logout')]")
	WebElement btnLogout;
	
	
	
	public void setRegister(String rEmail,String rPassword) {
		txtregEmail.sendKeys(rEmail);
		txtregPassword.sendKeys(rPassword);
	}
	
	public void clickonRegister() {
		btnRegister.click();
	}
	
	public  String generateEmail() {
		String email =RandomStringUtils.randomAlphabetic(5);
		return email+"@gmail.com";
	}
	
	public void getLogin(String emailId,String Password)  {
		txtuserName.sendKeys(emailId);
		txtPassword.sendKeys(Password);
		
		
	}
	
	public void clickLogin() throws InterruptedException{
		
		Thread.sleep(3000);
		btnlogin.click();
	}
	
	public void clickLogout() throws InterruptedException {
		Thread.sleep(3000);
		btnLogout.click();
	}
	

}
