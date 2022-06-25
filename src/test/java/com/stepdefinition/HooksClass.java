package com.stepdefinition;

import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import com.baseclass.BaseClass;
import com.pages.LoginPage;

public class HooksClass extends BaseClass{
	    @Before
        public void beforeScenario() throws IOException {
         getAllDriver(getPropertyValue("browser"));
         enterUrl(getPropertyValue("url"));
         Maximum();
         LoginPage loginPage = new LoginPage();
         loginPage.logins(getPropertyValue("username"), getPropertyValue("password"));
         
		}
	  
	    @After
        public void afterScenario(Scenario scenario) {
         TakesScreenshot screenshot= (TakesScreenshot)driver;
         byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);
         scenario.attach(bs, "png", "Every Scenario");
		} 
	    
	    
	    
}
