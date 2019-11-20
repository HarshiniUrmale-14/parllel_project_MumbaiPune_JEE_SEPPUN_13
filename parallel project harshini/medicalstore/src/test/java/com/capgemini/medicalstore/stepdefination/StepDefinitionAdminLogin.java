package com.capgemini.medicalstore.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionAdminLogin {
	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

	}
	WebDriver driver;

	@Given("^admin loads the application on browser$")
	public void admin_loads_the_appliaction_on_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin clicks on the login button on navbar display login page$")
	public void the_admin_clicks_on_the_login_button_on_navbar_display_login_page() throws Throwable {
		driver.findElement(By.xpath("//a[text()='LOGIN']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters the emailid$")
	public void the_admin_enters_the_emailid() throws Throwable {
		driver.findElement(By.name("emailId")).sendKeys("harshini@gmail.com");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^the admin enters the password$")
	public void the_admin_enters_the_password() throws Throwable {
		driver.findElement(By.name("password")).sendKeys("abc123");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on login button admin page appears$")
	public void admin_clicks_on_login_button_admin_page_appears() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-login/div/form/div/div/div[3]/button")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on add product on navbar$")
	public void admin_clicks_on_add_product_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='ADD PRODUCT']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^the admin enters the product category$")
	public void the_admin_enters_the_product_category() throws Throwable {
		driver.findElement(By.name("productCategory")).sendKeys("eyecare");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^the admin enters the product name$")
	public void the_admin_enters_the_product_name() throws Throwable {
		driver.findElement(By.name("productName")).sendKeys("dropack");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@When("^the admin enters the product price$")
	public void the_admin_enters_the_product_price() throws Throwable {
		driver.findElement(By.name("productPrice")).sendKeys("76.8");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the admin enters the product quantity$")
	public void the_admin_enters_the_product_quantity() throws Throwable {
		driver.findElement(By.name("productQuantity")).sendKeys("90");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^the admin clicks on add button$")
	public void the_admin_clicks_on_add_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-addproduct/div/form/div/div/div[6]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on see product operation on navbar$")
	public void admin_clicks_on_see_product_operation_on_navbar() throws Throwable {
		driver.findElement(By.xpath("//a[text()='PRODUCTS']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^the see product component will have delete option the admin clicks on delete button$")
	public void the_see_product_component_will_have_delete_option_the_admin_clicks_on_delete_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-seeproduct/div/div/div[1]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^admin clicks on see product operation$")
	public void admin_clicks_on_see_product_operation() throws Throwable {
		driver.findElement(By.xpath("//a[text()='SEE PRODUCT']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the see product component will have update option the admin clicks on update button$")
	public void the_see_product_component_will_have_update_option_the_admin_clicks_on_update_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-seeproduct/div/div/div[1]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^then the update page pop up comes change the product filed needed to be updated$")
	public void then_the_update_page_pop_up_comes_change_the_product_filed_needed_to_be_updated() throws Throwable {
		driver.findElement(By.name("productQuantity")).sendKeys("56");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^click on submit button$")
	public void click_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-seeproduct/div/div/div[1]/div/div/div/div[2]/form/div[6]/button[1]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^close the pop up by clicking on cross$")
	public void close_the_pop_up_by_clicking_on_cross() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-seeproduct/div/div/div[1]/div/div/div/div[1]/div/button/span")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

@When("^admin clicks on see user component$")
public void admin_clicks_on_see_user_component() throws Throwable {
	driver.findElement(By.xpath("//a[text()='SEE USER']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Then("^the admin can see the user list and can delete the user from the list$")
public void the_admin_can_see_the_user_list_and_can_delete_the_user_from_the_list() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-seeuser/div/table/tbody/tr/td[6]/button")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@When("^admin clicks on see request component the message list appears$")
public void admin_clicks_on_see_request_component_the_message_list_appears() throws Throwable {
	driver.findElement(By.xpath("//a[text()='SEE REQUEST']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^the admin can see message  and send the reply by click on send$")
public void the_admin_can_see_message_and_send_the_reply_by_click_on_send() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-seerequest/button")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@When("^the pop up opens and the admin enters the user id and writes the message$")
public void the_pop_up_opens_and_the_admin_enters_the_user_id_and_writes_the_message() throws Throwable {
	driver.findElement(By.name("userId")).sendKeys("15");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.name("message")).sendKeys("hello world");
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@When("^then click on submit button$")
public void then_click_on_submit_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-seerequest/div[2]/div[1]/div/div[2]/form/div[3]/button[1]")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Then("^then close the pop up by clicking on cross button$")
public void then_close_the_pop_up_by_clicking_on_cross_button() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-seerequest/div[2]/div[1]/div/div[1]/div/button/span")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
@Then("^admin clicks on see order history the list of order list is displayed$")
public void admin_clicks_on_see_order_history_the_list_of_order_list_is_displayed() throws Throwable {
	driver.findElement(By.xpath("//a[text()='ORDER HISTORY']")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

@Then("^admin clicks on logout buuton the admin gets logout of the application$")
public void admin_clicks_on_logout_buuton_the_admin_gets_logout_of_the_application() throws Throwable {
	driver.findElement(By.xpath("/html/body/app-root/app-header/div/button")).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}

}
