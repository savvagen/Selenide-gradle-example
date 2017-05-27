package com.Fabrika.utilites;


import com.automation.remarks.video.enums.RecorderType;
import com.automation.remarks.video.enums.RecordingMode;
import com.automation.remarks.video.enums.VideoSaveMode;
import com.automation.remarks.video.recorder.VideoRecorder;
import com.codeborne.selenide.Configuration;

public class Driver {


    public static void setBrowser(String browser){

        switch (browser){
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
                Configuration.browser = "chrome";
            default:
                System.setProperty("webdriver.chrome.driver", "/drivers/chromedriver");
                Configuration.browser = "chrome";

        }

        Configuration.browserSize = "1366x768";



    }







}
