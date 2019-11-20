package com.capgemini.medicalstore.stepdefination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitionVisitors {
	static {
		System.setProperty("webdriver.chrome.driver", "./Driver/chromedriver.exe");

	}
	WebDriver driver;

	@Given("^visitor loads the application on the browser$")
	public void visitor_loads_the_application_on_the_browser() throws Throwable {
		driver = new ChromeDriver();
		driver.get("http://localhost:4200/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the visitor can see the product only by click on products$")
	public void the_visitor_can_see_the_product_only_by_click_on_products() throws Throwable {
		driver.findElement(By.xpath("//a[text()='PRODUCT']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^the visitor can register for further operations by clicking  on register$")
	public void the_visitor_can_register_for_further_operations_by_clicking_on_register() throws Throwable {
		driver.findElement(By.xpath("//a[text()='REGISTRATION']")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^visitor  enter the  all the credentials$")
	public void visitor_enter_the_all_the_credentials() throws Throwable {
		driver.findElement(By.name("name")).sendKeys("sdfghfg");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("mobileNo")).sendKeys("1234567890");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("address")).sendKeys("wertyuio");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("emailId")).sendKeys("dftgyhuj@rdftghj");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.name("password")).sendKeys("6yr5ghgas");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Then("^visitor clicks on submit  button$")
	public void visitor_clicks_on_submit_button() throws Throwable {
		driver.findElement(By.xpath("/html/body/app-root/app-registration/div/form/div/div/div[7]/button[2]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
}
