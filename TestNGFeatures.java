import org.testng.annotations.Test;
// dependencies
public class TestNGFeatures {
@Test 
public void loginTest() {
	System.out.println("login Test");
	int i = 9/0;
}
	
//invocationCount = 10 will run 10 times that particular test case. It has to be in between parenthesis right next to the annotations @Test 	
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
