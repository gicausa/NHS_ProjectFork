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














}
