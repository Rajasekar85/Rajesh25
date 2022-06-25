package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class Facebooksignup extends BaseClass{

	public Facebooksignup() {
		PageFactory.initElements(driver, this);
		
	}	
	@FindBy(xpath="//input[@id=\"u_0_j_im\"]")
	private WebElement firstname;
	
	@FindBy(xpath = "//input[@id=\"u_0_l_Sb\"]")
	private WebElement surname;
	@FindBy(xpath = "//input[@id=\"u_0_o_rN\"]")
	private WebElement mobilenum;
	@FindBy(xpath = "//input[@id=\"password_step_input\"]")
	private WebElement newpasword;
	@FindBy(xpath = "//select[@id=\"day\"]")
	private WebElement day;
	@FindBy(xpath = "//select[@id=\"month\"]")
	private WebElement month;
	@FindBy(xpath = "//select[@id=\"year\"]")
	private WebElement year;
	@FindBy(xpath = "//input[@id=\"u_0_6_qM\"]")
	private WebElement radiobutn;
	@FindBy(xpath = "@FindBy(xpath = \"//input[@id=\\\"u_0_6_qM\\\"]\")]")
	private WebElement signupbuttn;
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getSurname() {
		return surname;
	}
	public WebElement getMobilenum() {
		return mobilenum;
	}
	public WebElement getDay() {
		return day;
	}
	public WebElement getMonth() {
		return month;
	}
	public WebElement getYear() {
		return year;
	}
	public WebElement getRadiobutn() {
		return radiobutn;
	}
	public WebElement getSignupbuttn() {
		return signupbuttn;
	}
	public WebElement getNewpasword() {
		return newpasword;
	}

	
	public void signup() {

	}
	
	
}
