package org.pop;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//by using test level
//edge facing isues

public class ParallelExecution {
	
	public WebDriver driver;
	@Parameters({"browser"})
	@Test
	public  void testCase1(String name) {
		if (name.equals("chrome")) {
			System.out.println("chrome browser launching");
			WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
		} 
		else if (name.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();
		}
		driver.get("https://en-gb.facebook.com");
	}
	
       
	} 
 
     
