package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.constants.DataProviders;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.utilities.ExcelReader;
import com.sevenrmartsupermarket.utilities.GeneralUtility;

public class LoginTest extends Base {

    LoginPage loginPage;
    HomePage homePage;
    ExcelReader excelReader = new ExcelReader();


    @Test
    public void verifyLogin() {
        loginPage = new LoginPage(driver);
        excelReader.setExcelFile("logindata", "Login Credentials");

        String username = excelReader.getCellData(1, 0);  
        String password = excelReader.getCellData(1, 1);  

        System.out.println("Username from Excel: " + username);
        System.out.println("Password from Excel: " + password);
        
        homePage = loginPage.login(username, password);
        
        String name = GeneralUtility.getRandomFirstName();
        System.out.println(name);
 
      
        String actualProfileName = homePage.getProfileName();
        String expectedProfileName = "Admin";
        
        System.out.println("Actual Profile Name: " + actualProfileName);
        
        Assert.assertEquals(actualProfileName, expectedProfileName);
    }
    @Test
    public void verifyRememberMe() {
		loginPage = new LoginPage(driver);
		loginPage.enterUserName("admin");
		loginPage.enterPassword("admin");
		Assert.assertTrue(loginPage.rememberMeBox());
			
	}

    @Test(dataProvider = "loginDetails", dataProviderClass = DataProviders.class)
    public void verifyLoginData(String userName, String password) {
        loginPage = new LoginPage(driver);
        
        System.out.println("Logging in with Username: " + userName);
        System.out.println("Logging in with Password: " + password);

        homePage = loginPage.login(userName, password);
        
        Assert.assertTrue(homePage.isProfilePictureDisplayed());
    }
}
