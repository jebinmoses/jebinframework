package org.pop;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JunitConcept extends Base{
	
	@BeforeClass
	public static void LaunchingChrome() {
		launchChrome();
		
		
	}
	@AfterClass
	 public static  void closingChrome() {
		closeChrome();
	}
	@Before
	public   void startTime() {
		printStartTime();

	}
	@After
	public  void endTime() {
		printEndTime();

	}
	@Test
	public  void tc1() throws IOException {
		loadUrl("https://en-gb.facebook.com/");
		
		String title = driver.getTitle();
	//	Assert.assertTrue("verify the title",false);
		
				LoginPojo j = new LoginPojo();
					fill(j.getTxtUser(),getData(2, 0));
  			fill(j.getTxtPass(),getData(2, 4));
  					btnClick(j.getBtnLogin());
  					getSleep(10);
  					//driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS );
  					driver.navigate().refresh();
  			
	}
	@Test
	public void tc2() throws IOException {
		loadUrl("https://en-gb.facebook.com/");
		
		LoginPojo j1 = new LoginPojo();
		fill(j1.getTxtUser(),getData(2, 3));
		fill(j1.getTxtPass(), getData(2, 1));
		btnClick(j1.getBtnLogin());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	
	
	

}
