package com.mystore.testcases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.mystore.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	ReadConfig config = new ReadConfig();
	
	String url = config.getUrl();
	String browser = config.getBrowser();
	
	public static WebDriver driver;
	public static Logger logger;
	
	
	@BeforeClass
	public void setUp() {

		switch(browser.toLowerCase()) {
			
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				break;
				
//			case "edge":
//				WebDriverManager.chromedriver().setup();
//				driver = new EdgeDriver();
//				driver.manage().window().maximize();
			
			default:
				driver = null;
				break;
	}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		logger = LogManager.getLogger("MyStoreV1");
		
		driver.get(url);
		
		logger.info("Url Opened");
	
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.close();
		driver.quit();
		
	}
	
	public static void captureScreenshot(WebDriver driver, String testName) throws IOException {
        // Format timestamp for unique filename
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String filePath = System.getProperty("user.dir") + "//screenshot//" + testName + ".png";

            // Take screenshot
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            // Save screenshot
            FileUtils.copyFile(srcFile, new File(filePath));
            System.out.println("Screenshot saved: " + filePath);
       
        }
    
	
	

}
