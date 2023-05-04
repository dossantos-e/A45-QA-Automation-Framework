import org.testng.annotations.Test;

public class Homework20 extends BaseTest {
    @Test
    public void deletePlaylist() throws InterruptedException {
        enterEmail();
        enterPassword();
        clickSubmit();
        verifySuccessfulLogin();
        selectPlaylistToDelete();
        deletePlaylistButton();
        verifyDeletedPlaylist();
    }




}
