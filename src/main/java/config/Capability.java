package config;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class Capability {
	private static String  udid;
	private static String deviceName;
	private static String platformVersion;
	private static String appPackage;
	private static String appActivity;
	public static AppiumDriverLocalService appiumService;
	public static Process process;
	
	public static void startEmulator() throws IOException, InterruptedException {
		Runtime.getRuntime().exec(System.getProperty("user.dir")+"\\emulator2.bat");
		
		Thread.sleep(8000);
	}
	
	public static AppiumDriverLocalService startAppium() {
		 appiumService = AppiumDriverLocalService.buildDefaultService();
		
		return appiumService;
	}
	
	public static AndroidDriver capabilities() throws IOException {
		FileReader reader = new FileReader(System.getProperty("user.dir") + "\\src/main\\resources\\global.properties");
		Properties ps = new Properties();
		ps.load(reader);
		udid = ps.getProperty("udid");
		deviceName = ps.getProperty("deviceName");
		platformVersion = ps.getProperty("platformVersion");
		appPackage = ps.getProperty("appPackage");
		appActivity = ps.getProperty("appActivity");
		
		DesiredCapabilities dc = new DesiredCapabilities();
		dc.setCapability("udid",udid);
		dc.setCapability("deviceName",deviceName);
		dc.setCapability("platformName","Android");
		dc.setCapability("platformVersion" ,platformVersion);
		dc.setCapability("automationName","UiAutomator2");
		dc.setCapability("appPackage",appPackage);
		dc.setCapability("appActivity",appActivity);
		dc.setCapability("noReset",true);
		dc.setCapability("autoGrantPermissions",true);
		
		URL url = new URL("http://127.0.0.1:4723");
		AndroidDriver driver = new AndroidDriver(url,dc);
		
		System.out.println("Application stated.....");
		return driver;
		
}
	public static void main(String[] args) throws IOException, InterruptedException {
		
		startEmulator();
		startAppium().start();
		Thread.sleep(8000);
		capabilities();
	}
}