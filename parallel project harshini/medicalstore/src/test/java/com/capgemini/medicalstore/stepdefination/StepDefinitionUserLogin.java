package com.capgemini.medicalstore.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionUserLogin {
	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

	}
	WebDriver driver;

	@Given("^user loads the application on browser$")
	public void user_loads_the_application_on_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^the user clicks on login button on navbar displayed on the navbar$")
	public void the_user_clicks_on_login_button_on_navbar_displayed_on_the_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^the user enters the email id$")
	public void the_user_enters_the_email_id() throws Throwable {
		driver.findElement(By.name("emailId")).sendKeys("manish@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Given("^the user enters the password$")
	public void the_user_enters_the_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("xyz123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Given("^the user clicks on login button user page appears$")
	public void the_user_clicks_on_login_button_user_page_appears() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^user clicks on see product component on navbar$")
	public void user_clicks_on_see_product_component_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='VIEW PRODUCT']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^product list appears and if user  can click on add to cart$")
	public void product_list_appears_and_if_user_can_click_on_add_to_cart() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-userproduct/div/div/div[1]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^pop up opeans and enter the the  no of quantity of products to be added$")
	public void pop_up_opeans_and_enter_the_the_no_of_quantity_of_products_to_be_added() throws Throwable {
		driver.findElement(By.name("quantity")).sendKeys("4");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on the  submit button option to submit$")
	public void click_on_the_submit_button_option_to_submit() throws Throwable {
		driver.findElement(
				By.xpath("/html/body/app-root/app-userproduct/div/div/div[1]/div/div/div/div[2]/form/div[3]/button[1]"))
				.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^close the pop up by clicking on cross button$")
	public void close_the_pop_up_by_clicking_on_cross_button() throws Throwable {
		driver.findElement(
				By.xpath("/html/body/app-root/app-userproduct/div/div/div[1]/div/div/div/div[1]/button/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^user clicks on view cart component the cart list of user appears$")
	public void user_clicks_on_view_cart_component_the_cart_list_of_user_appears() throws Throwable {
		driver.findElement(By.xpath("//a[text()='VIEW CART']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user can delete the products from the cart by clicking on delete button$")
	public void user_can_delete_the_products_from_the_cart_by_clicking_on_delete_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-viewcart/div[1]/table/tbody/tr[1]/td[8]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^user can place the order by clicking on place order button$")
	public void user_can_place_the_order_by_clicking_on_place_order_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-viewcart/div[2]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}


	@When("^user clicks on update profile component on navbar$")
	public void user_clicks_on_update_profile_component_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='UPDATE PROFILE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user can update the profile$")
	public void user_can_update_the_profile() throws Throwable {
		driver.findElement(By.name("address")).sendKeys("narendra nagar");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^click on  the submit button option$")
	public void click_on_the_submit_button_option() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-updateuser/div/form/div/div[7]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@When("^user clicks on logout button the usser gets out of the application$")
	public void user_clicks_on_logout_button_the_usser_gets_out_of_the_application() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-header/div/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	

	@When("^user clicks on send request component on navbar$")
	public void user_clicks_on_send_request_component_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='SEND MESSAGE']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user can write the message$")
	public void user_can_write_the_message() throws Throwable {
		driver.findElement(By.name("message")).sendKeys("how much time to delivery the order");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^user clicks on send button$")
	public void user_clicks_on_send_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-sendrequest/div/form/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^user can see the reply from admin by clicking on reply button$")
	public void user_can_see_the_reply_from_admin_by_clicking_on_reply_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-sendrequest/div/form/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^user have to close the pop up by clicking on cross$")
	public void user_have_to_close_the_pop_up_by_clicking_on_cross() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-sendrequest/div/form/div[2]/div/div/div[1]/button/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^user clicks on placed order component on navbar the order list appears$")
	public void user_clicks_on_placed_order_component_on_navbar_the_order_list_appears() throws Throwable {
		driver.findElement(By.xpath("//a[text()='PLACED ORDER']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

}
