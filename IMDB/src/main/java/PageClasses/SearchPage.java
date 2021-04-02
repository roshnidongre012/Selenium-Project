package PageClasses;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import BaseClass.TestBase;



public class SearchPage extends TestBase  {
	
	
	@FindBy(css="input[id='suggestion-search']")
	WebElement searchBox;
	
	@FindBy(css="button[id='suggestion-search-button']")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"main\"]/div/div[2]/table/tbody/tr[2]/td[2]/a")
	WebElement selectVideo;
	
	
	
	
	
	
	public SearchPage()throws IOException {
		
		PageFactory.initElements(driver, this);
	}
	
	
	
	public void searchShow() throws InterruptedException {
		Thread.sleep(2000);
		searchBox.click();
		searchBox.sendKeys("Game Of Thrones");
		Thread.sleep(3000);
		search.click();
	}
	
	public void selectShow() throws InterruptedException {
		
		Thread.sleep(3000);
		selectVideo.click();
       
	}
	
	public void pageTitle() {
		
		String actualTitle = driver.getTitle();
		String expectedTitle = "Game of Thrones (Video Game 2012) - IMDb";
		assertEquals(expectedTitle,actualTitle);
	}
	
	public void captureScreen() throws IOException, InterruptedException {
		
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File("C:/Users/Admin/eclipse-workspace/IMDB/Output Files/screenshot.png"));
		Thread.sleep(3000);
	}
	
	

}
