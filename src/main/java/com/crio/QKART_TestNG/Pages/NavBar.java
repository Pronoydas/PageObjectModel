package com.crio.QKART_TestNG.Pages;

import java.sql.Timestamp;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.*;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavBar {
    public static final String url ="https://crio-qkart-frontend-qa.vercel.app/register";


    public static void waitForElement (WebDriver driver ,ExpectedCondition<java.lang.Boolean> isTrue, int time){
        WebDriverWait wdw = new WebDriverWait(driver,time);
        try{
         wdw.until(isTrue);
        }catch(Exception e){
         System.out.println("Error Occur At the time of Wait "+e.getMessage());
        }
    }
    public static String getDynamicString(boolean isTrue){
        String str=null;
        if(isTrue){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        str=String.valueOf(timestamp);
         return str;
        }
        return "";
    }
    
    
}
