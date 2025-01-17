package link.uiTest.nhs.pages;

import link.uiTest.nhs.utils.BrowserUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    public DashboardPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }



    @FindBy(css = ".panel-heading")
    List<WebElement> cards;

    @FindBy(css = ".panel-heading div.huge+div")
    List<WebElement> cardText;

    @FindBy(css = ".panel-heading div.huge")
    List<WebElement> cardNumber;

    @FindBy(css = ".dataTables_scroll")
    List<WebElement> tables;

    @FindBy(css = "#patients-in-hospital_wrapper thead th")
    List<WebElement> headerText;

    @FindBy(partialLinkText = "Add patient")
    WebElement addPatientLink;

    @FindBy(xpath = "//table[@id='patients-waiting']//tr/td[2]")
    List<WebElement> patientsWaiting;


    public Integer getNumberOfCards(){
        return cards.size();
    }

    public List<String> getTextFromCards(){
        List<String> allCardText = new ArrayList<>();

        for(WebElement text : cardText){
            allCardText.add(BrowserUtils.getText(text));
        }
        return allCardText;
    }

    public List<String> getColorOfCards(){
        List<String> allCardColor = new ArrayList<>();

        for(WebElement card : cards){
            allCardColor.add(card.getCssValue("background-color"));
        }

        return allCardColor;
    }

    public void validateNumbers(){
        List<Integer> numbers = new ArrayList<>();

        for(WebElement number : cardNumber){
            numbers.add(Integer.parseInt(BrowserUtils.getText(number)));
        }
        for(Integer number : numbers){
            Assert.assertTrue(number >= 0);
        }
    }

    public Integer getNumberOfTables(){
        return tables.size();
    }

    public List<String> getTextOfHeader(){
        List<String> allHeaderText = new ArrayList<>();

        for(int i=0; i<4; i++){
            Assert.assertTrue(headerText.get(i).isDisplayed());
            allHeaderText.add(BrowserUtils.getText(headerText.get(i)));
        }
        return allHeaderText;
    }

    public void clickAddPatient(){
        addPatientLink.click();
    }

    public List<String> getAllWaitingPatients(){
        List<String> waitingPatients = new ArrayList<>();
        for(WebElement patient : patientsWaiting){
            waitingPatients.add(BrowserUtils.getText(patient));
        }
        return waitingPatients;
    }
}
