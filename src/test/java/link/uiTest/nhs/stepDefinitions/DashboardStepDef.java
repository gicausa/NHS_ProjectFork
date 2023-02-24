package link.uiTest.nhs.stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import link.uiTest.nhs.pages.DashboardPage;
import link.uiTest.nhs.utils.DriverHelper;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;


public class DashboardStepDef {

    WebDriver driver = DriverHelper.getDriver();

    DashboardPage dashboardPage = new DashboardPage(driver);

    @Then("User validates the number of cards is {int}")
    public void user_validates_the_number_of_cards_is(Integer nrOfCards) {
        Assert.assertEquals(nrOfCards, dashboardPage.getNumberOfCards());
    }

    @Then("User validates the text on the cards")
    public void user_validates_the_text_on_the_cards(DataTable cardText) {
        Assert.assertEquals(cardText.asList(),dashboardPage.getTextFromCards());
    }

    @Then("User validates the color of the cards")
    public void user_validates_the_color_of_the_cards(DataTable cardColor) {
        Assert.assertEquals(cardColor.asList(),dashboardPage.getColorOfCards());
    }

    @Then("User validates the numbers on the cards")
    public void user_validates_the_numbers_on_the_cards() {
        dashboardPage.validateNumbers();
    }

    @Then("User validates the number of tables is {int}")
    public void user_validates_the_number_of_tables_is(Integer nrOfTables) {
        Assert.assertEquals(nrOfTables,dashboardPage.getNumberOfTables());
    }

    @Then("User validates the table headers")
    public void user_validates_the_table_headers(io.cucumber.datatable.DataTable tableHeader) {
        Assert.assertEquals(tableHeader.asList(),dashboardPage.getTextOfHeader());
    }

}
