package com.sahibindentracker;

import com.sahibindentracker.pages.AdvertPage;
import io.appium.java_client.android.AndroidDriver;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import com.sahibindentracker.pages.MainPage;
import com.sahibindentracker.utils.DriverManagement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.net.MalformedURLException;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp() throws IOException, InterruptedException {
        DriverManagement.getInstance().setDriver();
        DriverManagement.getInstance().setDriverWait();

        AndroidDriver driver = DriverManagement.getInstance().getDriver();
        WebDriverWait webDriverWait = DriverManagement.getInstance().getDriverWait();

        MainPage mainPage = new MainPage(driver, webDriverWait);
        mainPage.searchAdvert("1120957169");

        Thread.sleep(3*1000);

        AdvertPage advertPage = new AdvertPage(driver, webDriverWait);
        advertPage.getAdvert();

        Thread.sleep(10*1000);
    }
}
