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
import pages.HomePage;
import pages.LoginPage;

import java.time.Duration;

public class Homework18 extends BaseTest{
@Test
public void playSong() throws InterruptedException {
      LoginPage loginPage = new LoginPage(driver);
      HomePage homePage = new HomePage(driver);

      loginPage.enterEmail();
      loginPage.enterPassword();
      loginPage.clickSubmit();
      Thread.sleep(2000);
      homePage.getUserAvatar();
      Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
      Thread.sleep(2000);
      homePage.clickNextSong();
      homePage.clickPlaySong();
      Thread.sleep(2000);
      homePage.verifySongIsPlaying();


    }


}
