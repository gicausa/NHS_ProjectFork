package link.uiTest.nhs.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import link.uiTest.nhs.pages.LoginPage;
import link.uiTest.nhs.utils.ConfigReader;
import link.uiTest.nhs.utils.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginStepDef {

    WebDriver driver = DriverHelper.getDriver();

    LoginPage loginPage = new LoginPage(driver);

    @Given("User navigates to NHS app site")
    public void user_navigates_to_nhs_app_site() {
        driver.navigate().to(ConfigReader.readProperty("QA_url"));

    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String userName, String password) {
        loginPage.signIn(userName,password);
    }
    @Then("User validates the page title is {string}")
    public void user_validates_the_page_title_is(String title) {
        Assert.assertEquals(title, driver.getTitle());
    }


}
