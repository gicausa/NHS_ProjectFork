package link.uiTest.nhs.utils;

import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Set;

public class BrowserUtils {

    public static void selectBy(WebElement location, String value, String methodName){
        Select select = new Select(location);
        switch (methodName){
            case "text":
                select.selectByVisibleText(value);
                break;
            case "value":
                select.selectByValue(value);
                break;
            case "index":
                select.selectByIndex(Integer.parseInt(value));
                break;
            default:
                System.out.println("Method name is not available. Use text, value, or index.");
        }
    }



    public static String getText(WebElement element){
        return element.getText().trim();
    }


    public static String getTitleWithJS(WebDriver driver){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js.executeScript("return document.title").toString();

    }

    public static void clickWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click()", element);
    }



    public static void scrollWithJS(WebDriver driver, WebElement element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true)", element);
    }




    public static void scrollWithPoint(WebDriver driver, WebElement element){

        JavascriptExecutor js = (JavascriptExecutor) driver;
        Point point = element.getLocation();
        int xCoordinate = point.getX();
        int yCoordinate = point.getY();
        js.executeScript("window.scrollTo("+xCoordinate+","+yCoordinate+")");

    }



    public static void switchByID(WebDriver driver, String mainId){

        Set<String> allPageIds = driver.getWindowHandles();
        for(String id : allPageIds){
            if(!id.equals(mainId)){
                driver.switchTo().window(id);
            }
        }
    }



    public static void switchByTitle(WebDriver driver, String title){

        Set<String> allPageIds = driver.getWindowHandles();
        for (String id : allPageIds){
            driver.switchTo().window(id);
            if(driver.getTitle().contains(title)){
                break;
            }
        }
    }


    public static void getScreenShotCucumber(Scenario scenario, WebDriver driver){
        Date currentDate = new Date();
        String screenShotFileName = currentDate.toString().replace(" ","-")
                .replace(":","-");
        if(scenario.isFailed()){
            File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            try {
                FileUtils.copyFile(screenShotFile,new File("src/test/java/screenshots/"+screenShotFileName+".png"));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
