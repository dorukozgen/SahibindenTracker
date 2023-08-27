package com.sahibindentracker.utils;

import dev.failsafe.internal.util.Durations;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public final class DriverManagement {

    public static DriverManagement instance;
    private AndroidDriver driver;
    private WebDriverWait wait;

    private DriverManagement() {
    }

    public static DriverManagement getInstance() {
        if (instance == null) {
            synchronized (DriverManagement.class) {
                instance = new DriverManagement();
            }
        }
        return instance;
    }

    public void setDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(
                MobileCapabilityType.DEVICE_NAME,
                "Pixel 6a API 31"
        );
        capabilities.setCapability(
                MobileCapabilityType.UDID,
                "emulator-5554"
        );
        capabilities.setCapability(
                MobileCapabilityType.PLATFORM_NAME,
                "Android"
        );
        capabilities.setCapability(
                MobileCapabilityType.PLATFORM_VERSION,
                "12.0"
        );
        capabilities.setCapability(
                "appPackage",
                "com.sahibinden"
        );
        capabilities.setCapability(
                "appActivity",
                "com.sahibinden.ui.supplementary.SplashScreenActivity"
        );
        capabilities.setCapability(
                MobileCapabilityType.NO_RESET,
                "true"
        );
        capabilities.setCapability(
                "skipUnlock",
                "true"
        );

        AndroidDriver androidDriver = new AndroidDriver(
                new URL("http://127.0.0.1:4723/wd/hub"),
                capabilities
        );

        androidDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        this.driver = androidDriver;
    }

    public void setDriverWait() {
        this.wait = new WebDriverWait(
                this.driver,
                Duration.ofSeconds(10)
        );
    }

    public AndroidDriver getDriver() {
        return driver;
    }

    public WebDriverWait getDriverWait() {
        return wait;
    }

    public void destroy() {
        if (this.driver != null) {
            this.driver.close();
            this.driver    = null;
        }

        if (this.wait != null) {
            this.wait = null;
        }
    }
}
