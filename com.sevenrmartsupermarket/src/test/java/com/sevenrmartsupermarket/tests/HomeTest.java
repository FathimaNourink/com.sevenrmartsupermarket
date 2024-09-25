package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;

public class HomeTest extends Base {

    LoginPage loginPage;
    HomePage homePage;

    @Test
    public void verifyProfileName() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        String actualProfileName = homePage.getProfileName();
        String expectedProfileName = "Admin";  
        Assert.assertEquals(actualProfileName, expectedProfileName, "Profile name does not match!");
    }

    @Test
    public void verifyNavigationToSubCategory() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        homePage.clickOnSubCategory();

        
    }

    @Test
    public void verifyProfilePictureIsDisplayed() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        boolean isProfilePictureDisplayed = homePage.isProfilePictureDisplayed();

        Assert.assertTrue(isProfilePictureDisplayed);
    }
}
