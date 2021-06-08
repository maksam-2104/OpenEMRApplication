package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;
import com.cyient.page.DashboardPage;
import com.cyient.page.LoginPage;
import com.cyient.utility.DataProviderUtils;

public class LoginTest extends WebDriverWrapper {
	@Test(dataProvider="invalidData",dataProviderClass = DataProviderUtils.class)
	public void invalidCredentialTest(String username,String password,String languageText,String expectedValue) {
		
	
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
        login.sendPassword(password);
        login.selectLanguageByText(languageText);
       // Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
        //selectLanguage.selectByVisibleText(languageText);
		login.clickOnLogin();
		  DashboardPage dashboard=new DashboardPage(driver);
	        String actualvalue = dashboard.getDashboardPageTitle();
	        
	        Assert.assertEquals(actualvalue, expectedValue);
	}

	@Test(dataProvider="validData",dataProviderClass = DataProviderUtils.class)
	public void validCredentialTest(String username,String password,String languageText,String expectedValue) {
		
		LoginPage login=new LoginPage(driver);
		login.sendUsername(username);
        login.sendPassword(password);
        login.selectLanguageByText(languageText);
		login.clickOnLogin();
		  DashboardPage dashboard=new DashboardPage(driver);
	        String actualvalue = dashboard.getDashboardPageTitle();
	        
	        Assert.assertEquals(actualvalue, expectedValue);
	}

	@Test(dataProvider = "validData",dataProviderClass = DataProviderUtils.class)
	public void validateUIComponentTest() {

		String actualDescription = driver.findElement(By.xpath("//p[contains(text(),'most')]")).getText();
		Assert.assertEquals(actualDescription,
				"The most popular open-source Electronic Health Record and Medical Practice Management solution.");

		String actualAckText = driver.findElement(By.partialLinkText("Acknowledgments")).getText();
		Assert.assertEquals(actualAckText, "Acknowledgments, Licensing and Certification");

		String actualUsernamePlaceholderValue = driver.findElement(By.id("authUser")).getAttribute("placeholder");
		Assert.assertEquals(actualUsernamePlaceholderValue, "Username:");

		// password placeholder
		String actualPasswordPlaceholderValue = driver.findElement(By.id("clearPass")).getAttribute("placeholder");
		Assert.assertEquals(actualPasswordPlaceholderValue, "Password:");

		// default value should be English (Standard)
}
}
