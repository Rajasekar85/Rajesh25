package com.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\91739\\eclipse-workspace\\AdactinHotelAutomation1\\src\\test\\resources\\features\\new.feature",glue="com.stepdefinition",dryRun = false,monochrome = true)
public class Runnerclassf {

}
