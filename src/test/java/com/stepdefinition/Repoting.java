package com.stepdefinition;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class Repoting {
	public static void reporting(String jsonfile) {
		

		
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\Report");
		Configuration configuration=new Configuration(file, "AdactinHotel");
		configuration.addClassifications("OS", "Windows");
		configuration.addClassifications("browser", "chrome");
		configuration.addClassifications("browser version", "5.7");
		List <String>jsonFiles= new ArrayList<String>();
		jsonFiles.add(jsonfile);
		
		ReportBuilder reportBuilder= new ReportBuilder(jsonFiles, configuration);
		reportBuilder.generateReports();
}
}
