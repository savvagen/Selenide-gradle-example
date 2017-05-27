package com.Fabrika;


import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Listeners({VideoListener.class, AllureListener.class})
public class HomePageTests extends TestBase {


    @BeforeMethod(alwaysRun = true)
    public void startTest(){
        loginPage.openPage().login();
    }

    @AfterMethod(alwaysRun = true)
    public void stopTest(){
        if (header.logoutButton.is(Condition.visible)){
            header.logOut();
            homePage.flash.shouldBe(visible);
            homePage.flash.shouldHave(text(homePage.not_logged_in_flash_message));
            assertEquals(homePage.page_url, getWebDriver().getCurrentUrl());
        }
    }






    @Test
    @Video
    public void postCreation(){
        postPage.openPage().createPost("Hello Savva");
        homePage.postTable.shouldBe(visible);
        postTable.lastShouldHaveMessage("Hello Savva").lastShouldHaveUserId("Savva Genchevskiy (101)");
    }

    /*@Test
    @Video
    public void viewPost(){
        homePage.postTable.shouldBe(visible);
        homePage.viewMessage("237");
    }*/

    @Test
    @Video
    public void viewPost2(){
        homePage.postTable.shouldBe(visible);
        homePage.viewMessageWithNumber(2);
    }


    @Test
    public void deletePost(){
        loginPage.openPage().login();
        homePage.postTable.shouldBe(visible);
        homePage.deleteLastPost();
        homePage.posts.shouldHaveSize(1);
    }






}