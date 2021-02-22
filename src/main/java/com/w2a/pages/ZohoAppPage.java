package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page{

	

	public CRMHomePage gotoCRM() {
		click("crmlink_XPATH");
		
		return new CRMHomePage();
	}

	public void gotoChat() {
		driver.findElement(By.xpath("//div[contains(text(),'Cliq')]")).click();
	}

	public void gotoSalesIQ() {
		driver.findElement(By.cssSelector("//div[contains(text(),'SalesIQ')]")).click();
	}

}
