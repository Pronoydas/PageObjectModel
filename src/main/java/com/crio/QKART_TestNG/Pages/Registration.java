package com.crio.QKART_TestNG.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Registration extends NavBar{
    WebDriver driver = null;
    private String lastRegesterUser = null;
    @FindBy(className="css-177pwqq")
    WebElement registerBtn;
    @FindBy(xpath = "//input[@id='username']")
    WebElement userNameField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;
    @FindBy(xpath = "//input[@id='confirmPassword']")
    WebElement confoimPassword;
    @FindBy(xpath = "//button[text()='Register Now']")
    WebElement regiserNowBtn;
    @FindBy(xpath = "div[@id='notistack-snackbar' and text()='Registered Successfully']")
    WebElement registerSuccessfullyAlert;

    

    

    public Registration(WebDriver driver) {
       this.driver=driver;
       PageFactory.initElements(new AjaxElementLocatorFactory(driver,10), this);

    }

    public boolean clickOnRegisterBtn(){
        boolean isTrue = false;
        try{
            // WebDriverWait wait = new WebDriverWait(driver, 10);
            //  wait.until(ExpectedConditions.elementToBeClickable(registerBtn)).click();

             registerBtn.click();
            isTrue=true;
            System.out.println("Click On Register");
        }catch(Exception e){
            System.out.println("Error at time of Clicking on Register Button "+e.getMessage());
            return isTrue;
        }
        return isTrue;
    }

    public boolean registerUser(String un, String pwd,String cnpwd){
        boolean isTrue = false;
        try{
           userNameField.clear();
           userNameField.sendKeys(un);
           passwordField.click();
           passwordField.sendKeys(pwd);
           confoimPassword.click();
           confoimPassword.sendKeys(cnpwd);
           regiserNowBtn.click();
           setLastRegesterUser(un);
           isTrue=true;
        }catch(Exception e){
            System.out.println("Error at time of Register a Patient "+e.getMessage());
            return isTrue;
        }
        return isTrue;


    }

    public void AssertLoginSuccessfully(WebDriver driver){
        Assert.assertTrue(registerSuccessfullyAlert.isDisplayed());
        String url ="https://crio-qkart-frontend-qa.vercel.app/login";
        String actualUrl =driver.getCurrentUrl();
        Assert.assertTrue(url.equals(actualUrl));
        System.out.println("User Registration Validation Successfully !!");

        
    }

    public  String getLastRegesterUser() {
        return lastRegesterUser;
    }

    public void setLastRegesterUser(String lastRegesterUser) {
        this.lastRegesterUser = lastRegesterUser;
    }

    
}
