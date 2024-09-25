package com.sevenrmartsupermarket.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.sevenrmartsupermarket.base.Base;
import com.sevenrmartsupermarket.listeners.RetryAnalyzer;
import com.sevenrmartsupermarket.pages.HomePage;
import com.sevenrmartsupermarket.pages.LoginPage;
import com.sevenrmartsupermarket.pages.SubCategoryPage;

public class SubCategoryTest extends Base 
{

	LoginPage loginPage;
	HomePage homePage;
	SubCategoryPage subCategoryPage;

	@Test(retryAnalyzer = RetryAnalyzer.class)
	public void verifySubCategoryHeader() {

	loginPage = new LoginPage(driver);
	homePage = new HomePage(driver);
	subCategoryPage = new SubCategoryPage(driver);

	loginPage.login("admin", "admin");
	homePage.clickOnSubCategory();
	String actualHeader=subCategoryPage.subCategoryPageHeader();
	String expectedHeader="List Sub Categories";
	Assert.assertEquals(actualHeader, expectedHeader);
	}

	@Test
	public void verifyAllSubCategorynames() {

	loginPage = new LoginPage(driver);
	homePage = new HomePage(driver);
	subCategoryPage = new SubCategoryPage(driver);
	loginPage.login("admin", "admin");
	homePage.clickOnSubCategory();
	subCategoryPage.getAllSubCategoryName();


	}

	

	@Test
	public void verifyNewSubCategory() {
	    loginPage = new LoginPage(driver);
	    homePage = new HomePage(driver);
		loginPage.login("admin", "admin");
	    subCategoryPage = homePage.clickOnSubCategory();  
	    subCategoryPage.createSubCategory("Appliances", "Microwave Oven");

	}


	}




