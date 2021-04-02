package BaseClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;

	public TestBase() throws IOException {
		try {
			prop= new Properties();
			FileInputStream ip= new FileInputStream("C:/Users/Admin/eclipse-workspace/IMDB/src/main/java"
					+ "/ConfigFile/config.properties");
			prop.load(ip);
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void initializeBrowser() {
		String browserName= prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			
			System.setProperty("webdriver.chrome.driver",
                    System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
		else if(browserName.equals("firefox")) {
			  
			System.setProperty("webdriver.firefox.driver",
                    System.getProperty("user.dir") + "/Drivers/geckodriver.exe");
			driver= new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
		driver.get(prop.getProperty("url"));
	}
	
}