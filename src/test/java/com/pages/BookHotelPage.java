package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookHotelPage extends BaseClass {
	public BookHotelPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first_name")
	private WebElement txtFirstName;

	@FindBy(id = "last_name")
	private WebElement txtLastName;

	@FindBy(id = "address")
	private WebElement txtAddress;

	@FindBy(id = "cc_num")
	private WebElement txtCreditNum;

	@FindBy(id = "cc_type")
	private WebElement dDnCreditType;

	@FindBy(id = "cc_exp_month")
	private WebElement dDnExpMon;

	@FindBy(id = "cc_exp_year")
	private WebElement dDnExpyear;
	@FindBy(xpath = "//label[text()='Please Enter your First Name']")
	private WebElement txtassertFirst;
	@FindBy(xpath = "//label[contains(text(),'Please Enter you Last Name')]")
	private WebElement txtassertLast;
	@FindBy(xpath = "//label[contains(text(),'Please Enter your Address')]")
	private WebElement txtassertAddress;
	@FindBy(xpath = "//label[contains(text(),'Please Enter your 16 Digit Credit Card Number')]")
	private WebElement txtassertCardnum;
	@FindBy(xpath = "//label[contains(text(),'Please Select your Credit Card Type')]")
	private WebElement txtassertCardtype;
	@FindBy(xpath= "//label[contains(text(),'Credit Card Expiry')]")
	private WebElement txtassertExp;
	@FindBy(xpath = "//label[contains(text(),'Please Enter your Credit Card CVV Number')]")
	private WebElement txtassertCvv;

	public WebElement getTxtAssertFirst() {
		return txtassertFirst;
	}

	public WebElement getTxtAssertLast() {
		return txtassertLast;
	}

	public WebElement getTxtAssertAddress() {
		return txtassertAddress;
	}

	public WebElement getTxtAssertCardnum() {
		return txtassertCardnum;
	}

	public WebElement getTxtAssertCardtype() {
		return txtassertCardtype;
	}

	public WebElement getTxtAssertExp() {
		return txtassertExp;
	}

	public WebElement getTxtAssertCvv() {
		return txtassertCvv;
	}

	@FindBy(id = "cc_cvv")
	private WebElement txtCcvNum;
	@FindBy(id = "book_now")
	private WebElement btnBookNow;
	@FindBy(xpath = "//td[contains(text(),'Book A Hotel')]")
	private WebElement btnbookahotel;

	public WebElement getBtnbookahotel() {
		return btnbookahotel;
	}

	public WebElement getBtnBookNow() {
		return btnBookNow;
	}

	public WebElement getTxtCreditNum() {
		return txtCreditNum;
	}

	public WebElement getdDnCreditType() {
		return dDnCreditType;
	}

	public WebElement getdDnExpMon() {
		return dDnExpMon;
	}

	public WebElement getdDnExpyear() {
		return dDnExpyear;
	}

	public WebElement getTxtCcvNum() {
		return txtCcvNum;
	}

	public WebElement getTxtFirstName() {
		return txtFirstName;
	}

	public WebElement getTxtLastName() {
		return txtLastName;
	}

	public WebElement getTxtAddress() {
		return txtAddress;
	}

	public void bookHotel(String firstName, String LastName, String address, String creditNum, String creditType,
			String expMonth, String expyear, String ccvNum) {
		Assert.assertTrue("verify url", getCurrentUrl().contains("BookHotel"));
		SendKeys(getTxtFirstName(), firstName);
		SendKeys(getTxtLastName(), LastName);
		SendKeys(getTxtAddress(), address);
		SendKeys(getTxtCreditNum(), creditNum);
		selectOptionsbyVissibleText(getdDnCreditType(), creditType);
		selectOptionsbyVissibleText(getdDnExpMon(), expMonth);
		type(getdDnExpyear(), expyear);
		SendKeys(getTxtCcvNum(), ccvNum);
		click(getBtnBookNow());
	}
}
