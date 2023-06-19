package com.crio.QKART_TestNG.Test;

import com.crio.QKART_TestNG.Pages.NavBar;
import com.crio.QKART_TestNG.Pages.Registration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationTest {
    WebDriver driver =null;
   
    

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
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
        
        
    }

}
