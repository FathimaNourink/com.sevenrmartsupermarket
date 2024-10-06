package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.SubCategoryPage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.HomePage;

public class SubCategoryTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    SubCategoryPage subCategoryPage;

    @Test
    public void verifySubCategoryHeader() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        subCategoryPage = new SubCategoryPage(driver);
        loginPage.login("admin", "admin");
        homePage.clickOnSubCategory();

        String actualHeader = subCategoryPage.getSubCategoryPageHeader();
        System.out.println(actualHeader);
        String expectedHeader = "List Sub Categories";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

   

    @Test
    public void verifyNewPageHeader() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        subCategoryPage = new SubCategoryPage(driver);
        loginPage.login("admin", "admin");
        homePage.clickOnSubCategory();
        subCategoryPage.clickOnNewSubCategory();
        String actualHeader = subCategoryPage.getNewPageHeader();
        System.out.println(actualHeader);
        String expectedHeader = "Add Sub Category";
        Assert.assertEquals(actualHeader, expectedHeader);
    }
    
    @Test
    public void verifySearchHeader() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        subCategoryPage = new SubCategoryPage(driver);
        loginPage.login("admin", "admin");
        homePage.clickOnSubCategory();
        subCategoryPage.clickOnSearch(); 
        String actualHeader = subCategoryPage.getSearchHeader(); 
        System.out.println(actualHeader);
        String expectedHeader = "Search List Sub Categories";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

}
