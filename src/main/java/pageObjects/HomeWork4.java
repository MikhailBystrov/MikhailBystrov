package pageObjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Mikhail on Май, 2018
 */
public class HomeWork4 {

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement profilePhoto;

    @FindBy(css = ".dropdown")
    private WebElement serviceDropDown;

    @FindBy(css = "a[href = 'dates.html']")
    private WebElement refToDatesPage;

    @FindBy(css = "a[style^='left:']:first-child")
    private WebElement leftSlider;

    @FindBy(css = "a[style^='left:']:last-child")
    private WebElement rightSlider;

    @FindBy(css = ".info-panel-body-log > .info-panel-section")
    private WebElement logRows;

    public void open(WebDriver driver, String siteURL) {
        driver.navigate().to(siteURL);
    }

    public void checkHomePageTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserIsLoggined(String name) {
        assertEquals(profilePhoto.getText(), name);
    }

    public void openDatesPage() {
        serviceDropDown.click();
        refToDatesPage.click();
    }

    public void moveLeftSliderRange2(WebDriver driver, int position) {
        Actions actions = new Actions(driver);
        actions.click(leftSlider).build().perform();
        String stringAttribute = leftSlider.getAttribute("style").replaceAll("\\D+", "");
        int currentPosition = Integer.parseInt(stringAttribute);
        if (position < currentPosition) {
            for (int i = 0; i < currentPosition - position; i++) {
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        } else {
            for (int i = 0; i < position - currentPosition; i++) {
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }
    }

    public void moveRightSliderRange2(WebDriver driver, int position) {
        Actions actions = new Actions(driver);
        actions.click(rightSlider).build().perform();
        String stringAttribute = rightSlider.getAttribute("style").replaceAll("\\D+", "");
        int currentPosition = Integer.parseInt(stringAttribute);
        if (position < currentPosition) {
            for (int i = 0; i < currentPosition - position; i++) {
                actions.sendKeys(Keys.ARROW_LEFT).build().perform();
            }
        } else {
            for (int i = 0; i < position - currentPosition; i++) {
                actions.sendKeys(Keys.ARROW_RIGHT).build().perform();
            }
        }

    }

    public void checkLogRowsForSliders(String haveToContains) {
        assertTrue(logRows.getText().contains(haveToContains));
    }
}
