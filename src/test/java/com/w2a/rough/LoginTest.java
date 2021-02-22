package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.CRMHomePage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountsPage;

public class LoginTest {

	public static void main(String[] args) {

		HomePage home = new HomePage();
		LoginPage login = home.goToLogin();

		ZohoAppPage zp = login.doLogin("abhilashakh@gmail.com", "Abhi22008");
		zp.gotoCRM();

		

		AccountsPage account = Page.menu.gotoAccounts();
		CreateAccountsPage cap = account.gotoCreateAccounts();
		cap.createAccount("abc");

	}

}
