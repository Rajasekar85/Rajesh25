package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class SearchHotelPage extends BaseClass {
	 public SearchHotelPage() {
		 PageFactory.initElements(driver, this);
 	}
	 @FindBy(id="username_show")
	 private WebElement txtloginmsg;
	public WebElement getTxtloginmsg() {
		return txtloginmsg;
	}
	@FindBy(id="location")
    private WebElement dDnLocation;
     @FindBy(id="hotels")
     private WebElement dDnHotes;
     @FindBy(id="room_type")
     private WebElement dDnRoomType;
     @FindBy(id="room_nos")
     private WebElement dDnRoomNo;
      @FindBy(id="datepick_in")
      private WebElement dDnCheckinDate;
      @FindBy(id="datepick_out")
      private WebElement dDnCheckDateOut;
    
      @FindBy(id="adult_room")
      private WebElement dDnAdultRoom;
      @FindBy(id="child_room")
      private WebElement dDnChildRoom;
      @FindBy(id="Submit")
      private WebElement btnSubmit;
	public WebElement getdDnLocation() {
		return dDnLocation;
	}
	public WebElement getdDnHotes() {
		return dDnHotes;
	}
	public WebElement getdDnRoomType() {
		return dDnRoomType;
	}
	public WebElement getdDnRoomNo() {
		return dDnRoomNo;
	}
	public WebElement getdDnCheckinDate() {
		return dDnCheckinDate;
	}
	public WebElement getdDnCheckDateOut() {
		return dDnCheckDateOut;
	}
	public WebElement getdDnAdultRoom() {
		return dDnAdultRoom;
	}
	public WebElement getdDnChildRoom() {
		return dDnChildRoom;
	}
	public WebElement getBtnSubmit() {
		return btnSubmit;
	}
	public void Submit(String location,String Hotels ,String roomType,String room_nos,String checkInDate,String checkOutDate,String adultRoom,String childRoom) {
		
    selectOptionsbyVissibleText(getdDnLocation(), location);
    selectOptionsbyVissibleText(getdDnHotes(), Hotels);
    selectOptionsbyVissibleText(getdDnRoomType(), roomType);
    selectOptionsbyVissibleText(getdDnRoomNo(), room_nos);
    SendKeys(getdDnCheckinDate(), checkInDate);
    SendKeys(getdDnCheckDateOut(), checkOutDate);
    selectOptionsbyVissibleText(getdDnAdultRoom(), adultRoom);
    selectOptionsbyVissibleText(getdDnChildRoom(), childRoom);
    click(getBtnSubmit());
    
	}
	
}
