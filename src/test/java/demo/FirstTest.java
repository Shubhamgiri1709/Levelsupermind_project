package demo;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import config.Capability;
import io.appium.java_client.android.AndroidDriver;

public class FirstTest {

	static AndroidDriver driver;
	@BeforeClass
	public void setup() throws IOException, InterruptedException {
		
		Capability cap = new Capability();
		Capability.startEmulator();
		Capability.startAppium().start();
		Thread.sleep(8000);
		driver= Capability.capabilities();
		
	}
	 @Test
	private void test1() {
		System.out.println("Test1");
	}
	
	
}
