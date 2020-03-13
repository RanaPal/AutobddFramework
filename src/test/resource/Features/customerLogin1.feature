Feature: `User Sign in credential to Customer Portal
 

Scenario Outline: User sign in to Customer portal with valid login credential

Given User with the URL "<URL>" can invoke Customer portal
And  Verify the window has the page title "<HomePageTitle>"  
Then User click on SIGN-IN button
And  Sign-in window "<SignInPageTitle>" Pops-up

And User enter emailid "<Email_Cell>"
And Click on continue button
And User enter password "<password>"
And press Sign-in button to sucessfully sign in to portal

 
Examples:
 
|URL|HomePageTitle|SignInPageTitle|Email_Cell|password|
|https://www.amazon.com/|Amazon.com: Online Shopping for Electronics|Amazon Sign-In|apalnextgen@gmail.com|Apsc1615|


