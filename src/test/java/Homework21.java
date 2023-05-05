import org.openqa.selenium.By;
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
        Thread.sleep(2000);
        editPlaylistName();





    }

    public void editPlaylistName() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//li[contains(@data-testid, 'edit')]")));
        WebElement clickEditPlaylistName = driver.findElement(By.xpath("//li[contains(@data-testid, 'edit')]"));
        clickEditPlaylistName.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@data-testid='inline-playlist-name-input']")));
        clickEditPlaylistName.sendKeys("Renamed Playlist HW21");

    }

    public void  contextClickPlaylistToRename() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='#!/playlist/56146']")));
        WebElement clickPlaylistToRename = driver.findElement(By.xpath("//a[@href='#!/playlist/56146']"));
        actions.contextClick(clickPlaylistToRename).perform();

    }
}
