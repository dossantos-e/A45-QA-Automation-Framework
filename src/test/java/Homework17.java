import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist(){
        // Pre-condition
        //      Added ChromeOptions argument below to fix websocket error
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");

        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        //Steps
        //Step 1
        String url = "https://bbb.testpro.io/";
        driver.get(url);
        //Step 2
        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
        emailField.click();//not needed
        emailField.clear();
        emailField.sendKeys("demo@class.com");

        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
        passwordField.click();//not needed
        passwordField.clear();
        passwordField.sendKeys("te$t$tudent");

        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
        submit.click();

        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
        Assert.assertTrue(avatarIcon.isDisplayed());
        //Step 3
        WebElement searchField = driver.findElement(By.cssSelector("input[name='q']"));
        searchField.click();//not needed
        searchField.clear();
        searchField.sendKeys("epic song");
        //Step 4
        WebElement viewAllButton = driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']"));
        viewAllButton.click();

        //Step 5
        WebElement epicSongButton = driver.findElement(By.xpath("//tr//td[contains(text(), 'Epic Song')]"));// possible error in selector
        viewAllButton.click();

        //Step 6
        WebElement addToButton = driver.findElement(By.xpath("//button[@class='btn-add-to']"));
        viewAllButton.click();

        //Step 7
        WebElement createNewPlaylist = driver.findElement(By.xpath("//input[@data-test='new-playlist-name']"));// possible error in selector
        createNewPlaylist.click();//not needed
        createNewPlaylist.clear();
        createNewPlaylist.sendKeys("Homework17-Eduardo");

        WebElement savePlaylist = driver.findElement(By.xpath("//button[@title='Save']"));
        viewAllButton.click();

        //Step 8
        WebElement verificationMessageCreatedPlaylist = driver.findElement(By.xpath("//div[@class='success show']"));
        Assert.assertTrue(verificationMessageCreatedPlaylist.isDisplayed());

        // Post-condition
        driver.quit();
        



    }
}
