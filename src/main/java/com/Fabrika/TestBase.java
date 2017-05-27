package com.Fabrika;


import com.Fabrika.pages.Header;
import com.Fabrika.pages.HomePage.HomePage;
import com.Fabrika.pages.HomePage.PostTable;
import com.Fabrika.pages.LoginPage.LoginPage;
import com.Fabrika.pages.PostMessagePage.PostMessagePage;
import com.Fabrika.utilites.Driver;
import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeClass;

import static com.codeborne.selenide.Configuration.*;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.URL;

public class TestBase {


    public Header header;
    public HomePage homePage;
    public PostTable postTable;
    public LoginPage loginPage;
    public PostMessagePage postPage;



    public DesiredCapabilities dc;

    @Parameters({"browser", "version"})
    @BeforeClass(alwaysRun = true)
    public void startClass(@Optional String browser, @Optional String version) throws Exception{

        /*System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";*/

        Driver.setBrowser("chrome");
        baseUrl = "https://vlay.pythonanywhere.com/test_1";



        /*dc = DesiredCapabilities.firefox();
        dc.setBrowserName(browser);
        //Enabled VNC for version 46.0
        dc.setVersion(version);
        dc.setCapability("enableVNC", true);

        dc.setPlatform(Platform.LINUX.LINUX);
        dc.setCapability(CapabilityType.TAKES_SCREENSHOT, true);
        dc.setJavascriptEnabled(true);
        WebDriverRunner.setWebDriver(new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), dc));*/


        VideoRecorder.conf()
                .withVideoFolder("video")
                .videoEnabled(false)
                .withRecorderType(RecorderType.FFMPEG)
                .withVideoSaveMode(VideoSaveMode.ALL)
                .withRecordMode(RecordingMode.ANNOTATED)
                .withScreenSize(1366,768);
        /*// Default video folder is ${user.dir}/video. Could be changed by:
        VideoRecorder.conf()
                .withVideoFolder("video")
                // Video could be disabled globally. Set to "true"
                .videoEnabled(true)
                .withRecorderType(RecorderType.FFMPEG)
                //There is two recording modes ANNOTATED AND ALL
                // Annotated is default and works only with methods annotated by @Video
                .withRecordMode(RecordingMode.ANNOTATED)
                .withVideoSaveMode(VideoSaveMode.ALL)
                .withFrameRate(24);*/

        header = new Header();
        homePage = new HomePage();
        postTable = new PostTable();
        postPage = new PostMessagePage();
        loginPage = new LoginPage();



    }



}
