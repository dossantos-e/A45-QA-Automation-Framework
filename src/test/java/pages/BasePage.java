package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

//lets start with basepage, this will contain our common methods/steps that
    // our page objects will inherit/extend to

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected Actions actions;

    //we create a constructor to pass the instance of the objects (driver, webdriverwait)
    public BasePage(WebDriver givenDriver) {
        driver = givenDriver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        actions = new Actions(driver);
    }

    //helper methods which we can reuse in our page objects
    public WebElement findElement (By locator){//helper method to find element with explicit wait
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void click(By locator) { //helper method to click element using findElement() with explicit wait
        findElement(locator).click();
    }
    public void doubleClick(By locator){// helper method for double click using findElement()
    actions.doubleClick(findElement(locator)).perform();
    }
    public void contextClick(By locator){// helper method for double click
        actions.contextClick(findElement(locator)).perform();
    }

}
