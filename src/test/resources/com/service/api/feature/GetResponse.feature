@GetAPIResponse
Feature: To validate GET Api Response
  I want to write the scenarios to test the GET Api response
  

  Scenario Outline: To validate the response code once user will hit the GET API for the list of users response
    Given I want to setup base url
    And I want to setup the endpoint url of GET Api
    When I hit the api using GET method
    Then I should validate the status code is <statusCode>
    And I should validate the response Body fields "<page>","<total>","<id>","<email>","<firstName>","<lastName>","<avatar>"
    Examples:
    |statusCode|page|total|id|email|firstName|lastName|avatar|
    |200			 |1	  |12   |1 |george.bluth@reqres.in|George|Bluth|https://reqres.in/img/faces/1-image.jpg|
    

  Scenario Outline: To validate the response code for single user when we hit the GET API for response
    Given I want to setup base url
    And I want to setup the endpoint url of GET Api for single user
    When I hit the api using GET method
    Then I should validate the status code is <statusCode>
    And I should validate the response Body fields "<id>","<email>","<firstName>","<lastName>","<avatar>"
    Examples:
    |statusCode|id|email|firstName|lastName|avatar|
    |200			 |2|janet.weaver@reqres.in|Janet|Weaver|https://reqres.in/img/faces/2-image.jpg|



  Scenario Outline: To validate the response code for single user not found when we hit the GET API for response
    Given I want to setup base url
    And I want to setup the endpoint url of GET Api for single user not found
    When I hit the api using GET method
    Then I should validate the status code is <statusCode>
   
    Examples:
    |statusCode|
    |404			 |