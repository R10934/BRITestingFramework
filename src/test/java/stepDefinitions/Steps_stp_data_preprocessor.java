package stepDefinitions;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

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
	    //throw new io.cucumber.java.PendingException();
		
		System.out.println("I am in when section");
	}


	@Then("I expect response")
	public void i_expect_response() {
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/data-preprocessor/STP");

		String jsonString = response.asString();
		
		List<Map<String, String>> id = JsonPath.from(jsonString).get("id");
		Assert.assertTrue(id.size() > 0);

		String value_Id = id.get(0).get("id");	   
		
		System.out.print(value_Id);
	}


}
