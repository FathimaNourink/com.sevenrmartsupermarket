package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class HomeTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    SubCategoryPage subCategoryPage;

    @Test
    public void verifyProfileName() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        String actualProfileName = homePage.getProfileName();
        String expectedProfileName = "Admin";  
        Assert.assertEquals(actualProfileName, expectedProfileName);
    }

    @Test
    public void verifySubCategoryNavigation() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        subCategoryPage = homePage.clickOnSubCategory();
        String actualHeader = subCategoryPage.subCategoryPageHeader();
        String expectedHeader = "List Sub Categories";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
    public void verifyProfilePictureIsDisplayed() {
        loginPage = new LoginPage(driver);
        homePage = loginPage.login("admin", "admin");

        boolean isProfilePictureDisplayed = homePage.isProfilePictureDisplayed();
        Assert.assertTrue(isProfilePictureDisplayed);
    }
}
