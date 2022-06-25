package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SelectHotelPage extends BaseClass {
	public SelectHotelPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//td[text()='Select Hotel ']")
	private WebElement txtselecthotel;

	public WebElement getTxtselecthotel() {
		return txtselecthotel;
	}

	@FindBy(id = "radiobutton_0")
	private WebElement btnRadio;

	@FindBy(id = "continue")
	private WebElement btnContinue;

	public WebElement getBtnRadio() {
		return btnRadio;
	}

	public WebElement getBtnContinue() {
		return btnContinue;
	}

	public void selectHotel() {

		click(getBtnRadio());
		click(getBtnContinue());
	}
}
