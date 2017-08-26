package com.ecvictor.selenium.junit.page_object_design.modules;

import com.ecvictor.selenium.junit.page_object_design.page_object.homePage.subMenu.GraduatePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by ccao on 2017-08-26.
 */
public class SubMenuActions {
    private int timeout = 5000;
    private int interval = 500;
    public WebDriver driver;

    public SubMenuActions(WebDriver driver) {
        this.driver = driver;
    }

    public void hoverGraduate(Actions actions) {
        WebElement graduate = driver.findElement(By.linkText(GraduatePage.graduate));
        actions.moveToElement(graduate);
        actions.click().build().perform();
    }
}
