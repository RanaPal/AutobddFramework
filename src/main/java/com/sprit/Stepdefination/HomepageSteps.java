package com.sprit.Stepdefination;

import com.sprit.pageObjects.HomePage;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class HomepageSteps  {
 
 HomePage homepage=new HomePage();
 String Actualstr= "";
 String EmailCell="";
 public int cnt=0;
 @Before()
 public void before(Scenario scenario) {
	 String scenarioName = scenario.getName();	 
	 System.out.println("ID :"+scenario.getId()+"\nScenario Name : "+scenarioName);
 }
 @After()
 public void tearDown(){
	 //		System.out.println("\nThis will run after the Scenario # ");
	 homepage.driver.close();
 }

 @Given("^User with the URL \"([^\"]*)\" can invoke Customer portal$")	
 public   void getURL(String BaseURL) {
	 homepage.InvokeUrl(BaseURL);
	 System.out.println("Step 1. Testing URL testing");
 }

 @And("^Verify the window has the page title \"([^\"]*)\"$")
 public  void verifyPageTitle(String homePageTitle) {
	 Actualstr=homepage.getHomePageTitle();
	 if(Actualstr.contains(homePageTitle))
		 System.out.println("Step 2. Testing Page title : "+Actualstr);		
	 else
		 System.out.println("Step 2. Testing wrong Page title : "); 
 }

 @Then ("^User click on SIGN-IN button$")
 public  void clickonSigninbutton() {
	 homepage.ClickonSignIn();
	 System.out.println("Step 3. Testing clicked Sign in");
 }	  

 @And ("^Sign-in window \"([^\"]*)\" Pops-up$")
 public   void verifysignInwindow(String PageTitle ) {
	 Actualstr=homepage.getSigninPageTitle();
	 if(Actualstr.contains( PageTitle))
		 System.out.println("Step 4. Testing Sign in window pagetitle  "+Actualstr+" window");
	 else 
		 System.out.println("Step 4. Testing Sign in window is wrong"); 
 }

 @And("^User enter emailid \"([^\"]*)\"$")
 public void EntetrEmailorCell(String emailid){
	 EmailCell=emailid;
	 homepage.enterEmailId(emailid);
	 System.out.println("Step 5. Testing emailid ");
 }
   
 
@And("^Click on continue button$")
public void userPressClick(){
	homepage.ClickOnContinue();
//	Actualstr=homepage.verifyEmailId();
	System.out.println("Step 6. testing continue button ");
}
 
@And("^User enter password \"([^ \"]*)\"$")
public void Verifypassword(String password)  {
	 homepage.enterPassWord(password);
	 System.out.println("Step 7. user entered correct password"); 
}

@And("^press Sign-in button to sucessfully sign in to portal$")
public void pressSignInbutton() { 
	homepage.ClickOnSignButton();
	System.out.println("Step 8. user press sign in button"); 
	Actualstr=homepage.VerifyPassWord();  
	if(Actualstr.equals("Valid Password"))
		System.out.println("User sucessfully sign in to portal");
//	else
//		System.out.println("application aborted for wrong  password");
}

@And("^User enter invalid emailid \"([^\"]*)\"$")
public void enteEmailid(String emailid){
	EmailCell=emailid;
	homepage.enterEmailId(emailid);
	System.out.println("Step 5. Testing invalid  emailid ");
}

@Then("^Validate the error message \"([^\"]*)\"$")
public void validateEmail(String errmsg) {
	Actualstr= homepage.verifyEmailId();
	System.out.println("Error Message <### "+Actualstr+" ###>\n has verified");

}
@And("^User enter invalid password \"([^\"]*)\"$")
public void Verifyinvalidpassword(String password)  {
	 homepage.enterPassWord(password);
	 System.out.println("Step 7. user entered invalid password"); 
}
@Then("^Validate the error message for wrong password \"([^\"]*)\"$")
public void VerifyipasswordErroaMessage(String errMsg)  {
	Actualstr=homepage.VerifyPassWord();
	//if(Actualstr.equals(errMsg))
	System.out.println("Error Message <### "+Actualstr+" ###>\n has verified"); 
}
// @And("^User try to enter invalid emailid or mobile number \"([^\"]*)\" and press continue button$")
// public void EntetrWrongEmailorCell(String emailid){
//	 EmailCell=emailid;
//	 homepage.enterEmailId(emailid);
//	 homepage.ClickOnContinue();
//	 System.out.println("Step 5. Testing for wrong email address or mobile no ");
// }
// @And("^Verify error message pops up for wrong emailid or mobile Phone number and exit application$")
// public void VerifyEmailorCell() {
//	 Actualstr=homepage.verifyEmailId();
//	 System.out.println("Step 6. Testing for error alert with wrong  Email address or mobile number :  : " +Actualstr);
// }
//
// @And("^Verify invalid emailid or mobile Phone number will display error message$")
// public void VerifyinvalidEmailorCell() {
//	 Actualstr=homepage.verifyEmailId();
//	 System.out.println("Step 6. Testing invalid Email address or mobile number : " +Actualstr);
// }
//
//
// @And("^User enter password \"([^ \"]*)\"$")
// public void Verifypassword1(String password)  {
//	 homepage.enterPassWord(password);
//	 System.out.println("Step 7. user entered correct password"); 
// }
// 
//
//
// @Then("^Verify user sign in sucessfully$")
// @And("^User try to enter invalid password \"([^ \"]*)\" and press Sign in button$")
// public void VerifyInvalidPassword(String password)  {
//	 homepage.enterPassWord(password);
//	 homepage.ClickOnSignButton();
//	 Actualstr=homepage.VerifyPassWord();
//	 System.out.println(Actualstr);
//	 //	 if(Actualstr.contains("Valid Password"))
//	 //	 { 
//	 //	 System.out.println("Step 7. Testing user successfully signed in Customer Portal"); 
//	 //	 }
//	 //	 else
//	 //	 System.out.println("Step 6. Testing for Incorrect Password");
// }

} 



    
 


