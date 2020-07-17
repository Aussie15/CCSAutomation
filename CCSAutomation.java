package com.w2a.testcases;

import java.io.IOException;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.TestUtil;

public class CCSAutomation extends TestBase{

	@Test(dataProviderClass=TestUtil.class, dataProvider="dp")
	public void CCSRegister(Hashtable<String, String> data) throws InterruptedException, IOException {
		
		click("signin_XPATH");
		
		type("email_XPATH", data.get("Username"));
		
		type("password_XPATH", data.get("Password"));
		
		click("signinBtn_XPATH");
		
		Thread.sleep(3000);
		
		click("launchBtn_XPATH");
		
		Thread.sleep(3000);
		
		click("folder1_XPATH");
		
		WebElement draggable = driver.findElement(By.xpath("//li[@draggable='true']"));
		WebElement droppable = driver.findElement(By.xpath("//span[text()='Folder 2']"));
//		
		Actions builder = new Actions(driver);
//		action.dragAndDrop(draggable, droppable).build().perform();
		Thread.sleep(3000);
		Action dragAndDrop = builder.clickAndHold(draggable)
				   .moveToElement(droppable)
				   .release(droppable)
				   .build();

				dragAndDrop.perform();
		
		click("folder2_XPATH");
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@data-tip='Project 1']"))).click();
		
		
	}
}
