package TestCases;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import BaseClass.TestBase;
import PageClasses.SearchPage;



public class TestCase01 extends TestBase {
	SearchPage searchPage;
	
	
	public TestCase01() throws IOException
    {
		super();
	}
	
	@BeforeClass
	public void browserSetUp() 
	   {
		   initializeBrowser();
		   System.out.println("Browser is launched");
	   }
	
	@Test (priority=1)
	public void SearchShow() throws IOException, InterruptedException {
		
		searchPage= new SearchPage();
		searchPage.searchShow();
	}
	
	@Test(priority=2)
	public void selectshow() throws InterruptedException {
		
		searchPage.selectShow();
		
	}
	
	@Test(priority=3)
	public void verifyPage() {
		
		searchPage.pageTitle();
	}
	
	@Test(priority=4)
	public void captureScreenshot() throws IOException, InterruptedException {
		
		searchPage.captureScreen();
	}
	
	
	
	
	 @AfterClass
	 public void teamDown() 
	   {
		 
		   driver.close(); 
		   System.out.println("User is out of IMDB site");
	   }
	   

}
