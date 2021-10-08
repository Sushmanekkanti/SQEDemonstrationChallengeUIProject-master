package com.sample.test.demo;

import static org.testng.Assert.fail;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.support.ui.Select; 

public class TestBase {

    private Configuration config;
    protected static WebDriver driver;
    protected String url;

    @BeforeClass(alwaysRun = true)
    public void init() throws Throwable {
        config = new Configuration();
        url = config.getUrl();
        initializelDriver();
        navigateToSite();
             
    }

    private void navigateToSite() throws InterruptedException {
        driver.get(url);
        //driver.navigate().to(url);
        //driver.manage().window().maximize();
        Thread.sleep(5000);
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        try {
            driver.quit();

        } catch (Exception e) {
        }
    }

    private void initializelDriver() {
        if (config.getBrowser().equalsIgnoreCase("chrome")) {
            if (config.getPlatform().equalsIgnoreCase("mac")) {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/mac/chromedriver.exe");
            } else {
                System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver/windows/chromedriver.exe");
            }
            driver = new ChromeDriver();
        }
        else {
            fail("Unsupported bfrowser " + config.getBrowser());
        }
       
    }

    
    
    //enterText_id method
    //parameters locator id, String value
    public static boolean enterText_id(String id, String value){
    	try {  
            driver.findElement(By.id(id)).sendKeys(value);
         	return true;
    	    	}
    	catch (Exception e){
    		return false;
    	    	}
    
    }
    
    //dropdownSelect_id method
    //parameters locator id, String value
    public static boolean dropdownSelect_id(String id, String value){
    	try {  
    		Select dropdown = new Select(driver.findElement(By.id(id))); 
 	       dropdown.selectByVisibleText(value);
         	return true;
    	    	}
    	catch (Exception e){
    		return false;
    	    	}
    
    }
    
     //dropdownSelect_xpath method
    //parameters locator xpath, String value
    public static boolean dropdownSelect_xpath(String xpath, String value){
    	try {  
    		Select dropdown = new Select(driver.findElement(By.xpath(xpath))); 
 	       dropdown.selectByVisibleText(value);
         	return true;
    	    	}
    	catch (Exception e){
    		return false;
    	    	}
    
    }
    
    //click_id method
    //parameters locator id
    public static boolean click_id(String id){
    	try {  
    		driver.findElement(By.id(id)).click();
         	return true;
    	    	}
    	catch (Exception e){
    		return false;
    	    	}
    
    }
    
    //verifyText_id method
    //parameters id, ExpectedValue
    public static boolean verifyText_id(String id,String ExpectedValue){
    	try {  
    		String orderpopup = driver.findElement(By.id("dialog")).getText();
    		if (ExpectedValue.equals(orderpopup)) {
                System.out.println(ExpectedValue);
           }
           else {
          	 System.out.println("Fail:Some values Missing"+orderpopup);
           }
         	return true;
    	    	}
    	catch (Exception e){
    		return false;
    	    	}
    
    }
    
}
