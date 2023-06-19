package com.crio.QKART_TestNG.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.testng.Assert;

public class Login extends NavBar{
    WebDriver driver ;
    @FindBy(xpath = "//button[text()='Login']")
    WebElement loginbtwn;
    @FindBy(xpath = "//button[text()='Login to QKart']") 
    WebElement loginbtn ;
    @FindBy(xpath = "//div[text()='Logged in successfully' and @id='notistack-snackbar']")
    WebElement loginSuccessfullyAlert;
    @FindBy(xpath = "//div[@class='css-vb6e92']/div/following-sibling::p")
    WebElement userNameTag;
    @CacheLookup
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;
    @CacheLookup
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;


    public Login(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 10), this);

    }
    // public void clickOnLoginButton(){
    //     loginbtwn.click();
    // }
    public void perfromLogin(Registration reg,String pwd){
        String lastRegisterUser =reg.getLastRegesterUser();
        try {
           userNameField.click();
           userNameField.sendKeys(lastRegisterUser);
           passwordField.click();
           passwordField.sendKeys(pwd); 
           loginbtn.click();
        } catch (Exception e) {
            System.out.println("Error at the time of Login "+e.getMessage());
        }
    }
    public void assertLoginDetails(Registration reg){
        Assert.assertTrue(loginSuccessfullyAlert.isDisplayed(), "Login Successfully Alert is not display");
        String userName = userNameTag.getText().trim();
        Assert.assertEquals(userName, reg.getLastRegesterUser());    
    }

     
}