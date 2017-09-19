package com.ecvictor.selenium.junit.page_object_design.test_case;

import com.ecvictor.selenium.junit.page_object_design.modules.HomePageActions;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.fail;

public class ConcordiaTest extends BaseTest {

    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void testAbout() throws Exception {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.clickAbout();
    }

    @Test
    public void testAcademics() throws Exception {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.clickAcademics();
    }

    @Test
    public void testAdmissions() throws Exception {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.clickAdmissions();
    }

    @Test
    public void testGraduateTest() throws Exception {
        HomePageActions homePageActions = new HomePageActions(driver);
        homePageActions.hoverGraduate();
    }

    @After
    public void tearDown() throws Exception {
        super.tearDown();
    }
}
