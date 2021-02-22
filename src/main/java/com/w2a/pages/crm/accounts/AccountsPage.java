package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;

import com.w2a.base.Page;

public class AccountsPage extends Page {
	
	public CreateAccountsPage gotoCreateAccounts() {
		
		click("createaccountsbtn_XPATH");
		
		return new CreateAccountsPage();
		
	}
	
public void gotoImportAccounts() {
		
	}

}
