package com.sahibindentracker.pages;

import com.sahibindentracker.utils.FileUtil;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;

public class AdvertPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    @AndroidFindBy(id = "com.sahibinden:id/browsing_activity_classified_detail_classified_title_textView")
    WebElement advertName;

    @AndroidFindBy(id = "com.sahibinden:id/storeName")
    WebElement advertGiverName;

    @AndroidFindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/androidx.drawerlayout.widget.DrawerLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.FrameLayout[2]/android.widget.ListView/android.widget.LinearLayout[4]/android.view.ViewGroup/android.widget.TextView[2]")
    WebElement advertPrice;

    public AdvertPage(AndroidDriver driver, WebDriverWait wait) {
        PageFactory.initElements(
                new AppiumFieldDecorator(driver),
                this
        );

        this.driver = driver;
        this.wait = wait;
    }

    public void getAdvert() throws IOException {
        System.out.println(
                advertName.getText() + System.lineSeparator() +
                        advertGiverName.getText() + System.lineSeparator() +
                        advertPrice.getText() + System.lineSeparator()
        );
        FileUtil.writeLine(
                advertName.getText() + System.lineSeparator() +
                        advertGiverName.getText() + System.lineSeparator() +
                        advertPrice.getText() + System.lineSeparator()
        );
    }


}
