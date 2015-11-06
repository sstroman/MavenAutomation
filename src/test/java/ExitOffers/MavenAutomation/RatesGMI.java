package ExitOffers.MavenAutomation;

import java.net.URL;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RatesGMI {
	
	public static WebDriver driver;
	
	
	     
	  @Test
	  public void testRatesGetMyInsurance() throws Exception {
		  
		  DesiredCapabilities caps = new DesiredCapabilities();
  			caps.setCapability("name", "Run me on Chrome");
  			caps.setCapability("build", "1.0");
  			caps.setCapability("browser_api_name", "Chrome45");
  			caps.setCapability("os_api_name", "Win10");
  			caps.setCapability("screen_resolution", "1024x768");
  			caps.setCapability("record_video", "true");
  			caps.setCapability("record_network", "true");
  			caps.setCapability("record_snapshot", "false");
		    driver = new RemoteWebDriver(new URL("http://sstroman%40leadnomics.com:u2eecd8d888b0c95@hub.crossbrowsertesting.com:80/wd/hub"), caps);
		  
		  
			System.out.println("Navigating to Website");
			driver.navigate().to("http://staging.rates.getmyinsurance.com/?_s=QAautoKPXAsrcCakeCheapIns");
			//driver.navigate().to("http://rates.getmyinsurance.com/?_s=QAautoKPXAsrcCakeCheapInsf");
			System.out.println("Navigated to Website");
		
			System.out.println("Enter Phone Number");
			driver.findElement(By.cssSelector("input[type=\"tel\"]")).sendKeys("19115");
			System.out.println("Click submit");
			driver.findElement(By.cssSelector("button.submit.callToAction")).click();
    
			System.out.println("Switch to form");
    for (String winHandle : driver.getWindowHandles()) {
    	driver.switchTo().window(winHandle); }
    
    	System.out.println("Primary Vehicle");
    	WebDriverWait wait = new WebDriverWait(driver, 30);
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("select")));
    	new Select(driver.findElement(By.cssSelector("select"))).selectByVisibleText("2014");
    	new Select(driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset/fieldset/fieldset/fieldset/div[2]/div/div/select"))).selectByVisibleText("CADILLAC");
    	new Select(driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset/fieldset/fieldset/fieldset/div[3]/div/div/select"))).selectByVisibleText("CTS");
    	new Select(driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset/fieldset/fieldset/fieldset/div[4]/div/div/select"))).selectByVisibleText("Coupe");
       
    	System.out.println("Coverage");
    	driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset[2]/fieldset/fieldset/fieldset/label[3]/div")).click();
    
    	System.out.println("Currently Insured");
    	driver.findElement(By.cssSelector("#slide-wrapper-block-1 > div > fieldset.section.active > div:nth-child(2) > fieldset > fieldset > fieldset > label:nth-child(1) > span")).click();
    	new Select(driver.findElement(By.cssSelector("#slide-wrapper-block-1 > div > fieldset.section.active > div:nth-child(3) > fieldset > fieldset > fieldset > fieldset > div > div > div > select"))).selectByVisibleText("Esurance");
    	new Select(driver.findElement(By.cssSelector("#slide-wrapper-block-1 > div > fieldset.section.active > div:nth-child(4) > fieldset > fieldset > fieldset > fieldset > div > div > div > select"))).selectByVisibleText("3 years");

    	System.out.println("Personal Information");
    	driver.findElement(By.cssSelector("#first-name")).sendKeys("Test");
    	driver.findElement(By.cssSelector("#last-name")).sendKeys("Leadnomics");              
    	driver.findElement(By.cssSelector("#slide-wrapper-block-1 > div > fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();
    
    	System.out.println("Occupation");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("occupation-name")));
    	new Select(driver.findElement(By.id("occupation-name"))).selectByVisibleText("Professor");
    
    	System.out.println("Married");
    	driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset[6]/div/fieldset/label")).click();

    	System.out.println("Gender");
    	driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset[7]/div/fieldset/label/span")).click();
   
    	System.out.println("DOB");
    	driver.findElement(By.cssSelector("input.datepicker")).sendKeys("03/13/1986");
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();
    
    	System.out.println("Credit Rating");
    	driver.findElement(By.xpath("//div[@id='slide-wrapper-block-1']/div/fieldset[9]/div/fieldset/fieldset/div[2]/label/span")).click();
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();

    	System.out.println("Good Driver");
    	driver.findElement(By.cssSelector("fieldset > fieldset > fieldset > fieldset > label > span.overlay")).click();
    
    	System.out.println("Email");
    	driver.findElement(By.id("email")).sendKeys("test@leadnomics.com");
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();

    	System.out.println("Address");
    	driver.findElement(By.id("address")).sendKeys("123 ABC Street");
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();

    	//Zip Code - should be pre-populated - not entering data here
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();
    
    	//City - should be pre-populated - not entering data here
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();

    	//State - should be pre-populated - not entering data here
    	driver.findElement(By.cssSelector("fieldset.section.active > div.pagenav.onePageHide > button.btn.next")).click();

    	System.out.println("Phone");
    	driver.findElement(By.cssSelector("span.phone0 > input[type=\"tel\"]")).sendKeys("458");
    	driver.findElement(By.cssSelector("span.phone1 > input[type=\"tel\"]")).sendKeys("958");
    	driver.findElement(By.cssSelector("span.phone2 > input[type=\"tel\"]")).sendKeys("4579");

    	System.out.println("Homeowner");
    	driver.findElement(By.cssSelector("div.field.control-group > fieldset > fieldset > label > span.overlay")).click();
    
    	System.out.println("Local Agent");
    	driver.findElement(By.cssSelector("div.field.control-group > label > span.overlay")).click();
    	driver.findElement(By.cssSelector("div.cta-section > button.btn.next")).click();
    
    	//No banner on prod
    	System.out.println("Offers Page");
    	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ckContainer")));
    	driver.findElement(By.id("ckContainer"));	     
    
    	
    	System.out.println("Test Complete");
    	driver.quit();
	  }
}
   


