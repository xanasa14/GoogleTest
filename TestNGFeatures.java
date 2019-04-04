import org.testng.annotations.Test;
// dependencies
public class TestNGFeatures {
@Test 
public void loginTest() {
	System.out.println("login Test");
	int i = 9/0;
}
	
//invocationCount = 10 will run 10 times that particular test case. It has to be in between parenthesis right next to the annotations @Test 	

//invocationTimeOut=2000 will time out the test case in 2 seconds. The number goes in milliseconds.
	
// expectedException= NumberFormatException.class to run a error and succeed it 
@Test (expectedException=NumberFormatException.class)
public void test1(){
	String x = "100A";
	Integer.parseInt(x);
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
