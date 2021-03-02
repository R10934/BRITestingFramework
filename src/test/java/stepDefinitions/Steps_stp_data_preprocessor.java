package stepDefinitions;

import static org.testng.Assert.assertEquals;

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
	
	String response01 = "";
	
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
		RestAssured.baseURI = BASE_URL;
		RequestSpecification request = RestAssured.given();
		Response response = request.get("/data-preprocessor/STP");
		
		response01 = response.asString();
		
		Assert.assertEquals(200, response.getStatusCode());
	}


	@Then("I expect response")
	public void i_expect_response() {
		

		List<Map<String, String>> entityList = JsonPath.from(response01).get("entityList");
		Assert.assertTrue(entityList.size() > 0);
		
		List<Map<String, String>> singleOrgList = JsonPath.from(response01).get("singleOrgList");
		Assert.assertTrue(entityList.size() > 0);

		List<Map<String, String>> groupOrgList = JsonPath.from(response01).get("groupOrgList");
		Assert.assertTrue(entityList.size() > 0);
		
		
		// Verification of Entitylist		
		assertEquals(entityList.get(0).get("entityId"), "792676");
		assertEquals(entityList.get(0).get("entityType"), "Single Org");
		assertEquals(entityList.get(0).get("primaryTaxonomy"), "NHS Digital");
		assertEquals(entityList.get(0).get("secondaryTaxonomy"), "");
		
		// Verification of singleOrgList		
		assertEquals(singleOrgList.get(0).get("entityId"), "792676");
		assertEquals(singleOrgList.get(0).get("odsCode"), "REM");
		assertEquals(singleOrgList.get(0).get("name"), "Liverpool University Hospitals NHS Foundation Trust");
		assertEquals(singleOrgList.get(0).get("orgType"), "NHS Trust");
		assertEquals(singleOrgList.get(0).get("peer"), "");
		assertEquals(singleOrgList.get(0).get("region"), "North West");
		assertEquals(singleOrgList.get(0).get("stp"), "CHESHIRE AND MERSEYSIDE STP");
		
		
		
		// Verification of groupOrgList		
		assertEquals(groupOrgList.get(0).get("entityId"), "724241");
		assertEquals(groupOrgList.get(0).get("groupType"), "Region");
		assertEquals(groupOrgList.get(0).get("name"), "East of England");
		assertEquals(groupOrgList.get(0).get("budgetTotal"), "0");
		assertEquals(groupOrgList.get(0).get("budgetIT"), "0");
		assertEquals(groupOrgList.get(0).get("budgetCyber"), "0");
		
		//System.out.print(value_Id);
	}
}
