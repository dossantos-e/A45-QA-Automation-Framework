package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends BasePage {
    public HomePage(WebDriver givenDriver) {
        super(givenDriver);
    }
     By playlistToRename = By.xpath("//a[@href='#!/playlist/56146']");

    //let's refactor the method to context/right click the playlist
    //lets initialize actions class in BasePage first, and create the helper method for it,

    //next let's refector this, first we create a By declaration for the web elements

    //this is the moved method from previous homework
    public void  contextClickPlaylistToRenameOld() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@href='#!/playlist/56146']")));
        WebElement clickPlaylistToRename = driver.findElement(By.xpath("//a[@href='#!/playlist/56146']"));
        actions.contextClick(clickPlaylistToRename).perform();
    }
    //refactored method
    public void contextClickPlaylistToRename(){
        contextClick(playlistToRename);
    }


}
