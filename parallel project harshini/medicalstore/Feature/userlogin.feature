Feature: Testing the user login and user operations


Background:
Given user loads the application on browser 
And the user clicks on login button on navbar displayed on the navbar
And the user enters the email id 
And the user enters the password
And the user clicks on login button user page appears

@AddToCartOperation
Scenario: checking the see product and add to cart 

And user clicks on see product component on navbar 
And product list appears and if user  can click on add to cart
And pop up opeans and enter the the  no of quantity of products to be added
And click on the  submit button option to submit
Then close the pop up by clicking on cross button

@CartOperation
Scenario: see the product list in cart delete from cart and place order

And user clicks on view cart component the cart list of user appears 
And user can delete the products from the cart by clicking on delete button
Then user can place the order by clicking on place order button


@UpdateProfileOperation
Scenario: update the user profile

And user clicks on update profile component on navbar 
And  user can update the profile
Then click on  the submit button option

@SendMessageOperation
Scenario: user sends the message or query to the admin and see message from admin

And user clicks on send request component on navbar 
And user can write the message 
And user clicks on send button
And user can see the reply from admin by clicking on reply button
Then user have to close the pop up by clicking on cross

@ViewOrderConfirmedOperation
Scenario: user can view the confirmed order and history of order user has done

Then user clicks on placed order component on navbar the order list appears

@UserLogoutOperation
Scenario: user logout 

Then user clicks on logout button the usser gets out of the application


