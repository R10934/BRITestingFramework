package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;

public class Steps_stp_data_preprocessor {
	
	private static final String USER_ID = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	private static final String BASE_URL = "https://bir-master-bir-stp-data-preprocessor.k8s-nonprod.texasplatform.uk";
	
	@Given("A valid endpoint is available")
	public void a_valid_endpoint_is_available() {
	    
		RestAssured.baseURI = BASE_URL;
		
		RestAssured.given()
				   .get("/data-preprocessor/STP")
				   .then()
				   .statusCode(200)
				   ;
		
		
	}


	@When("I make request to access")
	public void i_make_request_to_access() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


	@Then("I expect response")
	public void i_expect_response() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}


}
