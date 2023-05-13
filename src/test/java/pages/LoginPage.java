package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {
    //since we cannot inherit constructors in Java, we will need to call the super()
    // (which refers to parent class)in our loginpage constructor
    public LoginPage(WebDriver givenDriver) {
        super(givenDriver);
    }
    private final By emailField = By.cssSelector("input[type='email']");
    private final By passwordField = By.cssSelector("input[type='password']");
    private final By submitBtn = By.cssSelector("button[type='submit']");

    public void enterEmail() {//we used the generic findElement() method from basepage which has explicit wait

        findElement(emailField).sendKeys("eduardo.santos@testpro.io");
    }
    public void enterPassword() {
        findElement(passwordField).clear();
        findElement(passwordField).sendKeys("te$t$tudent");
    }
    public void clickSubmit() {
        click(submitBtn);
    }

    public void loginPage(){
        enterEmail();
        enterPassword();
        clickSubmit();
    }

}
