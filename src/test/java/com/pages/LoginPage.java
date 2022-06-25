package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.baseclass.BaseClass;

public class LoginPage extends BaseClass {
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
        @FindBy(id="username")
        private WebElement txtUserName;
        @FindBy(id="password")
        private WebElement txtPassword;
        @FindBy(id="login")
        private WebElement txtLogin;
		public WebElement getTxtUserName() {
			return txtUserName;
		}
		public WebElement getTxtPassword() {
			return txtPassword;
		}
		public WebElement getTxtLogin() {
			return txtLogin;
		}
        public void logins(String userName, String password) {
        	

          SendKeys(getTxtUserName(), userName);
          SendKeys(getTxtPassword(), password);
          click(getTxtLogin());
		}
}
