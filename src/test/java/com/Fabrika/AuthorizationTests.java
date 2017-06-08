package com.Fabrika;

import com.Fabrika.listeners.TestListener;
import com.Fabrika.utilites.TestBase;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Listeners({VideoListener.class, AllureListener.class, ReportPortalTestNGListener.class, TestListener.class})
public class AuthorizationTests extends TestBase {


    @AfterMethod(alwaysRun = true)
    public void stopTest(){
        if (header.logoutButton.is(visible)){
            header.logOut();
            homePage.flash.shouldBe(visible);
            homePage.flash.shouldHave(text(homePage.not_logged_in_flash_message));
            assertEquals(homePage.page_url, getWebDriver().getCurrentUrl());
        }
    }



    @Test
    @Video(name = "video")
    public void loginTest(){
        loginPage.openPage().login();
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.logged_in_flash_message));
        homePage.profileButton.shouldBe(visible);
    }


    @Test
    @Video(name = "video")
    public void loginTest2(){
        loginPage.openPage().login();
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.logged_in_flash_message));
        homePage.profileButton.shouldBe(visible);
    }

    @Test
    @Video(name = "video")
    public void loginTest3(){
        loginPage.openPage().login();
        homePage.flash.shouldBe(visible).shouldHave(text(homePage.logged_in_flash_message));
        homePage.profileButton.shouldBe(visible);
    }






}
