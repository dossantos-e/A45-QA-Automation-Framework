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
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework18 extends BaseTest{
    @Test
public static void playSong() throws InterruptedException {
      openLoginUrl();
      enterEmail();
      enterPassword();
      clickSubmit();
      Thread.sleep(2000);
      verifySuccessfulLogin();
      clickPlaySong();
      clickNextSong();
      verifySongIsPlaying();


    }


}
