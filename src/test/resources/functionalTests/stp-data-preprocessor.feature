#Author: rupesh.rathour1@nhs.net

@SampleTest
Feature: To Test GET API call to the endpoint https://bir-master-bir-stp-data-preprocessor.k8s-nonprod.texasplatform.uk/data-preprocessor/STP
  Description: The purpose of these tests are to cover happy flow for GET API.  
  Aws S3 URL: 

  Scenario: The Genuine and valid user can get access data source STP on S3 
    Given A valid endpoint is available 
    When User make request to access
    Then User expect response
