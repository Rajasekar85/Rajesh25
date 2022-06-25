
package com.runner;


import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.stepdefinition.Repoting;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;





	@RunWith(Cucumber.class)
	@CucumberOptions(features="C:\\Users\\91739\\eclipse-workspace\\AdactinHotelAutomation1\\src\\test\\resources\\BookingHotel.feature",glue= {"com.stepdefinition"},dryRun=false,monochrome=true,plugin= {"pretty","json:src\\test\\resources\\Report\\hello.json"})
	public  class TestRunner {
		@AfterClass
		public static void afterclas() {
		Repoting.reporting(System.getProperty("user.dir")+"\\src\\test\\resources\\Report\\hello.json");
		}

}