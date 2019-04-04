import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver; 

public class ParameterTest {
	WebDriver driver;
	@DataProvider(name = "validSearch")
	public Object [][] adding(){
		return new Object[] []
			{
				{"2", "5"},
				{"3", "3"}
			};
	}
	String url = "https://login.yahoo.com/";
	String emailId = "test@yahoo.com";
	@Test(dataProvider = "validSearch") 
//	@Parameters({"a","b"})
	
	public void yahooLoginTest(String a, String b) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.get("https://www.google.com/");
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).clear();
		
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(a);
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys("+");
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[1]/div/div[1]/input")).sendKeys(b);
		
		/*
		 * driver.findElement(By.id("sciInPut")).sendKeys("+"); Thread.sleep(3000);
		 * driver.findElement(By.id("sciInPut")).sendKeys(b);
		 */
		driver.findElement(By.xpath("//*[@id=\"tsf\"]/div[2]/div/div[2]/div[2]/div/center/input[1]")).click();
		WebElement result = driver.findElement(By.xpath("//*[@id=\"cwos\"]"));
		String finalResult = result.getText();
		int firstNum = Integer.parseInt(a);
		int secondNum = Integer.parseInt(b);
		int Res = firstNum + secondNum;
		Assert.assertEquals(finalResult, Res);

		
	}
}
