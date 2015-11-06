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


public class QuotesGMI{
	
	public static WebDriver driver;
	

	 @Test 
	 public void testUntitled() throws Exception {
		 
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
	driver.navigate().to("http://staging.quotes.getmyinsurance.com/?_s=QAautoMultiPageA");
	//driver.navigate().to("https://quotes.getmyinsurance.com/?_s=QAautoMultiPageA");
	System.out.println("Navigated to Website");
   
	System.out.println("Enter Zip");
    driver.findElement(By.cssSelector("input[type=\"tel\"]")).sendKeys("19103");
    
    System.out.println("Submit Lander");   
    driver.findElement(By.cssSelector("button.submit.callToAction")).click();
    
	System.out.println("Switch to form");
	for (String winHandle : driver.getWindowHandles()) {
		driver.switchTo().window(winHandle); }
    
	System.out.println("What type of vehicle do you drive?");
    WebDriverWait wait = new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-year")));
    new Select(driver.findElement(By.id("vehicle-year"))).selectByVisibleText("2011");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-make")));
    new Select(driver.findElement(By.id("vehicle-make"))).selectByVisibleText("AUDI");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-model")));
    new Select(driver.findElement(By.id("vehicle-model"))).selectByVisibleText("A5 QUATTRO PREMIUM");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("vehicle-style")));
    new Select(driver.findElement(By.id("vehicle-style"))).selectByVisibleText("Convertible");
    driver.findElement(By.cssSelector("button.btn.next")).click();
    
    System.out.println("Vehicle details - Part 2");
    new Select(driver.findElement(By.id("vehicle-own"))).selectByVisibleText("Leased");
    new Select(driver.findElement(By.id("vehicle-daily"))).selectByVisibleText("1-5 Miles");
    new Select(driver.findElement(By.id("annual-mileage"))).selectByVisibleText("5,000 - 7,500 miles");
    new Select(driver.findElement(By.id("collision-deductible"))).selectByVisibleText("$ 50");
    new Select(driver.findElement(By.id("comprehensive-deductible"))).selectByVisibleText("$ 100");
    
    System.out.println("Additional Vehicle");
    driver.findElement(By.cssSelector("fieldset.prehide > div.section > div.pagenav > button.btn.add")).click();
    new Select(driver.findElement(By.id("vehicle-year"))).selectByVisibleText("2014");
    new Select(driver.findElement(By.id("vehicle-make"))).selectByVisibleText("FORD");
    new Select(driver.findElement(By.id("vehicle-model"))).selectByVisibleText("F150");
    new Select(driver.findElement(By.id("vehicle-style"))).selectByVisibleText("Pickup");
    driver.findElement(By.cssSelector("button.btn.next")).click(); 
    new Select(driver.findElement(By.id("vehicle-own"))).selectByVisibleText("Owned");
    driver.findElement(By.cssSelector("fieldset.prehide > div.section > div.pagenav > button.btn.next")).click();
    
    System.out.println("Coverage Options");
    new Select(driver.findElement(By.id("coverage-level"))).selectByVisibleText("Superior Coverage");
    new Select(driver.findElement(By.id("currently-insured"))).selectByVisibleText("No");
    new Select(driver.findElement(By.id("currently-insured"))).selectByVisibleText("Yes");
    new Select(driver.findElement(By.id("InsuranceCompany"))).selectByVisibleText("AAA Insurance Co.");
    new Select(driver.findElement(By.cssSelector("div.splitContainer > select"))).selectByVisibleText("February");
    new Select(driver.findElement(By.xpath("//form[@id='the-form']/fieldset/fieldset/fieldset[2]/fieldset/div/fieldset/div/div[2]/div/select[2]"))).selectByVisibleText("2021");
    new Select(driver.findElement(By.id("start-date"))).selectByVisibleText("3 years");
    driver.findElement(By.xpath("//form[@id='the-form']/fieldset/fieldset/fieldset[2]/fieldset/div/div[2]/button")).click();

    System.out.println("Driver Details");
    driver.findElement(By.id("first-name")).sendKeys("TestA");
    driver.findElement(By.id("last-name")).sendKeys("LeadnomicsA");
    new Select(driver.findElement(By.cssSelector("div.section > div.row > div.field.control-group > div.splitContainer > select"))).selectByVisibleText("Jan");
    new Select(driver.findElement(By.xpath("//form[@id='the-form']/fieldset[2]/fieldset/fieldset/div[2]/div[2]/div[2]/div/select[2]"))).selectByVisibleText("1");
    new Select(driver.findElement(By.xpath("//form[@id='the-form']/fieldset[2]/fieldset/fieldset/div[2]/div[2]/div[2]/div/select[3]"))).selectByVisibleText("1950");
    driver.findElement(By.name("Gender")).click();
    driver.findElement(By.name("MaritalStatus")).click();
    driver.findElement(By.name("MilitaryExperience")).click();
    new Select(driver.findElement(By.id("occupation-name"))).selectByVisibleText("Engineer");
    driver.findElement(By.cssSelector("fieldset.prehide > fieldset > div.section > div.pagenav > button.btn.next")).click();
    
    System.out.println("Driver Details - Part 2");
    new Select(driver.findElement(By.id("vehicle-id"))).selectByVisibleText("2011 AUDI A5 QUATTRO PREMIUM");
    		
    System.out.println("Additional Driver");
    driver.findElement(By.cssSelector("fieldset.prehide > fieldset > fieldset > fieldset > div.section > div.pagenav > button.btn.add")).click();
    driver.findElement(By.id("first-name")).sendKeys("TestB");
    driver.findElement(By.id("last-name")).sendKeys("LeadnomicsB");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("relationship")));
    driver.findElement(By.id("relationship")).sendKeys("Child");
    new Select(driver.findElement(By.cssSelector("div.section > div.row > div.field.control-group > div.splitContainer > select"))).selectByVisibleText("Feb");
    new Select(driver.findElement(By.xpath("//form[@id='the-form']/fieldset[2]/fieldset/fieldset/div[2]/div[2]/div[2]/div/select[2]"))).selectByVisibleText("2");
    new Select(driver.findElement(By.xpath("//form[@id='the-form']/fieldset[2]/fieldset/fieldset/div[2]/div[2]/div[2]/div/select[3]"))).selectByVisibleText("1970");
    driver.findElement(By.name("Gender")).click();
    driver.findElement(By.name("MaritalStatus")).click();
    driver.findElement(By.name("MilitaryExperience")).click();
    new Select(driver.findElement(By.id("occupation-name"))).selectByVisibleText("Clergy");
    driver.findElement(By.cssSelector("fieldset.prehide > fieldset > div.section > div.pagenav > button.btn.next")).click();
    
    System.out.println("Additional Driver Details - Part 2");
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("license-state")));
    new Select(driver.findElement(By.id("license-state"))).selectByVisibleText("Pennsylvania");
    new Select(driver.findElement(By.id("vehicle-id"))).selectByVisibleText("2014 FORD F150");
    driver.findElement(By.cssSelector("fieldset.prehide > fieldset > fieldset > fieldset > div.section > div.pagenav > button.btn.next")).click();
    
    System.out.println("How Do We Reach You?");
    driver.findElement(By.cssSelector("input[type=\"tel\"]")).sendKeys("215");
    driver.findElement(By.cssSelector("span.phone1 > input[type=\"tel\"]")).sendKeys("847");
    driver.findElement(By.cssSelector("span.phone2 > input[type=\"tel\"]")).sendKeys("5555");
    driver.findElement(By.id("email")).sendKeys("test@leadnomics.com");
    driver.findElement(By.id("address")).sendKeys("1234 Main St");
    driver.findElement(By.id("residence-status")).click();
    new Select(driver.findElement(By.id("residence-status"))).selectByVisibleText("Rent");
    new Select(driver.findElement(By.id("credit-rating"))).selectByVisibleText("Excellent");
    driver.findElement(By.cssSelector("button.cta")).click();
    
    System.out.println("Offers Page");
    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ckContainer")));
    driver.findElement(By.id("ckContainer"));	       

    System.out.println("Test Complete");
    driver.quit();
  }
}


