package test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.HomePage;

public class MainTest {
	WebDriver driver;
	HomePage homePage;
	
  @Test(priority=0)
  public void verifyClickOnGoogle() {
	  homePage= new HomePage(driver);
	  try{
	  homePage.verifyClick();
	  AssertJUnit.assertTrue(driver.getCurrentUrl().contains("doodles"));
	  }
	  catch (Exception e) {
		  Assert.fail("There's a prob-->"+ e.getCause());
	  }
	  
  }
  
  @Test(priority=1)
  public void verifyTest() {
	  driver.get("http://www.google.com");
	  driver.manage().window().maximize();
	  driver.findElement(By.name("btnI")).click();
	  new WebDriverWait(driver,10).until(ExpectedConditions.urlContains("doodles"));
	  AssertJUnit.assertEquals(driver.findElement(By.id("latest-title")).getText(), "Celebrating Ludwig van Beethoven's 245th Year");
  }
  
  @BeforeTest
  public void beforeTest() {
	  driver=new FirefoxDriver();
  }

  @AfterTest
  public void afterTest() {
	  driver.quit();
  }

  @AfterMethod
  public void captureScreenshot(ITestResult testResult){
	  if(testResult.getStatus()==ITestResult.FAILURE) {
		  File scrFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		  try {
			FileUtils.copyFile(scrFile, new File("C:\\Users\\manas.goswami\\workspace\\MyTest\\target\\screens\\scr"+ new java.util.Date().getTime()+".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	  }
	  
  }
}
