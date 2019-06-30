package stepdefinition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import main.CucumberRunner;

public class Search extends CucumberRunner {
	By regNum_TXT = By.id("vehicleReg");
	By btnfind_BTN = By.name("btnfind");
	By verify_TXT = By.xpath("//button[@name='btnfind']//following::div[3]");
    String regNum = null;
	@Given("^I am on \"([^\"]*)\" page$")
	public void i_am_on_page(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.get(arg1);
	}

	@When("^I type \"([^\"]*)\" as registration number$")
	public void i_type_as_registration_number(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement regNum_textBox = wait.until(ExpectedConditions.visibilityOfElementLocated(regNum_TXT));
	    regNum_textBox.sendKeys(arg1);
	    regNum = arg1;
	    driver.findElement(btnfind_BTN).click();
	}

	@Then("^I see vehicle details$")
	public void i_see_vehicle_details() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		WebElement vehicle_Details = CucumberRunner.wait.until(ExpectedConditions.visibilityOfElementLocated(verify_TXT));
	    String confirmTxt = vehicle_Details.getText();
	    assertEquals(confirmTxt, "Result for : "+regNum);
	}

}
