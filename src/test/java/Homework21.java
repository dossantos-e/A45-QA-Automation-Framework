import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class Homework21 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail();
        enterPassword();
        clickSubmit();
        verifySuccessfulLogin();
        contextClickPlaylistToRename();
        editPlaylistName();
        enterNewPlaylistName();
    }

    public void enterNewPlaylistName() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        WebElement enterNewPlaylistName = driver.findElement(By.xpath("//input[@data-testid='inline-playlist-name-input']"));
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.COMMAND,"a"));
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.DELETE));
        enterNewPlaylistName.sendKeys("New Playlist Name HM21");
        enterNewPlaylistName.sendKeys(Keys.chord(Keys.RETURN));

    }

    public void editPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@data-testid, 'edit')]")));
        WebElement clickEditPlaylistName = driver.findElement(By.xpath("//li[contains(@data-testid, 'edit')]"));
        clickEditPlaylistName.click();
    }

    public void  contextClickPlaylistToRename() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='#!/playlist/56146']")));
        WebElement clickPlaylistToRename = driver.findElement(By.xpath("//a[@href='#!/playlist/56146']"));
        actions.contextClick(clickPlaylistToRename).perform();

    }
}
