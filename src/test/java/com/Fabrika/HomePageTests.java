package com.Fabrika;


import com.Fabrika.listeners.TestListener;
import com.Fabrika.utilites.TestBase;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.codeborne.selenide.Condition;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.*;


import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;

@Listeners({VideoListener.class, AllureListener.class, ReportPortalTestNGListener.class, TestListener.class})
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
        homePage.postTable.shouldBe(visible);
        homePage.deleteLastPost();
        homePage.posts.shouldHaveSize(1);
    }






}
