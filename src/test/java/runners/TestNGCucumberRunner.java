package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(  
		  //features = {"classpath:features"},
		  features = {"src/test/resources/functionalTests","src/test/resources/indicesfeatures"},  
		  glue = {"stepDefinitions"} ,
		  plugin={"html:target/cucumber-html-report", "json:target/cucumber.json",
					"pretty:target/cucumber-pretty.txt","usage:target/cucumber-usage.json", 
					"junit:target/cucumber-results.xml"}
		  ,monochrome = true
		  ,publish = true
		  ,snippets = io.cucumber.testng.CucumberOptions.SnippetType.CAMELCASE
		  ,tags = "@SmokeTest"  //,"@EsIndicesTest"}
		)  


public class TestNGCucumberRunner extends AbstractTestNGCucumberTests {
	
	
}