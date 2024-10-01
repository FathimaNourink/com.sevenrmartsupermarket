package com.sevenrmartsupermarket.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;
import com.sevenrmartsupermarket.utilities.WaitUtility;

public class SubCategoryPage {
    WebDriver driver;
    GeneralUtility utility = new GeneralUtility();
    PageUtility pageUtility;
    WaitUtility waitUtility;

    @FindBy(xpath = "//h1[text()='List Sub Categories']")
    private WebElement subCategoryHeader;
    @FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr//td[1]")
    private List<WebElement> subCategoryNames;
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
    private WebElement newSubCategoryButton;
    @FindBy(xpath = "//a[@class='btn btn-rounded btn-primary' and contains(text(),'Search')]")
    private WebElement searchButton;
    @FindBy(xpath = "//h4[contains(text(),'Search List Sub Categories')]")
    private WebElement searchHeader;
    @FindBy(xpath = "//select[@class='form-control selectpicker']")
    private WebElement selectCategoryElement;
    @FindBy(xpath = "//input[@id='subcategory']")
    private WebElement enterSubCategoryElement;
    @FindBy(xpath = "//input[@id='main_img']")
    private WebElement uploadImage;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    @FindBy(xpath = "//h1[text()='Add Sub Category']")
    private WebElement newPageHeader;

    public SubCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageUtility = new PageUtility(driver);
    }

    public String getSubCategoryPageHeader() {
        return subCategoryHeader.getText();
    }

    public void getAllSubCategoryName() {
		List<String> names = new ArrayList<String>();
		names = utility.get_textofelements(subCategoryNames);
		System.out.println(names);
	}
    public void clickOnNewSubCategory() {
        newSubCategoryButton.click();
    }

    public String getNewPageHeader() {
        return newPageHeader.getText();
    }
 
    public void clickOnSearch() {
        searchButton.click();
    }

    
    public String getSearchHeader() {
        return searchHeader.getText();
    }
    public void enterSubCategoryName(String subcategory) {
        enterSubCategoryElement.sendKeys(subcategory);
    }

    public void uploadSubCategoryImage() {
        pageUtility.imageUpload(uploadImage);
    }

    public void saveSubCategory() {
        waitUtility = new WaitUtility(driver);
        waitUtility.waitforElementtobeClickable(saveButton);
        saveButton.click();
    }

    public void createSubCategory(String category, String subCategory) {
        clickOnNewSubCategory();
        pageUtility.selectByVisibleText(selectCategoryElement, category);
        enterSubCategoryName(subCategory);
        uploadSubCategoryImage();
        saveSubCategory();
    }
}
