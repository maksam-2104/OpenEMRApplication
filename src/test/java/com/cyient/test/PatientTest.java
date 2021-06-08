package com.cyient.test;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cyient.base.WebDriverWrapper;

public class PatientTest extends WebDriverWrapper{	

	@Test
	public void addPatientTest() {
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		Select selectLanguage = new Select(driver.findElement(By.name("languageChoice")));
		selectLanguage.selectByVisibleText("English (Indian)");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[text()='Patient/Client']"))).perform();

		driver.findElement(By.xpath("//div[text()='Patients']")).click();

		driver.switchTo().frame("fin");
		driver.findElement(By.id("create_patient_btn1")).click();
		driver.switchTo().defaultContent();

		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
		driver.findElement(By.id("form_fname")).sendKeys("John");
		driver.findElement(By.id("form_lname")).sendKeys("miller");
		driver.findElement(By.id("form_DOB")).sendKeys("2000-10-11");
		Select selectGender = new Select(driver.findElement(By.id("form_sex")));
		selectGender.selectByVisibleText("Male");
		driver.findElement(By.id("create")).click();
		driver.switchTo().defaultContent();
//Thread.sleep(3000);
		driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@id='modalframe']")));
		driver.findElement(By.xpath("//input[@value='Confirm Create New Patient']")).click();
		driver.switchTo().defaultContent();
		//Thread.sleep(3000);
		// handle alert
		String actualAlertText = driver.switchTo().alert().getText();
		System.out.println(actualAlertText);
		driver.switchTo().alert().accept();
		
		
		// click on close bday
driver.findElement(By.xpath("//div[@class='closeDlgIframe']")).click();
driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@name='pat']")));
String actualValue = driver.findElement(By.xpath("//h2[contains(text(),'Medical Record')]")).getText();
System.out.println(actualValue);
	
//assertion
Assert.assertTrue(actualAlertText.contains("New Due Clinical Reminders"));
Assert.assertEquals(actualValue, "Medical Record Dashboard - john");




	}

}
