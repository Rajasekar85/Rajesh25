package com.pages;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class BookingConfirmationPage extends BaseClass{
	public BookingConfirmationPage() {
		 PageFactory.initElements(driver, this);
	}
	   public WebElement getTxtbookingcnf() {
		return txtbookingcnf;
	}
	@FindBy(xpath="//td[text()='Booking Confirmation ']")
	   private WebElement txtbookingcnf;
       @FindBy(id="order_no")
       private WebElement orderNum;
       
      public WebElement getOrderNum() {
			return orderNum;
		}
       public void bookingconfirm() throws IOException {
       	Assert.assertTrue("verify url", getCurrentUrl().contains("BookingConfirm"));
       String attribute = getAttribute(getOrderNum());	
       
       writeData("Sheet1",1, 19, attribute); 
       System.out.println(attribute);
         
        
       
		}
}
