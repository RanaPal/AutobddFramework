Feature: Validate User Sign in credential to Customer Portal
 
@regression
Scenario Outline: User can not sign in to Customer portal with invalid emailid
Given User with the URL "<URL>" can invoke Customer portal
And  Verify the window has the page title "<HomePageTitle>"  
Then User click on SIGN-IN button
And  Sign-in window "<SignInPageTitle>" Pops-up

And  User enter invalid emailid "<Email_Cell>" 
And  Click on continue button
Then Validate the error message "<Error_message>" 


 
Examples:
 
|URL|HomePageTitle|SignInPageTitle|Email_Cell|Error_message|
|https://www.amazon.com/|Amazon.com: Online Shopping for Electronics|Amazon Sign-In|apalnextgen@gmail.bom|We cannot find an account with that email address|

@regression1
Scenario Outline: User can not sign in to Customer portal with balank emailid

Given User with the URL "<URL>" can invoke Customer portal
And  Verify the window has the page title "<HomePageTitle>"  
Then User click on SIGN-IN button
And  Sign-in window "<SignInPageTitle>" Pops-up

And  Click on continue button
Then Validate the error message "<Error_message>" 


 
Examples:
 
|URL|HomePageTitle|SignInPageTitle|Error_message|
|https://www.amazon.com/|Amazon.com: Online Shopping for Electronics|Amazon Sign-In|Enter your email or mobile phone number|

@sanity
Scenario Outline: User can not sign in to Customer portal with invalid password

Given User with the URL "<URL>" can invoke Customer portal
And  Verify the window has the page title "<HomePageTitle>"  
Then User click on SIGN-IN button
And  Sign-in window "<SignInPageTitle>" Pops-up

And User enter emailid "<Email_Cell>"
And Click on continue button
And User enter invalid password "<password>"
And press Sign-in button to sucessfully sign in to portal
Then Validate the error message for wrong password "<Error_message>" 

 
Examples:
 
|URL|HomePageTitle|SignInPageTitle|Email_Cell|password|Error_message|
|https://www.amazon.com/|Amazon.com: Online Shopping for Electronics|Amazon Sign-In|apalnextgen@gmail.com|Apsc!1615|Your password is incorrect|
