#Author: rupesh.rathour1@nhs.net
@SmokeTest
Feature: To Test GET API call to the endpoint https://bir-master-bir-stp-data-preprocessor.k8s-nonprod.texasplatform.uk/data-preprocessor/STP
  Description: The purpose of these tests are to cover happy flow for GET API.  
  Aws S3 URL:

  Scenario: smoke test when Genuine and valid user get access data source STP on S3
    Given A valid endpoint is available
    When User make request to access
    Then User expect response

  Scenario Outline: smoke test the Json top level categories returned
    Given A call to the API
    Then the response should have expected

    Examples: 
      | entityList    |
      | singleOrgList |
      | groupOrgList  |
