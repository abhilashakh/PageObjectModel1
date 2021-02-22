package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class HomePage extends Page {
	
	
	public void goToSignUp() {
		driver.findElement(By.cssSelector("//a[contains(text(),'Sign in')]")).click();
	}

	public LoginPage goToLogin() {

		driver.findElement(By.xpath("//a[contains(text(),'Sign in')]")).click();
		return new LoginPage();
	}

	public void goToSupport() {
		driver.findElement(By.cssSelector(".signing>a:nth-child(2)")).click();
	}

	public void goToZohoEdu() {

	}

	public void goToLearnMore() {

	}

	public void goToValidateFooterLinks() {

	}

}
