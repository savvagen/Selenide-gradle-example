package com.Fabrika;




import com.automation.remarks.testng.TestNgListener;
import com.automation.remarks.testng.VideoListener;
import com.automation.remarks.video.annotations.Video;
import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


import static com.codeborne.selenide.Selenide.*;



@Listeners({VideoListener.class, AllureListener.class})
public class Tests {


    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
        Configuration.browser = "chrome";
        Configuration.browserSize = "1366x768";

        VideoRecorder.conf()
                .withVideoFolder("video")
                .videoEnabled(true)
                .withVideoSaveMode(VideoSaveMode.ALL)
                .withRecordMode(RecordingMode.ANNOTATED)
                .withScreenSize(1366,768);
        /*// Default video folder is ${user.dir}/video. Could be changed by:
        VideoRecorder.conf()
                .withVideoFolder("video")
                // Video could be disabled globally. Set to "true"
                .videoEnabled(true)
                .withRecorderType(RecorderType.FFMPEG)
                // There is two recording modes ANNOTATED AND ALL
                // Annotated is default and works only with methods annotated by @Video
                .withRecordMode(RecordingMode.ANNOTATED)
                .withVideoSaveMode(VideoSaveMode.ALL)
                .withFrameRate(24);*/

    }


    @Test
    @Video(name = "video")
    public void selenideTest(){
        open("https://vlay.pythonanywhere.com/test_1");
        $(By.linkText("Login")).click();
        $("input#auth_user_email").shouldBe(Condition.visible);
    }












}