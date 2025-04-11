package utils;
import java.lang.reflect.Array;
import java.time.Duration;
import java.util.Arrays;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class TouchActionsApi {
	
        AndroidDriver driver;
	
		public TouchActionsApi(AndroidDriver driver) {
		this.driver = driver;
	}

	//tap on an element
	public void tap(WebElement ele) {
		//W3CApi
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence tap = new Sequence(touch, 0);
		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(ele),0,0));
		
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		
		driver.perform(Arrays.asList(tap));

	}
	
	//tap on element by coordinates - x,y
	public void tap(int x,int y) {
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence tap = new Sequence(touch, 0);
		tap.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), x,y));
		tap.addAction(touch.createPointerDown(0));
		tap.addAction(touch.createPointerUp(0));
		
		driver.perform(Arrays.asList(tap));
	}
	
	
	
	//drag and drop by source and target elements
	public void dragAndDrop(WebElement source, WebElement target) {
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence dragAndDrop = new Sequence(touch, 0);
		
		dragAndDrop.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(source), 0,0));
		dragAndDrop.addAction(touch.createPointerDown(0));
		dragAndDrop.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.fromElement(target), 0,0));
		dragAndDrop.addAction(touch.createPointerUp(0));
		
		driver.perform(Arrays.asList(dragAndDrop));
		
	}
	
	//Drag and drop by coordinates
	public void dragAndDrop(int srcX, int srcY , int trgX , int trgY) {
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence dragAndDrop = new Sequence(touch, 0);
		dragAndDrop.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), srcX,srcY));
		dragAndDrop.addAction(touch.createPointerDown(0));
		dragAndDrop.addAction(touch.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), trgX, trgY));
		dragAndDrop.addAction(touch.createPointerUp(0));
		
		driver.perform(Arrays.asList(dragAndDrop));
	
	}
	
	//Long press on element
	
	public void longPress(WebElement ele, int durationInSeconds) {
		PointerInput touch = new PointerInput(PointerInput.Kind.TOUCH,"finger");
		Sequence longPress = new Sequence(touch, 0);
		
		longPress.addAction(touch.createPointerMove(Duration.ZERO, PointerInput.Origin.fromElement(ele), 0,0));
		longPress.addAction(touch.createPointerDown(0));
		longPress.addAction(touch.createPointerMove(Duration.ofSeconds(durationInSeconds),PointerInput.Origin.fromElement(ele),0,0));
		longPress.addAction(touch.createPointerUp(0));
		
		
		driver.perform(Arrays.asList(longPress));

	}


}