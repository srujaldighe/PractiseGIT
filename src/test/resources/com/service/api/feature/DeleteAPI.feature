@DELETEAPI
Feature: To Validate DELETE Request

  Scenario Outline: To validate the response code once user will hit the DELETE API for 204 response
    Given I want to setup base url
    And I want to setup the endpoint url for DELETE Api
    When I hit the api using DELETE method
    Then I should validate the status code is <statusCode>
    
    Examples:
    |statusCode|
    |204|