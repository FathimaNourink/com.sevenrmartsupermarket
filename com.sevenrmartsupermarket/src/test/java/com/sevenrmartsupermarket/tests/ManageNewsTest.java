package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.ManageNewsPage;

public class ManageNewsTest extends Base {
    LoginPage loginPage;
    HomePage homePage;
    ManageNewsPage manageNewsPage;

    @Test
    public void verifyCreateNewNews() {
    	loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        manageNewsPage = new ManageNewsPage(driver);
        loginPage.login("admin", "admin");
        homePage.clickOnManageNews();
        
        String newsContent = "This is a new news article.";
        manageNewsPage.clickCreateNewNews();
        manageNewsPage.enterNews(newsContent);
        manageNewsPage.clickSaveButton();

        Assert.assertTrue(manageNewsPage.isSuccessAlertDisplayed());
    }

    
}
