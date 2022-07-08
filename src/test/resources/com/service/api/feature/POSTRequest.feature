@PostAPIResponse
Feature: To validate POST Api Response
  I want to write the scenarios to test the POST Api response
  
 
  Scenario Outline: To validate the response once user will hit the POST API
    Given I want to setup base url
    And I want to setup the endpoint url of POST Api
    And I should setup the POST payload to Create data
    When I hit the api using POST method
    Then I should validate the status code is <statusCode>
    And I should Validate the response body field "<name>","<job>"
    Examples:
    |statusCode|name|job|
    |201|morpheus|leader|
    
    
  Scenario Outline: To validate the response for 400 Bad Request once user will hit the POST API
    Given I want to setup base url
    And I want to setup the endpoint url for Bad Request
    And I should setup the POST payload for Bad Request
    When I hit the api using POST method
    Then I should validate the status code is <statusCode>
    And I should Validate the response body field "<errorMessage>"
    Examples:
    |statusCode|errorMessage|
    |400|Missing password|  