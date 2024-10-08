package com.sevenrmartsupermarket.pages;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sevenrmartsupermarket.constants.Constants;
import com.sevenrmartsupermarket.utilities.GeneralUtility;
import com.sevenrmartsupermarket.utilities.PageUtility;

public class LoginPage {

    WebDriver driver;
    Properties properties = new Properties();
    GeneralUtility utility = new GeneralUtility();
    PageUtility pageUtility;

    @FindBy(xpath = "//input[@type='text']")
    private WebElement userNameField;

    @FindBy(xpath = "//input[@type='password']")
    private WebElement passwordField;

    @FindBy(xpath = "//button[@class='btn btn-dark btn-block']")
    private WebElement signInButton;

    @FindBy(xpath = "//label[contains(text(),'Remember Me')]")
    private WebElement rememberMe;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    private WebElement alert;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        pageUtility=new PageUtility(driver);

        try {
            FileInputStream inputStream = new FileInputStream(Constants.CONFIG_FILE_PATH);
            properties.load(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void enterUserName(String userName) {
        userNameField.sendKeys(userName);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickOnSignInButton() {
        signInButton.click();
    }

    public boolean rememberMeBox() {
		return pageUtility.isClicked(rememberMe);
	}


    public HomePage login(String userName, String password) {
        enterUserName(userName);
        enterPassword(password);
        clickOnSignInButton();
        return new HomePage(driver);
    }

    public HomePage login() {
        String userName = properties.getProperty("userName");
        String password = properties.getProperty("password");
        return login(userName, password); 
    }
}
