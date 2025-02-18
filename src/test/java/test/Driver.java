package test;

import org.testng.annotations.Test;

public class Driver extends BaseClass {
	Signup obj = new Signup();

	@Test
	public void login() throws Exception {
		obj.login();
	}

}
