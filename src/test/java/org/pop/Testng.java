package org.pop;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Testng {

	@Test
	private void tc3() {
		System.out.println("test 3");

	}
	
	@Test
	private void tc4() {
		System.out.println("test 4");

	}
	
	@Test(retryAnalyzer=Failed.class)
	private void tc2() {
		Assert.assertTrue(false);
		System.out.println("test 2");

	}
	
	@Test(retryAnalyzer=Failed.class)
	private void tc6() {
		System.out.println("test 6");
	}
}
