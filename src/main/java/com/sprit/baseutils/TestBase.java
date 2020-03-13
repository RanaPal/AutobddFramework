package com.sprit.baseutils;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	static ArrayList<String> alfldname =new ArrayList<String>();
	static ArrayList<String> alfldval =new ArrayList<String>();
    static String Custname= "" ;
    static String RefundAmt ="";
    static String TABLE_NAME="customer";
	static String ReturnVal="";
	static String Browser="Chrome"; // Ch , FFox, IE,HeadLess
	static String browStat="nHeadLess";
	public static String  Actualstr="";
	public static String Expected="";
	static String FinalRefund="";
	public static int chkFieldType=0;
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static WebElement Webelement; 
	public static int cnt=0;
	public static boolean QA=false;	
	
	public TestBase() {
	System.out.println("Processing TestBase ");
	
	}
		
		
		
		public  void initialization() {
			if (Browser.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver","C:\\Automation\\chromedriver.exe");
				if (browStat.equals("HeadLess"))
				{ 
					ChromeOptions options= new ChromeOptions();
					options.addArguments("window_size=1400,800");
					options.addArguments("headless");
					driver=new ChromeDriver(options);	 
				}
				else
					driver=new ChromeDriver();
			}
			else if (Browser.equals("IE")) {
				System.setProperty("webdriver.ie.driver", "C:\\Automation\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				
				}
			else if (Browser.equals("Firefox")) {
			    	System.setProperty("webdriver.gecko.driver","C:\\Automation\\geckodriver.exe");
				  driver=new FirefoxDriver();
			}	
			driver.manage().window().maximize();
  	//	    driver.manage().deleteAllCookies();
//		    driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOADTIMEOUT,TimeUnit.SECONDS);
//		    driver.manage().timeouts().implicitlyWait(TestUtil.IMPLESIT_WAIT, TimeUnit.SECONDS);
  		    
		//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		//	  wait = new WebDriverWait(driver, 10);
	    }

	}
	


