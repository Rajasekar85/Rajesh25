package com.stepdefinition;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.apache.commons.math3.distribution.GeometricDistribution;
import org.apache.poi.util.SystemOutLogger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import com.pages.BookHotelPage;
import com.pages.BookingConfirmationPage;
import com.pages.LoginPage;
import com.pages.SearchHotelPage;
import com.pages.SelectHotelPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepDefinition extends com.baseclass.BaseClass {

//	@Given("User is on the Adactin Hotel Page")
//	public void user_is_on_the_Adactin_Hotel_Page() throws IOException {
//		getAllDriver(getPropertyValue("browser"));
//     enterUrl(getPropertyValue("url"));
//      Maximum();
//	}
//
//	@When("User should perform Login {string} , {string}")
//	public void user_should_perform_Login1(String userName, String password) {
//		LoginPage login = new LoginPage();
//		login.logins(userName, password);
//	}

	@When("User should verify {string}")
	public void user_should_verify(String expvalue) throws InterruptedException {
		Threds(4000);
		SearchHotelPage searchHotel = new SearchHotelPage();
		String actualvalue = getAttribute(searchHotel.getTxtloginmsg(), "value");
		Assert.assertEquals("verify Arunsk007!", expvalue, actualvalue);
	}

	@When("User should Search Hotel")
	public void user_should_Search_Hotel() {
		SelectHotelPage selectHotel = new SelectHotelPage();
		selectHotel.selectHotel();

	}

	@When("User should select a Hotel {string},{string},{string},{string},{string},{string},{string}and{string}")
	public void user_should_select_a_Hotel_and(String location, String Hotels, String roomType, String room_nos,
			String checkInDate, String checkOutDate, String adultRoom, String childRoom) {

		SearchHotelPage searchHotel = new SearchHotelPage();
		searchHotel.Submit(location, Hotels, roomType, room_nos, checkInDate, checkOutDate, adultRoom, childRoom);

	}

	@When("User should Book Hotel {string},{string},{string} and Payment")
	public void user_should_Book_Hotel_and_Payment(String firstName, String LastName, String address,
			io.cucumber.datatable.DataTable dataTable) {
		BookHotelPage bookHotel = new BookHotelPage();

		List<Map<String, String>> asMaps = dataTable.asMaps();
		Map<String, String> map = asMaps.get(1);
		String creditNum = map.get("creditnum");
		String creditType = map.get("credittype");
		String expMonth = map.get("expmonth");
		String expyear = map.get("expyear");
		String ccvNum = map.get("cvv");
		bookHotel.bookHotel(firstName, LastName, address, creditNum, creditType, expMonth, expyear, ccvNum);
	}

	@When("User should verify the page {string}")
	public void user_should_verify_the_page(String expvalue1) {
		SelectHotelPage selectHotel = new SelectHotelPage();
		String actualvalue = gettext(selectHotel.getTxtselecthotel());
		Assert.assertEquals("Verify Select hotel is present", expvalue1, actualvalue);

	}

	@When("User should verify the text {string}")
	public void user_should_verify_the_text(String expvalue1) throws InterruptedException {
		BookHotelPage bookHotel = new BookHotelPage();
		String actualvalue = gettext(bookHotel.getBtnbookahotel());
		Assert.assertEquals("Verify Book A Hotel Present", expvalue1, actualvalue);
	}

	@Then("User should verify error{string} ,{string},{string},{string},{string},{string} and {string}")
	public void user_should_verify_error_and(String expValue, String expValue1, String expValue2, String expValue3,
			String expValue4, String expValue5, String expValue6) {
		BookHotelPage bookHotel = new BookHotelPage();

		String actual1 = gettext(bookHotel.getTxtAssertFirst());
		Assert.assertEquals("Verify Please Enter your First Name Present", expValue, actual1);
		String actual2 = gettext(bookHotel.getTxtAssertLast());
    	Assert.assertEquals("Verify Please Enter you Last Name Present", expValue1, actual2);
		String actual3 = gettext(bookHotel.getTxtAssertAddress());
		Assert.assertEquals("Verify Please Enter your Address Present", expValue2, actual3);
		String actual4 = gettext(bookHotel.getTxtAssertCardnum());
		Assert.assertEquals("Verify Please Enter your 16 Digit Credit Card Number", expValue3, actual4);
		String actual5 = gettext(bookHotel.getTxtAssertCardtype());
		Assert.assertEquals("Verify Please Select your Credit Card Type Present", expValue4, actual5);
		String actual6 = gettext(bookHotel.getTxtAssertExp());
		Assert.assertEquals("Verify Please Select your Credit Card Present", expValue5, actual6);
		String actual7 = gettext(bookHotel.getTxtAssertCvv());
		Assert.assertEquals("Please Enter your Credit Card CVV", expValue6, actual7);

	}

	@Then("User should verify the {string}")
	public void user_should_verify_the(String expValue) throws InterruptedException {
		Thread.sleep(10000);
		BookingConfirmationPage bookingConfirmation=new BookingConfirmationPage();
		String actual1 = gettext(bookingConfirmation.getTxtbookingcnf());
		Assert.assertEquals("Verify Booking Confirm Present", expValue, actual1);
		
		
	}

	@When("User should perform Login {string}, {string}")
	public void user_should_perform_Login(String userName, String password) {
		LoginPage login = new LoginPage();
		login.logins(userName, password);
	}

	@When("User Should Search Hotel")
	public void user_Should_Search_Hotel() throws InterruptedException {

		SelectHotelPage selectHotel = new SelectHotelPage();
		selectHotel.selectHotel();
	}

	@When("User should Click on Book")
	public void user_should_Click_on_Book() {
		BookHotelPage bookHotel = new BookHotelPage();
		bookHotel.getBtnBookNow().click();;
		
	}

}
