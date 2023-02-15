package link.uiTest.nhs.pages;

import groovy.transform.Final;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
    }

    @FindBy(id = "inputEmail")
    WebElement userNameBox;

    @FindBy(id = "inputPassword")
    WebElement passwordBox;

    @FindBy(xpath = "//button[.='Sign in']")
    WebElement sigInButton;

    public void signIn(String userName,String password){
        this.userNameBox.sendKeys(userName);
        this.passwordBox.sendKeys(password);
        sigInButton.click();
    }




}
