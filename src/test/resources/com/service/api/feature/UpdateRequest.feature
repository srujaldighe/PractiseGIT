@UpdateAPIResponse
Feature: To validate PUT Api Response
  I want to write the scenarios to test the PUT Api response
  
  
  Scenario Outline: To validate the response once user will hit the PUT API
    Given I want to setup base url
    And I want to setup the endpoint url of PUT Api
    And I should setup the PUT payload to Create data
    When I hit the api using PUT method
    Then I should validate the status code is <statusCode>
    And I should Validate the response body field "<name>","<job>"
    Examples:
    |statusCode|name|job|
    |200|morpheus|zion resident|