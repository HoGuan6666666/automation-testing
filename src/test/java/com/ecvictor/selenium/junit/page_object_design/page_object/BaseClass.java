package com.ecvictor.selenium.junit.page_object_design.page_object;

import org.openqa.selenium.WebDriver;

public abstract class BaseClass {
	public static WebDriver driver;
	public static boolean bResult;

	public BaseClass(WebDriver driver){
		BaseClass.driver = driver;
		BaseClass.bResult = true;
	}

}
