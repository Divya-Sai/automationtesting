package in.automationtesting.practice.testBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import in.automationtesting.practice.pageObjects.HomePage;
import in.automationtesting.practice.pageObjects.MyAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public  WebDriver driver;
	public Properties prop;
	public HomePage homepage;
	public MyAccountPage accPage;
	public Logger logger = LogManager.getLogger(this.getClass()) ;
	
	
	@BeforeClass
	@Parameters("browser")
	public  void setUp(String browserName) throws IOException {
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\HybridDrivenFramework\\HomePage\\src\\test\\resources\\config.properties");
		prop.load(fis);
		
		if(browserName.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}
	
	public void takeScreenshot(WebDriver driver ,String ssName) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src =ts.getScreenshotAs(OutputType.FILE);
		File trg = new File(".\\Screenshot"+ssName+".png");
		FileUtils.copyFile(src, trg);
	}
	
	

}
