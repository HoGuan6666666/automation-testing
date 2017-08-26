package com.ecvictor.selenium.junit.page_object_design.page_object.homePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {

    private int timeout = 5000;
    private int interval = 500;
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void click_about() {
        HomeTopMenu homeTopMenu=new HomeTopMenu(driver);
        driver.findElement(By.xpath(homeTopMenu.about)).click();
        validateNavigation("About", interval);
    }

    public void clickAcademics() {
        HomeTopMenu homeTopMenu=new HomeTopMenu(driver);
        driver.findElement(By.xpath(homeTopMenu.academics)).click();
        validateNavigation("Academics", interval);
    }
    public void clickAdmissions() {
        HomeTopMenu homeTopMenu=new HomeTopMenu(driver);
        driver.findElement(By.xpath(homeTopMenu.admissions)).click();
        validateNavigation("Admissions", interval);
    }


    //help function
    private void validateNavigation(String naveName, int interval) {
        while (timeout > 0) {
            String name = driver.getTitle();
            if (name.equals(naveName)) {
                System.out.println("Found the page: " + timeout);
                break;
            } else {
                System.out.println("Not found the page,wait 500 ms");
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                timeout -= interval;
            }
        }
        if (timeout <= 0)
            Assert.fail("Validation failed");
    }

}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
