import org.testng.annotations.Test;
// dependencies
public class TestNGFeatures {
@Test 
public void loginTest() {
	System.out.println("login Test");
	int i = 9/0;
}
@Test (dependsOnMethods = "loginTest")
public void homePageTest() {
	System.out.println("homePage Test");
}
@Test (dependsOnMethods = "loginTest")
public void searchPageTest() {
	System.out.println("search Page Test");
}
	
@Test (dependsOnMethods = "loginTest")
public void regPageTest() {
	System.out.println("registration Page Test");
}

}
