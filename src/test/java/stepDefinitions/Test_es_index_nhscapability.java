package stepDefinitions;

import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_es_index_nhscapability {
	
	private static final String BASE_URL = "https://vpc-bir-analysis-tkpwxtby3yxh7ks7y6gztvik74.eu-west-2.es.amazonaws.com";
	
	String response01 = "";
	
	@Given("A call to the API")
	public void a_call_to_the_api() {
	    
		RestAssured.baseURI = BASE_URL;
		
		RestAssured.given()
				   .get("/nhscapability/_search")
				   .then()
				   .statusCode(200)
				   ;		
	}


	@Then("User should expect valid status code")
	public void user_should_expect_valid_status_code() {
		
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/nhscapability/_search");
		
		response01 = response.asString();
		
		Assert.assertEquals(200, response.getStatusCode());
	}


	@Then("Response validate against the Json schema")
	public void response_validate_against_the_json_schema() {
		
		try (InputStream inputStream = getClass().getResourceAsStream("/jsonschema/indices/nhscapability.json")) {
			  JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			  Schema schema = SchemaLoader.load(rawSchema);
			  schema.validate(new JSONObject(response01)); // throws a ValidationException if this object is invalid
			} catch (IOException e) {
				System.out.println("Error - " + e.getMessage());	
			}
			catch (ValidationException vex) {
				System.out.println("Error - " + vex.getMessage());	
			}
			catch (Exception ex) {
			System.out.println("Error - " + ex.getMessage());	
		}

			
	}

}
