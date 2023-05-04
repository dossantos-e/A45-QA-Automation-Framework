import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Homework17 extends BaseTest{

    @Test
    public void addSongToPlaylist() throws InterruptedException {
//        // Pre-condition
//        //      Added ChromeOptions argument below to fix websocket error
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--remote-allow-origins=*");
//
//        WebDriver driver = new ChromeDriver(options);
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//
//        //Steps
//        //Step 1
//        String url = "https://bbb.testpro.io/";
//        driver.get(url);
//        //Step 2
//        WebElement emailField = driver.findElement(By.cssSelector("input[type='email']"));
//        emailField.click();//not needed
//        emailField.clear();
//        emailField.sendKeys("demo@class.com");
//
//        WebElement passwordField = driver.findElement(By.cssSelector("input[type='password']"));
//        passwordField.click();//not needed
//        passwordField.clear();
//        passwordField.sendKeys("te$t$tudent");
//
//        WebElement submit = driver.findElement(By.cssSelector("button[type='submit']"));
//        submit.click();
//
//        WebElement avatarIcon = driver.findElement(By.cssSelector("img[class='avatar']"));
//        Assert.assertTrue(avatarIcon.isDisplayed());
//        line 14 - 36 will be replaced with the ff login code below:

        //lets try first if our login works, then we can proceed to implement the next steps
        provideEmail("eduardo.santos@testpro.io");
        providePassword("te$t$tudent");
        clickSubmit();
        //our next step would be to search a song, we can try a parameterized approach in searching a song
        searchSong("epic song");    //now our method to search a song will require a string, let's enter the song we want to search
        Thread.sleep(2000);//for checking if we are able to search, we can remove this later
        //looks good, now our next step is to click the View All Button
        clickViewAllBtn();
        Thread.sleep(2000);//for checking if we are able to click the view all, we can remove this later
        //looks good, now our next step is to choose the first song result
        clickFirstSongResult();
        Thread.sleep(2000);
        //lets add a pause to check if the first song is clicked
        //looks good, the xpath used was correct, but wont work with a different song
        //for our next step, we will click the add to button, naming readable methods will help us proceed on the steps on our tests
        //like clickAddToBtn, clickFirstSongResult etc.
        clickAddToBtn();
        Thread.sleep(2000);//lets add this to check if add to is clicked
        //looks good, next will be to choose a playlist to add it to
        choosePlaylistToAddTo();
        Thread.sleep(2000);
        //Last step would be to assert/verify song is added

        String expectedMessage = "Added 1 song into";
        Assert.assertTrue(getVerificationMessage().contains(expectedMessage));
        //this assertion verifies if the retrieved text from the notification pop up contains the sequence of characters in the expectedMessage string
        //it will return true if the words or characters exist

        //for another way to assert/verify, we can check if the notification pop up is present or displayed
        Assert.assertTrue(isNotificationPopUpDisplayed());
        // lets run it using the 2 assertions

    }

    public boolean isNotificationPopUpDisplayed() {//now we created a method that returns a boolean value of true or false
        WebElement notificationPopUpElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
//        return notificationPopUpElement.getText();
        //now we have an error, since getText() returns a string, but our method requires a boolean type/variable
        return notificationPopUpElement.isDisplayed();
        //now the error is gone, isDisplayed() method of selenium returns a boolean - true, if the element is present and displayed, false otherwise
    }

    //next we use webdriver wait for our next steps,
        //Step 3
        //now we create a method for each step
        public void searchSong(String songTitleKeyword) {
            WebElement searchField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[name='q']")));
//                driver.findElement(By.cssSelector("input[name='q']")); //without webdriver wait, we can remove this
            searchField.sendKeys(songTitleKeyword);
        }
        //Step 4
        public void clickViewAllBtn() {
            WebElement viewAllButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-test='view-all-songs-btn']")));
//                driver.findElement(By.cssSelector("button[data-test='view-all-songs-btn']")); //without webdriver wait, we can remove this
            viewAllButton.click();
        }
        //Step 5
        public void clickFirstSongResult() {
            WebElement epicSongButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//tr//td[contains(text(), 'Epic Song')]")));
                    // lets apply the wait driver.findElement(By.xpath("//tr//td[contains(text(), 'Epic Song')]"));// possible error in selector
            epicSongButton.click();
        }
        //Step 6
        public void clickAddToBtn() {
            WebElement addToButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@class='btn-add-to']")));
            addToButton.click();
        }
        //Step 7//for create and save playlist, we can remove these steps
//        WebElement createNewPlaylist = driver.findElement(By.xpath("//input[@data-test='new-playlist-name']"));// possible error in selector
//        createNewPlaylist.click();//not needed
//        createNewPlaylist.clear();
//        creteNewPlaylist.sendKeys("Homework17-Eduardo")
//        WebElement savePlaylist = driver.findElement(By.xpath("//button[@title='Save']"));
//        viewAllButton.click();

        //Step 7
        public void choosePlaylistToAddTo(){
            WebElement firstUserPlaylist = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#songResultsWrapper section.existing-playlists li:nth-child(5)")));
            firstUserPlaylist.click();
    }

        //Step 8
        public String getVerificationMessage() {
            WebElement verificationMessageAddedSong = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='success show']")));
            return verificationMessageAddedSong.getText();
            //getText() method of selenium returns/retrieves the text of an element in String format
        }

//        public void getVerificationMessage() {
//            WebElement verificationMessageAddedSong = driver.findElement(By.xpath("//div[@class='success show']"));
//            Assert.assertTrue(verificationMessageAddedSong.isDisplayed());
//        }

        // Post-condition
//        driver.quit(); we can remove this since @AfterMethod (helper methods) has been implemented

    }

