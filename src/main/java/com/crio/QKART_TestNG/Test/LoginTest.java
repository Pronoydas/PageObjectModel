package com.crio.QKART_TestNG.Test;

import com.crio.QKART_TestNG.Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver =null;
    private final String url="https://crio-qkart-frontend-qa.vercel.app/login";
    
    @BeforeMethod(alwaysRun = true)
    private void setUp(){
        System.out.println("Inside Before Method");
        driver=SingleTonWebDriver.getWebDriverInstance();
        SingleTonWebDriver.navigateTOUrl();
    }
    @Test
    public void TestCase01(){
        Registration reg = new Registration(driver);
        reg.clickOnRegisterBtn();
        NavBar.waitForElement(driver, ExpectedConditions.urlToBe(NavBar.url), 15);
        reg.registerUser(String.format("Test_%s", NavBar.getDynamicString(true)), "Test#0099", "Test#0099");
        // String lastRegisterUser = reg.getLastRegesterUser();
        Login login = new Login(driver);
        // login.clickOnLoginButton();
        NavBar.waitForElement(driver, ExpectedConditions.urlToBe(url), 15);
        login.perfromLogin(reg, "Test#0099");
        login.assertLoginDetails(reg);


    }



    
}
