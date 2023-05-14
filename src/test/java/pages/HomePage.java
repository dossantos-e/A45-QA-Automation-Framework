package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }

    private final By playlistToRename = By.xpath("//a[@href='#!/playlist/56146']");
    private final By avatarIcon = By.cssSelector("img[class='avatar']");
    private final By clickNextSong = By.xpath("//i[@data-testid='play-next-btn']");
    private final By clickPlaySong = By.xpath("//span[@data-testid='play-btn']");
    private final By editPlaylistName = By.xpath("//li[contains(@data-testid, 'edit')]");
    private final By enterNewPlaylistName = By.cssSelector(".playlist:nth-child(4)");
    private final By verifyNewPlaylistName = By.cssSelector(".playlist:nth-child(4)");
    private final By playlistToDelete = By.xpath("//a[@href='#!/playlist/55993']");
    private final By deletePlaylistButton = By.xpath("//button[@class='del btn-delete-playlist']");
    private final By verifyDeletedPlaylist = By.xpath("//div[@class='success show']");



    //let's refactor the method to context/right click the playlist
    //lets initialize actions class in BasePage first, and create the helper method for it,

    //next let's refector this, first we create a By declaration for the web elements

    //this is the moved method from previous homework


    //refactored methods
    public void contextClickPlaylistToRename() {
        contextClick(playlistToRename);
    }

    public WebElement getUserAvatar() {
        return findElement(avatarIcon);
    }

    public void verifySongIsPlaying() {
        WebElement verifySongIsPlaying = driver.findElement(By.xpath("//div[@data-testid='sound-bar-play']"));
        verifySongIsPlaying.isDisplayed();
    }
    public void verifyNewPlaylistName() {
        WebElement newPlaylistName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".playlist:nth-child(4)")));
        org.testng.Assert.assertTrue(newPlaylistName.getText().contains("New Playlist Name HM21"));
    }

    public void enterNewPlaylistName(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement enterNewPlaylistName = driver.findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.DELETE));
        enterNewPlaylistName.sendKeys("New Playlist Name HM21");
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.RETURN));
    }

    public void editPlaylistName() {
        click(editPlaylistName);
    }

    public void clickNextSong() {
        click(clickNextSong);
    }

    public void clickPlaySong() {
        click(clickPlaySong);
    }
    public void playlistToDelete() {
        click(playlistToDelete);
    }

        public void deletePlaylistButton() {
            click(deletePlaylistButton);
        }
    public WebElement verifyDeletedPlaylist() {
        return findElement(verifyDeletedPlaylist);
    }
    }