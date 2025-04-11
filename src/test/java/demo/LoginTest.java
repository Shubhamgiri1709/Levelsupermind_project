package demo;

import java.io.IOException;

import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Capability;
import io.appium.java_client.android.AndroidDriver;

import utils.TouchActionsApi;

public class LoginTest {
	AndroidDriver driver;
	TouchActionsApi action;

	// LoginPage login;
	@BeforeMethod
	public void setUp() throws IOException, InterruptedException {
		Capability.startEmulator();
		Capability.startAppium().start();
		Thread.sleep(2000);
		driver = Capability.capabilities();
		action = new TouchActionsApi(driver);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	@Test(priority = 1)
	public void allowPermission() throws InterruptedException {

		// click on Sign Button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sign in']")).click();
		Thread.sleep(8000);
		// click on Allow button
		WebElement popup = driver.findElement(By.xpath(
				"//android.widget.Button[@resource-id=\'com.android.permissioncontroller:id/permission_allow_button\']"));

		if (popup.isDisplayed()) {
			action.tap(popup);
		}
	}

	@Test(priority = 2)
	public void loginwithvalidCredentials() throws InterruptedException {
		// use touch Action
		// sign in with Email
		WebElement Email = driver.findElement(By.xpath("//android.widget.TextView[@text='Email']"));
		Thread.sleep(2000);
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence tap = new Sequence(touch, 0);

		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(Email), 0, 0));
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		driver.perform(Arrays.asList(tap));

		// Enter Email in box
		driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your email']"))
				.sendKeys("shubhamgiri1709@gmail.com");
		// click on Arrow
		driver.findElement(By.xpath("(//android.view.View[@content-desc='Arrow Right'])[1]")).click();
		Thread.sleep(2000);
		// Enter the code
		driver.findElement(By.xpath("//android.widget.TextView[@text='Enter the code']")).sendKeys("173592");

		// Enter customer name
		driver.findElement(By.xpath("//android.widget.TextView[@text='Your Name']")).sendKeys("Shubham Giri");

		// Enter Mobile number
		driver.findElement(By.xpath("//android.widget.TextView[@text='Your Phone Number']")).sendKeys("7972571443");

		// select male
		driver.findElement(By.xpath("//android.widget.TextView[@text='Male']")).click();

		// click on Arrow Right
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on type of meditations are you looking for
		driver.findElement(By.xpath("//android.widget.TextView[@text='Stress and anxiety']")).click();

		// click on Arrow Button
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on what are you looking for
		driver.findElement(By.xpath("//android.widget.TextView[@text='Stress Relief']")).click();

		// click on Arrow button
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on Remind me later
		driver.findElement(By.xpath("//android.widget.TextView[@text='Remind me later']")).click();
		Thread.sleep(2000);
		// click on profile
		driver.findElement(By.xpath("//android.widget.ImageView[@content-desc='profile']")).click();

		// click on Logout button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Logout']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='Log Out']")).click();
	}
	@Test(priority = 3)
	public void loginWithinvalidCredentials() throws InterruptedException {
		// use touch Action
		// sign in with Email
		WebElement Email = driver.findElement(By.xpath("//android.widget.TextView[@text='Email']"));

		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence tap = new Sequence(touch, 0);

		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(Email), 0, 0));
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		driver.perform(Arrays.asList(tap));

		// Enter Email in box
		driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your email']"))
				.sendKeys("shubhamgiri9@gmail.com");
		// click on Arrow
		driver.findElement(By.xpath("(//android.view.View[@content-desc='Arrow Right'])[1]")).click();
		Thread.sleep(2000);
		// you enter invalid email then you not get code so invalid email not possible
		// process of login
	}
	@Test(priority = 4)
	public void loginWithMobileNumber() throws InterruptedException {
		// use touch Action
		// sign in with Email
		WebElement Email = driver.findElement(By.xpath("//android.widget.TextView[@text='Phone']"));

		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence tap = new Sequence(touch, 0);

		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(Email), 0, 0));
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		Thread.sleep(2000);
		// Enter Email in box
		driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your phone number']"))
				.sendKeys("7972571443");
		// click on Arrow
		driver.findElement(By.xpath("(//android.view.View[@content-desc='Arrow Right'])[1]")).click();
		Thread.sleep(2000);
		// Enter the Allow
		driver.findElement(By.xpath("//android.widget.Button[@resource-id='com.google.android.gms:id/positive_button']")).click();

		// Enter customer name
		driver.findElement(By.xpath("//android.widget.TextView[@text='Your Name']")).sendKeys("Shubham Giri");

		// Enter Mobile number
		driver.findElement(By.xpath("//android.widget.TextView[@text='Your Phone Number']")).sendKeys("7972571443");

		// select male
		driver.findElement(By.xpath("//android.widget.TextView[@text='Male']")).click();

		// click on Arrow Right
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on type of meditations are you looking for
		driver.findElement(By.xpath("//android.widget.TextView[@text='Stress and anxiety']")).click();

		// click on Arrow Button
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on what are you looking for
		driver.findElement(By.xpath("//android.widget.TextView[@text='Stress Relief']")).click();

		// click on Arrow button
		driver.findElement(By.xpath("//android.view.View[@content-desc='Arrow Right']")).click();
		Thread.sleep(2000);
		// click on Remind me later
		driver.findElement(By.xpath("//android.widget.TextView[@text='Remind me later']")).click();

	}
	@Test(priority = 5)
	public void loginWithInvalidMobileNumber() throws InterruptedException {
		// use touch Action
		// sign in with Email
		WebElement Email = driver.findElement(By.xpath("//android.widget.TextView[@text='Phone']"));

		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH, "finger");

		Sequence tap = new Sequence(touch, 0);

		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(Email), 0, 0));
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		driver.perform(Arrays.asList(tap));
		Thread.sleep(2000);
		// Enter Email in box
		// i have check boundary level analysis and enter no above and below 10 number .
		// this limit is 1 to 10 so then after that Arrow button not visible
		driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your phone number']"))
				.sendKeys("79725714436777");// above 10
		// driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your
		// phone number']")).sendKeys("7972571"); //below 10

		// driver.findElement(By.xpath("//android.widget.TextView[@text='Enter your
		// phone number']")).sendKeys("7972571777");//Enter invalid number
		//  Arrow button not visible
		//driver.findElement(By.xpath("(//android.view.View[@content-desc='Arrow Right'])[1]")).click();

	}
	@Test(priority = 6)
	public void homePage() throws InterruptedException {
		// check all button working or not
		// click on Today Button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Today']")).click();

		// click on meditation Button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Meditation']")).click();

		// click on Sleep button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sleep']")).click();

		// click on Body button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Body']")).click();

		// click on insights button
		driver.findElement(By.xpath("//android.widget.TextView[@text='Insights']")).click();

		// click on My Activity button
		driver.findElement(By.xpath(
				"//androidx.compose.ui.platform.ComposeView/android.view.View/android.view.View/android.view.View/android.view.View[1]/android.view.View/android.view.View[1]/android.view.View[1]/android.view.View[2]/android.view.View"))
				.click();
		Thread.sleep(2000);
		// scroll to the bottom of the screen
		WebElement ele2 = driver.findElement(By.xpath("//android.widget.TextView[@text='Set reminders']"));
		String text = ele2.getText();
//		System.out.println(text);
//		System.out.println("successfully viewed the text message as 'Help' at the bottom of screen");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView(true)", text);

	}
	@AfterMethod
	public void ternDownMethod() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}
}
