import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "https://bbb.testpro.io/";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void launchBrowser() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @AfterMethod
    public void quiteBrowser() {
        driver.quit();
    }


    public boolean verifySongIsPlaying() {
        WebElement verifySongIsPlaying = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        return verifySongIsPlaying.isDisplayed();

    }


    public static void clickNextSong() {
        WebElement clickNextSong = driver.findElement(By.xpath("//i[@data-testid='play-next-btn']"));
        clickNextSong.click();
    }

    // These are the helpers for successful login
    public static void verifySuccessfulLogin() {
        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
    }

    public static void clickSubmit() {
        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();
    }

    public static void enterPassword() {
        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");
    }

    public static void enterEmail() {
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.clear();
        emailField.sendKeys("eduardo.santos@testpro.io");
    }

    public static void openLoginUrl() {
        driver.get(url);
    }
    public static void clickPlaySong() {
        WebElement clickPlaySong = driver.findElement(By.xpath("//span[@data-testid='play-btn']"));
        clickPlaySong.click();

    }


}