package com.crio.QKART_TestNG.Test;

import java.net.URL;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.remote.DesiredCapabilities;

public class SingleTonWebDriver {
   private  final static String applicationUrl ="https://crio-qkart-frontend-qa.vercel.app/";
   private static WebDriver driver ;
   

    private SingleTonWebDriver() {

    }

    public static WebDriver getWebDriverInstance(){

        if (driver==null){
            final DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setBrowserName(BrowserType.CHROME);
            try{
            driver = new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);
            System.out.println("Driver Created");
            }catch(Exception e){
                System.out.println("Error Occur"+e.getMessage());
            }
            driver.manage().window().maximize();
            System.out.println("createDriver()");
        }
        return driver;
    }

    public static void navigateTOUrl(){
         driver.manage().window().maximize();
         driver.get(applicationUrl);
         System.out.println("Application Lunch");
    }


    
}
