package org.pop;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNgConcept extends Base {
	
	@BeforeClass
	private void launchingChrome() {
		System.out.println("test 1");

	}
	@AfterClass
	private void closingChrome() {
		System.out.println("test 5");

	}
	@BeforeMethod
	private void startTime() {
		System.out.println("test 4");

	}

	@AfterMethod
	private void endTime() {
		System.out.println("test 2");

	}
	@Parameters({"email","password"})
	@Test
	private void tc1(String s1,String s2) throws InterruptedException {
        launchChrome();
       loadUrl("https://en-gb.facebook.com/");
		LoginPojo p = new LoginPojo();
       fill(p.getTxtUser(), s1);
       fill(p.getTxtPass(),s2);
       waits(5);
	}
	@Ignore
	@Test(invocationCount=3)
	private void tc2() {
		System.out.println("test3");
	}
}
