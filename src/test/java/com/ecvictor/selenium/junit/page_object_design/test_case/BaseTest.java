package com.ecvictor.selenium.junit.page_object_design.test_case;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

/**
 * Created by ccao on 2017-08-26.
 */
public class BaseTest {
    public WebDriver driver;
    public String baseUrl;

    public final int timeout = 5000;
    public final int interval = 500;

    public BaseTest() {
        //chose driver type
        String os = (System.getProperty("os.name"));

        if (os.equalsIgnoreCase("Mac OS X"))
            System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        else System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--kiosk");
        driver = new ChromeDriver(chromeOptions);
    }

    public void setUp() {
        baseUrl = "https://www.concordia.ca";

        driver.get(baseUrl + "/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }
    public void tearDown() throws Exception {
        driver.quit();
    }

}
