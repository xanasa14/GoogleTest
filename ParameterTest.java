import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver; 

public class ParameterTest {
	WebDriver driver;
	String url = "https://login.yahoo.com/";
	String emailId = "test@yahoo.com";
	@Test 
	@Parameters({"url","emailId"})
	
	public void yahooLoginTest(String url, String emailId) {
		System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\chromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("https://login.yahoo.com/");
		// url = "https://login.yahoo.com/"
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).clear();
		driver.findElement(By.xpath("//*[@id=\"login-username\"]")).sendKeys("test@yahoo.com");//enter the username
		driver.findElement(By.xpath("//*[@id=\"login-signin\"]")).click(); //Clicking on the next button 
		
	}
}
