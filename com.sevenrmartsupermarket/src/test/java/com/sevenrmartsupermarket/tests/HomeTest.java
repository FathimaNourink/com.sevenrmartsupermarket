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
        subCategoryPage=homePage.clickOnSubCategory();   

        String actualHeader = subCategoryPage.getSubCategoryPageHeader();
        String expectedHeader = "List Sub Categories";
        Assert.assertEquals(actualHeader, expectedHeader);
    }

    @Test
public void verifyProfilePicture() {
		
		loginPage=new LoginPage(driver);
		homePage=new HomePage(driver);
		loginPage.login("admin", "admin");
		String actualOutput= homePage.getImageAdmin();
		String expectedOutput="https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/user2-160x160.jpg";
		
		System.out.println("Actual Image URL: " + actualOutput);
	    System.out.println("Expected Image URL: " + expectedOutput);
		Assert.assertEquals(actualOutput, expectedOutput);
}
}