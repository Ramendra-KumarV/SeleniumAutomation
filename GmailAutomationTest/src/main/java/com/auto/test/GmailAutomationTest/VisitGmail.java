package com.auto.test.GmailAutomationTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.auto.test.DriverPackage.InitilizeWebDriver;
import com.auto.test.Functionalities.gmailFunctionality;

public class VisitGmail implements gmailFunctionality {
	static WebDriver driver=null;
	
	List<String> subjectList=new ArrayList<String>();
	
	VisitGmail(){
		System.out.println("Successfully selected gmail");
	}
	
	public void openBrowser(String name) {
		
		driver =InitilizeWebDriver.DriverObject(name);
	}

	public void login(String userName, String password) {
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.navigate().to("https://mail.google.com");
		driver.manage().window().maximize();
		
		try {
			WebElement elementId = driver.findElement(By.xpath("//input[@id='identifierId']"));
			WebDriverWait wait = new WebDriverWait(driver, 30); // here, wait time is 20 sec

			wait.until(ExpectedConditions.visibilityOf(elementId)); // this will wait for element to be visible for 20
																	// seconds
			elementId.sendKeys("abctest.rbc@gmail.com");

			driver.findElement(By.xpath("//div[@id='identifierNext']")).click();

			driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

			WebElement elementPassword = driver.findElement(By.xpath("//*[@id=\"password\"]/div[1]/div/div[1]/input"));

			WebDriverWait wait1 = new WebDriverWait(driver, 30);
			wait1.until(ExpectedConditions.visibilityOf(elementPassword));
			elementPassword.sendKeys("seedtheman0#"); // this will wait for element to be visible for 20 seconds
			driver.findElement(By.xpath("//div[@id='passwordNext']")).click();

		}catch(Exception e) {
			System.out.println("Exception in login"+e);
		}
	
	}

	public void printSubjectOfEmail() {
		try {
			
			for (int i = 1; i < 51; i++) {
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			//	driver.findElement(By.className("aKz")).click();
				
				
				
				
				
				 String innerText = driver.findElement( By.xpath("/html/body/div[7]/div[3]/div/div[2]/div[1]"+"/div[2]/div/div/div/div/div[2]/div/div[1]/div/div/div[8]/div/div[1]/div[3]/div/table/tbody/tr["
			            +i+"]/td[6]/div/div/div/span/span")).getText();
			 
				  subjectList.add(innerText);
				}
			
			System.out.println("Subjects of Mail");
		      for (int counter = 0; counter < subjectList.size(); counter++) { 		      
		          System.out.println(subjectList.get(counter)+"\n"); 		
		      } 
			
		}
		catch(Exception e) {
			System.out.println("Exception in reading subject"+e);
		}
		finally {
			
			driver.close();
		}
		
		
		
	}

	
	

	

}
