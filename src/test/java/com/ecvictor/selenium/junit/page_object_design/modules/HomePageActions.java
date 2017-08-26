package com.ecvictor.selenium.junit.page_object_design.modules;

import com.ecvictor.selenium.junit.page_object_design.page_object.homePage.TopMenuPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ccao on 2017-08-26.
 */
public class HomePageActions {
    private int timeout = 5000;
    private int interval = 500;
    public WebDriver driver;

    public HomePageActions(WebDriver driver) {
        this.driver = driver;
    }

    public void clickAbout() {
        driver.findElement(By.xpath(TopMenuPage.about)).click();
        validateNavigation("About", interval);
    }

    public void clickAcademics() {
        driver.findElement(By.xpath(TopMenuPage.academics)).click();
        validateNavigation("Academics", interval);
    }

    public void clickAdmissions() {
        driver.findElement(By.xpath(TopMenuPage.admissions)).click();
        validateNavigation("Admissions", interval);
    }

    public void hoverGraduate() {
        int counter = 3;
        Boolean success = false;
        while (counter-- > 0) {
            System.out.println("Test Start: ");
            TopMenuPage topMenu = new TopMenuPage();
            Actions actions = new Actions(driver);
            WebElement menu = driver.findElement(By.xpath(TopMenuPage.admissions));
            actions.moveToElement(menu).perform();

            SubMenuActions subMenuActions = new SubMenuActions(driver);
            subMenuActions.hoverGraduate(actions);
            success = validateNavigation("Graduate", interval);
            if (success) break;
        }

        if (!success)
            Assert.fail("Test failed");


    }


    //help function
    private boolean validateNavigation(String naveName, int interval) {
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
        if (timeout <= 0) {
            Assert.fail("Validation failed");
            return false;
        } else return true;
    }

}
