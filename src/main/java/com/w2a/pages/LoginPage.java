package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class LoginPage extends Page{
	
	
	
	public ZohoAppPage doLogin(String username, String password) {
		
		type("email_CSS",username);
		click("nextBtn_CSS");
		type("password_CSS",password);
		
		click("signBtn_XPATH");
		
		return new ZohoAppPage();
	}
	
	public void gotoSalesAndMarketing() {
		
	}
	
	public void gotoFinance() {
		
	}

}
