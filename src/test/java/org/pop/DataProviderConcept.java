package org.pop;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderConcept extends Base{
	
	@Test(dataProvider= "fblogin")
	private void tc1(String name,String pass) throws InterruptedException {
		
		launchChrome();
		loadUrl("https://en-gb.facebook.com");
		
        LoginPojo j = new LoginPojo();
        fill(j.getTxtUser(),name);
        fill(j.getTxtPass(),pass);
        waits(5);
	}
	
	
	
	
	
	
	
	
	
	

		
	@DataProvider(name="fblogin")
      public Object[][] data() {
		
		
		return new Object[][] {
			{"java","java@123"},
			{"sql","sql@123"},
			{"vijay","vijay@123"}
		};
	}
}
