package com.sahibindentracker.pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @AndroidFindBy(id = "com.sahibinden:id/browsing_activity_featured_classifieds_text_view_search")
    WebElement searchInputButton;

    By searchInputBy = By.id("com.sahibinden:id/search_src_text");



    public MainPage(AndroidDriver driver, WebDriverWait wait) {
        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );

        this.driver = driver;
        this.wait = wait;
    }



    public void searchAdvert(String advertNo) throws InterruptedException {
        searchInputButton.click();

        Thread.sleep(2*1000);

        WebElement searchInput = wait.until(
                ExpectedConditions.elementToBeClickable(
                        searchInputBy
                )
        );

        searchInput.sendKeys(advertNo);
        Thread.sleep(2*1000);
        //try {
        //searchInput.sendKeys(Keys.ENTER);
        //} catch(Exception ignore) {
        //
        //}
        Thread.sleep(2*1000);
    }

}
