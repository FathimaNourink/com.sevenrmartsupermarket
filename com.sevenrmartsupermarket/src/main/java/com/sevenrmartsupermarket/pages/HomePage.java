package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.utilities.GeneralUtility;


public class HomePage 
{
	WebDriver driver;	
 
    @FindBy(xpath = "//a[@class='d-block']")
    private WebElement profileName;
    @FindBy(xpath = "//a[contains(@class, 'nav-link') and p[text()='Sub Category']]")
    private WebElement subCategory;
    @FindBy(xpath ="//a[contains(@class, 'nav-link') and p[text()='Manage News']]")
    private WebElement manageNews;
    @FindBy(xpath = "//img[@src='https://groceryapp.uniqassosiates.com/public/assets/admin/dist/img/user2-160x160.jpg']")
    private WebElement profilePicture;
    
    GeneralUtility utility=new GeneralUtility();

    public HomePage(WebDriver driver) 
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProfileName() 
    {
        return profileName.getText();
    }

    public SubCategoryPage clickOnSubCategory() 
    {
        subCategory.click();
        return new SubCategoryPage(driver);
        
    }
    public ManageNewsPage clickOnManageNews() {
        manageNews.click();
        return new ManageNewsPage(driver); 
    }


    public boolean isProfilePictureDisplayed() 
    {
        return profilePicture.isDisplayed();
    }

	public String getImageAdmin() {
		
		return utility.getAttribute(profilePicture, "src");

	}
    
}