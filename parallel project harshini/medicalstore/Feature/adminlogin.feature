Feature: Testing the admin login and  admin operations

Background:
Given admin loads the application on browser
When the admin clicks on the login button on navbar display login page
And the admin enters the emailid
And the admin enters the password
And admin clicks on login button admin page appears

@AddProductOperation
Scenario: checking the add product operation

And admin clicks on add product on navbar
And the admin enters the product category
And the admin enters the product name
And the admin enters the product price 
And the admin enters the product quantity
Then the admin clicks on add button


@DeleteProductOperation
Scenario: checking the delete product operation

And admin clicks on see product operation on navbar
Then the see product component will have delete option the admin clicks on delete button


@UpdateProductOperation
Scenario: checking the update product operation

And admin clicks on see product operation 
And the see product component will have update option the admin clicks on update button
And then the update page pop up comes change the product filed needed to be updated
And click on submit button 
Then close the pop up by clicking on cross

@SeeUserAndDeleteOperation
Scenario: see the user list and if admin want to  can delete the user

And admin clicks on see user component
Then the admin can see the user list and can delete the user from the list


@SeeRequestAndSendOperation
Scenario: see the messages from user and send the reply to particular user

And admin clicks on see request component the message list appears
And the admin can see message  and send the reply by click on send  
And the pop up opens and the admin enters the user id and writes the message 
And then click on submit button
Then then close the pop up by clicking on cross button


@SeeOrderHistoryOperation
Scenario: see order history of the products and which user has bought those products

Then admin clicks on see order history the list of order list is displayed


@LogoutAdminOperation
Scenario: admin logout operation

Then admin clicks on logout buuton the admin gets logout of the application


