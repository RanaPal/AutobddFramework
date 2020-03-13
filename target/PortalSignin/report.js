$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resource/Features/customerLogin2.feature");
formatter.feature({
  "name": "Validate User Sign in credential to Customer Portal",
  "description": "",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "name": "User can not sign in to Customer portal with invalid password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.step({
  "name": "User with the URL \"\u003cURL\u003e\" can invoke Customer portal",
  "keyword": "Given "
});
formatter.step({
  "name": "Verify the window has the page title \"\u003cHomePageTitle\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "User click on SIGN-IN button",
  "keyword": "Then "
});
formatter.step({
  "name": "Sign-in window \"\u003cSignInPageTitle\u003e\" Pops-up",
  "keyword": "And "
});
formatter.step({
  "name": "User enter emailid \"\u003cEmail_Cell\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "Click on continue button",
  "keyword": "And "
});
formatter.step({
  "name": "User enter invalid password \"\u003cpassword\u003e\"",
  "keyword": "And "
});
formatter.step({
  "name": "press Sign-in button to sucessfully sign in to portal",
  "keyword": "And "
});
formatter.step({
  "name": "Validate the error message for wrong password \"\u003cError_message\u003e\"",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "URL",
        "HomePageTitle",
        "SignInPageTitle",
        "Email_Cell",
        "password",
        "Error_message"
      ]
    },
    {
      "cells": [
        "https://www.amazon.com/",
        "Amazon.com: Online Shopping for Electronics",
        "Amazon Sign-In",
        "apalnextgen@gmail.com",
        "Apsc!1615",
        "Your password is incorrect"
      ]
    }
  ]
});
formatter.scenario({
  "name": "User can not sign in to Customer portal with invalid password",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@sanity"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "User with the URL \"https://www.amazon.com/\" can invoke Customer portal",
  "keyword": "Given "
});
formatter.match({
  "location": "HomepageSteps.getURL(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Verify the window has the page title \"Amazon.com: Online Shopping for Electronics\"",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.verifyPageTitle(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User click on SIGN-IN button",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageSteps.clickonSigninbutton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Sign-in window \"Amazon Sign-In\" Pops-up",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.verifysignInwindow(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter emailid \"apalnextgen@gmail.com\"",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.EntetrEmailorCell(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Click on continue button",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.userPressClick()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter invalid password \"Apsc!1615\"",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.Verifyinvalidpassword(String)"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "press Sign-in button to sucessfully sign in to portal",
  "keyword": "And "
});
formatter.match({
  "location": "HomepageSteps.pressSignInbutton()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Validate the error message for wrong password \"Your password is incorrect\"",
  "keyword": "Then "
});
formatter.match({
  "location": "HomepageSteps.VerifyipasswordErroaMessage(String)"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});