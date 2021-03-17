#Author: rupesh.rathour1@nhs.net
@EsIndicesTest
Feature: To Test GET API call to the endpoint https://vpc-bir-analysis-tkpwxtby3yxh7ks7y6gztvik74.eu-west-2.es.amazonaws.com/nhscapability/_search
  Description: The purpose of these tests are to cover happy flow for GET API.

  Scenario: To test elastisearch nhscapablity indices
    Given A call to the API
    Then User should expect valid status code
    And Response validate against the Json schema
