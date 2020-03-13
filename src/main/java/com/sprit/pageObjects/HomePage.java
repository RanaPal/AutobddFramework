package com.sprit.pageObjects;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sprit.baseutils.TestBase;

public class HomePage extends TestBase{
//	private static  WebDriver driver;
//public WebDriver  driver;	
public String ActualStr="";
@FindBy (xpath="//span [contains(text(),'Sign in')]") 
WebElement SigninFromHomepage;

@FindBy (xpath="//input [@name='email']")
WebElement emailId;

@FindBy (xpath="//*[@id='ap_change_login_claim']")
WebElement CorrectEmailId;


@FindBy (xpath="//input [@id='continue']")
WebElement xContinue;

@FindBy (xpath= "//*[@id=\"ap_password\"]")
WebElement passWord;

@FindBy (xpath= "//input [@id='signInSubmit']")
WebElement signInButton;


@FindBy (xpath= "//*[contains(text(),'We cannot find an account with that email address')]")
WebElement WrongEmailAddess;

@FindBy (xpath= "//*[contains(text(),'We cannot find an account with that mobile number')]")
WebElement WrongMobileNumber;

@FindBy (xpath= "//*[contains(text(),'Enter your email or mobile phone number')]")
WebElement BlankEmailorMobileNumber;

@FindBy (xpath="//span [contains(text(),'Hello,')]")
WebElement CorrectPassword;

@FindBy (xpath="//*[contains(text(),'Your password is incorrect')]")
WebElement wrongPassword;

//	public HomePage(WebDriver driver) {
//		this.driver=driver;
//		PageFactory.initElements(driver, this);
//	}

 public HomePage() {
	 initialization();
  PageFactory.initElements(driver, this);
 }

	public  void InvokeUrl(String URL) {
		driver.get(URL);	 
	
	}
	public String getHomePageTitle() {	
		return driver.getTitle();
	}
	
	public    void ClickonSignIn() {
		SigninFromHomepage.click();
	}
	public String getSigninPageTitle() {	
		return driver.getTitle();
	}
	
	public   void enterEmailId(String emailId) {
		this.emailId.sendKeys(emailId);
	}
	
	public   String verifyEmailId() {
		String ActualStr="";
		try {
			if(CorrectEmailId.isDisplayed())
				ActualStr="Valid userid";
		}
		catch (Exception e) {
			try {
				if (WrongEmailAddess.isDisplayed())
					ActualStr=WrongEmailAddess.getText();
			}
			catch (Exception e1) {
				try {
					if (WrongMobileNumber.isDisplayed())
						ActualStr=WrongEmailAddess.getText(); 
				}
				catch (Exception e2) {
					if (BlankEmailorMobileNumber.isDisplayed())
						ActualStr=BlankEmailorMobileNumber.getText();
				}
			}

		}
		return ActualStr;

	}
	public   void ClickOnContinue() {
		this.xContinue.click();
	}
	
	
	
	
	public   void enterPassWord(String passWord) {
		this.passWord.sendKeys(passWord);
	}
	public   boolean  ExistSignButton() {
		return this.signInButton.isDisplayed();
	}
	public   void ClickOnSignButton() {
		this.signInButton.click();
	}
	
	public   String VerifyPassWord() {
		String ActualStr="";
		try {
			if(CorrectPassword.isDisplayed())
				ActualStr="Valid Password";
		}
		catch (Exception e) {
			
				if (wrongPassword.isDisplayed())
					ActualStr=wrongPassword.getText();
			}
			return ActualStr;

	}
}
