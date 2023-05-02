import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        launchBrowser();
        enterEmail();
        enterPassword();
        clickSubmit();
        Thread.sleep(2000);
        verifySuccessfulLogin();
    }

}
