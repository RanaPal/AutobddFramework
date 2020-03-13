package com.sprit.Runner;
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 

@RunWith(Cucumber.class)
@CucumberOptions(
  features="src/test/resource/Features",
//tags = "@sanity",   //skip  ~@tag1 or 'not @tag1' for multiple tag {@tag1,@tag2}
  glue= "com.sprit.Stepdefination",
 		  plugin={"html:target/PortalSignin","rerun:target/rerun.txt"} 
// 		 plugin="json:target/Samp_reports/customerSignin-report.json"
		 ,dryRun=false
		 
  )

public class CustomeSigninRunner {

}
