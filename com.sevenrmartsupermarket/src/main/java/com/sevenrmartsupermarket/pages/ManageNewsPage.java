package com.sevenrmartsupermarket.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
    WebDriver driver;

    @FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
    private WebElement createNewNewsButton;
    @FindBy(xpath = "//textarea[@id='news']")
    private WebElement newsTextArea;
    @FindBy(xpath = "//button[@type='submit']")
    private WebElement saveButton;
    @FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
    private WebElement successAlert;
    @FindBy(xpath = "//a[@onclick='click_button(2)']")
    private WebElement searchLink; 
    @FindBy(xpath = "//input[@name='un']")
    private WebElement searchNewsInput;
    @FindBy(xpath = "//button[@name='Search']")
    private WebElement searchButton; 

    public ManageNewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickCreateNewNews() {
        createNewNewsButton.click();
    }

    public void enterNews(String news) {
        newsTextArea.sendKeys(news);
    }

    public void clickSaveButton() {
        saveButton.click();
    }

    public boolean isSuccessAlertDisplayed() {
        return successAlert.isDisplayed();
    }

   
    public void clickSearchLink() {
        searchLink.click(); 
    }

    public void searchForNews(String news) {
        searchNewsInput.sendKeys(news);
    }

    public void clickSearchButton() {
        searchButton.click();
    }
}
