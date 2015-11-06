package ExitOffers.MavenAutomation;


import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
//import javax.mail.*;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

//import java.util.Properties;

public class Autify {

	private WebDriver driver;

	
	private final int interFormDelay = 0;
	

	@Test
	public void testAutifyGoGMI() throws Exception {

		/*
		Properties props = new Properties();
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class",
				"javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");
		props.put("mail.debug", "true");
		
		Session session = Session.getDefaultInstance(props,
				new javax.mail.Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				String email = "sstroman@leadnomics.com";
				String code = "byzzwgdmdttzvmza";
				return new PasswordAuthentication(email,code);
			}

		});

		try {
*/

			System.out.println("Start Website");	 
			DesiredCapabilities dCaps = new DesiredCapabilities();
			dCaps.setJavascriptEnabled(true);
			dCaps.setCapability("takesScreenshot", false);
			dCaps.setCapability(
					PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
					"target/phantomjs-maven-plugin/phantomjs-1.9.7-macosx/bin/phantomjs"
					);


			driver = new PhantomJSDriver(dCaps);
			Dimension d = new Dimension(1420,1600);
			driver.manage().window().setSize(d);

			WebDriverWait wait = new WebDriverWait(driver, 30);
			
			driver.get("http://go.getmyinsurance.com/?_s=QAautoKPXAsrcCakeCheapIns");

			System.out.println("loading lander");
			Thread.sleep(5000);
			System.out.println("lander loaded");

			System.out.println("Title of page:"+driver.getTitle());

			driver.findElement(By.cssSelector("input[type=\"tel\"]")).sendKeys("19114");
			System.out.println("Zip Entered");
			driver.findElement(By.cssSelector("button.submit.callToAction")).click();
			System.out.println("Submit Button Clicked");

			String windowToSwitchTo = (String)driver.getWindowHandles().toArray()[driver.getWindowHandles().size()-1];

			driver.switchTo().window(windowToSwitchTo);
			String url = driver.getCurrentUrl();   
			System.out.println(url);

			System.out.println("Lander Submitted Successfully");
			driver.quit();

			System.out.println("closing lander");
			Thread.sleep(1000);
			System.out.println("lander closed");

			driver = new PhantomJSDriver(dCaps);
			driver.manage().window().setSize(d);
			wait = new WebDriverWait(driver, 100);
			driver.get("http://go.getmyinsurance.com/f/mf/?_s=QAautoKPXAsrcCakeCheapIns");

			System.out.println("loading form");
			Thread.sleep(5000);
			System.out.println("form loaded");

			System.out.println("Are you currently insured?");	
			Thread.sleep(interFormDelay);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ciYes"))).click();
			System.out.println("Currently Insured = Yes");

			System.out.println("Are you a homeowner?");
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[id=\"rsYes\"]"))).click();
			System.out.println("Home Owner = Yes");

			System.out.println("Starting to fill out vehicle information");	  		        		
			driver.findElement(By.cssSelector("option[value=\"2013\"]")).click();
			new Select(driver.findElement(By.xpath("//form[@id='the-form']/div[3]/fieldset/fieldset/fieldset/div/div[2]/div/select"))).selectByVisibleText("HONDA");
			new Select(driver.findElement(By.xpath("//form[@id='the-form']/div[3]/fieldset/fieldset/fieldset/div[2]/div/div/select"))).selectByVisibleText("CIVIC SI");
			new Select(driver.findElement(By.xpath("//form[@id='the-form']/div[3]/fieldset/fieldset/fieldset/div[2]/div[2]/div/select"))).selectByVisibleText("Coupe");
			System.out.println("Finished filling out vehicle information");		        		   

			System.out.println("Starting to fill out current auto coverage");	
			Thread.sleep(interFormDelay);
			new Select(driver.findElement(By.xpath("//form[@id='the-form']/div[3]/fieldset[2]/fieldset/fieldset/fieldset/div/div/div/select"))).selectByVisibleText("Esurance");
			new Select(driver.findElement(By.xpath("//form[@id='the-form']/div[3]/fieldset[2]/fieldset/fieldset/fieldset/div/div[2]/div/select"))).selectByVisibleText("2 years");
			System.out.println("Finished filling out current auto coverage");

			System.out.println("Starting to fill out Personal Inforamtion");
			Thread.sleep(interFormDelay);
			driver.findElement(By.id("first-name")).sendKeys("Maggie");
			driver.findElement(By.id("last-name")).sendKeys("McGee");		 
			driver.findElement(By.className("datepicker")).sendKeys("11/25/1954");	
			driver.findElement(By.cssSelector("input[value=\"Married\"]")).click();
			new Select(driver.findElement(By.id("occupation-name"))).selectByVisibleText("Dentist");
			driver.findElement(By.cssSelector("input[id=\"genderFemale\"]")).click();
			driver.findElement(By.cssSelector("input[value=\"Excellent\"]")).click();
			driver.findElement(By.cssSelector("input[id=\"gdYes\"]")).click();
			driver.findElement(By.id("email")).sendKeys("test@leadnomics.com");
			driver.findElement(By.id("address")).sendKeys("123 ABC Street");
			System.out.println("Finished Filling out Personal Information");

			System.out.println("Starting to fill out Phone Number");
			Thread.sleep(interFormDelay);
			driver.findElement(By.cssSelector("span.phone0 input")).sendKeys("215");
			driver.findElement(By.cssSelector("span.phone1 input")).sendKeys("555");
			driver.findElement(By.cssSelector("span.phone2 input")).sendKeys("2151");
			System.out.println("Finished filling out Phone Number");

			System.out.println("Starting to fill out Zip City and State");
			driver.findElement(By.id("zipcode")).sendKeys("19114");
			driver.findElement(By.id("city")).sendKeys("Philadelphia");
			new Select(driver.findElement(By.id("state"))).selectByVisibleText("Pennsylvania");
			System.out.println("Finished filling out Zip City and State");

			Thread.sleep(interFormDelay);

			driver.findElement(By.cssSelector("button.cta")).click();					
			System.out.println("Submited offers page");	
			
			System.out.println("Verify banner on offers page");			        		    
			url = driver.getCurrentUrl();
			System.out.println(url);

			Thread.sleep(15000);

			url = driver.getCurrentUrl();
			System.out.println(url);		        		    

			driver.findElement(By.id("ckContainer"));	        		    
			System.out.println("Test Passed");	
			
			/*

		} catch (Exception e) {


			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("sstroman@leadnomics.com"));
			message.setRecipients(Message.RecipientType.TO,
					InternetAddress.parse("devleads@leadnomics.com"));
			message.addRecipient(javax.mail.Message.RecipientType.CC, new InternetAddress(
					"sstroman@leadnomics.com"));
			message.setSubject("Autify ALERT! An exception has been thrown");
			message.setText("This is an automated message to bring to your attention an error was thrown for http://go.getmyinsurance.com/?_s=QAautoKPXAsrcCakeCheapIns.");


			Transport.send(message);
			System.out.println(e.getMessage());
			System.out.println("Bad things happened - E-Mail sent successfully!");
			throw new RuntimeException(e);
			

		} finally {
			if (driver != null) {
				driver.quit(); 
			}
		}
		
		*/
	}
}


