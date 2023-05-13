import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.enterEmail();
        loginPage.enterPassword();
        loginPage.clickSubmit();
        homePage.getUserAvatar();
        Assert.assertTrue(homePage.getUserAvatar().isDisplayed());
        homePage.playlistToDelete();
        homePage.deletePlaylistButton();
        homePage.verifyDeletedPlaylist();
        Assert.assertTrue(homePage.verifyDeletedPlaylist().isDisplayed());
    }
}
