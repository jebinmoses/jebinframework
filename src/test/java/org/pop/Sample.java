package org.pop;

import java.io.IOException;

public class Sample extends Base {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		launchChrome();
		loadUrl("https://en-gb.facebook.com/");
		winMax();
		takeScreenShot();
		System.out.println("screenshot taken sucessfully");
		
		LoginPojo p = new LoginPojo();
		
		fill(p.getTxtUser(), getData(2, 0));
		fill(p.getTxtPass(),getData(4, 4));
		
		 
 
		
		//btnClick(p.getBtnLogin());
		 driver.navigate().refresh();
		 
		 Thread.sleep(2000);
		 
		 LoginPojo p1 = new LoginPojo();
		 
	fill(p1.getTxtUser(),getData(3, 0));
	fill(p1.getTxtPass(),getData(3, 4));
	
	btnClick(p1.getBtnLogin());
	
	
		
	}
	
	

}
