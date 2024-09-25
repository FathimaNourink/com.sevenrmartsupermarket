package com.sevenrmartsupermarket.utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.sevenrmartsupermarket.constants.Constants;

public class ScreenShotCapture {
    TakesScreenshot takeScreenshot;

    public void takeScreenShot(WebDriver driver, String imageName) {
        try {
            takeScreenshot = (TakesScreenshot) driver;
            File screenShot = takeScreenshot.getScreenshotAs(OutputType.FILE);
            String timeStamp = GeneralUtility.getTimeStamp();
            String path = Constants.SCREENSHOT_FILE_PATH_STRING + imageName + "_" + timeStamp + ".png";
            File destination = new File(path);
            FileHandler.copy(screenShot, destination);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
