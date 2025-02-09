import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework16 extends BaseTest{
    @Test
    public void registrationNavigation(){
        // Pre-condition
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //Steps
        WebElement registrationButton = driver.findElement(By.cssSelector("a#hel"));
        registrationButton.click();

        WebElement registerNewAccount = driver.findElement(By.cssSelector("div h2"));

        // Expected Result
        Assert.assertTrue(registerNewAccount.isDisplayed());
        //Assert.assertEquals(registerNewAccount.isDisplayed(), true);

        // Post-condition
        driver.quit();


    }
}