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
import org.testng.annotations.Parameters;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver = null;
    public static String url = "";

    @BeforeSuite
    static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    @Parameters({"BaseURL"})
    public void launchBrowser(String BaseURL) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        url = BaseURL;
        openLoginUrl();
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
    public void selectPlaylistToDelete() {
        WebElement clickPlaySong = driver.findElement(By.xpath("//a[@href='#!/playlist/55684']"));
        clickPlaySong.click();
    }
    public void deletePlaylistButton() {
        WebElement clickPlaySong = driver.findElement(By.xpath("//button[@class='del btn-delete-playlist']"));
        clickPlaySong.click();
    }
    public void verifyDeletedPlaylist() {
        WebElement deleteIcon = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(deleteIcon.isDisplayed());
    }
}