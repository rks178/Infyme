package test;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.testng.Assert;

public class Signup extends BaseClass {

	public void login() throws Exception {
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("Resources\\credential.properties");
		prop.load(fis);
		fis.close();
		String username = prop.getProperty("username");
		String password = prop.getProperty("password");
		driver.findElement(By.name("username")).sendKeys(username);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.id("submit")).click();
		String title = driver
				.findElement(By.xpath("//*[text()='Congratulations student. You successfully logged in!']")).getText();
		Assert.assertEquals(title, "Congratulations student. You successfully logged in!");
	}

}
