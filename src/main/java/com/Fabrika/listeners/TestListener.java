package com.Fabrika.listeners;

import com.Fabrika.utilites.Helpers;

import org.apache.log4j.Logger;
import org.testng.ITestResult;
import org.testng.TestNG;

/**
 * Created by savva on 07/06/17.
 */
public class TestListener extends TestNG.ExitCodeListener{


    public static Logger logger = Logger.getLogger("reportlogger");


    @Override
    public void onTestStart(ITestResult testResult){
        super.onTestStart(testResult);
        logger.info("\"" + testResult.getMethod().getMethodName() + "\"" + " test started________");
    }


    @Override
    public void onTestFailure(ITestResult testResult) {
        super.onTestFailure(testResult);
        //Helpers.tackeScreenshot();
    }

    @Override
    public void onTestSuccess(ITestResult testResult){
        super.onTestSuccess(testResult);
        logger.info("\"" + testResult.getMethod().getMethodName() + "\"" + " test finished with success________");
    }



}
