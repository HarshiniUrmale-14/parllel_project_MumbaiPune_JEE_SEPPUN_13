Feature: Testing the visitor registration 


@RegistrationOperation
Scenario: checking the registration operation for visitor 

Given visitor loads the application on the browser
When the visitor can see the product only by click on products
And the visitor can register for further operations by clicking  on register
And visitor  enter the  all the credentials
Then visitor clicks on submit  button 
