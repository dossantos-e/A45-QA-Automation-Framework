import org.testng.annotations.Test;

public class Homework19 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail();
        enterPassword();
        clickSubmit();
        Thread.sleep(2000);
        verifySuccessfulLogin();
        selectPlaylistToDelete();
        deletePlaylistButton();
        verifyDeletedPlaylist();
    }




}
