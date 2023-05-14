import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v104.console.model.ConsoleMessage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework21 extends BaseTest {
    @Test
    public void renamePlaylist() {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickSubmit();
        homePage.getUserAvatar();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.contextClickPlaylistToRename();
        homePage.editPlaylistName();
        homePage.enterNewPlaylistName();
        homePage.verifyNewPlaylistName();
    }


}
