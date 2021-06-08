package com.cyient.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	@DataProvider
	
	public Object[][] validData()
	{
		Object[][] main=new Object[2][2];
		main[0][0]="admin";
		main[0][1]="pass";
		
		main[1][0]="admin";
		main[1][1]="pass";
		return main;
	}
	
	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println("Test Run"+username+password);
	}

}
