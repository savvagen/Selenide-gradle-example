package com.Fabrika.utilites;

import com.epam.reportportal.message.ReportPortalMessage;
import org.apache.logging.log4j.Logger;

import java.io.File;

/**
 * Created by savva on 07/06/17.
 */
public class Helpers {

    public static Logger logger;

    public static String screenshot_file_path = "demoScreenshoot.png";
    public static String rp_message = "test message for Report Portal";

    public static void tackeScreenshot() throws Exception{
        ReportPortalMessage message = new ReportPortalMessage(new File(screenshot_file_path), rp_message);
        logger.info(message);

    }




}
