package lesson3;

import base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SimplePageObjectTest extends TestBase {

    private ChromeOptions options;
    private WebDriver driver;

    private HomePage homePage;

    @BeforeClass
    public void beforeClass() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "target");

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void simpleSeleniumTest() {
        //1
        homePage.open(driver);

        //2
        homePage.checkHomePageTitle(driver);

        //1 Login as user
        homePage.login("epam", "1234");

        //2 Assert ...
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        assertTrue(userName.isDisplayed());
        assertEquals(userName.getText(), "PITER CHAILOVSKII");

        driver.close();
    }
}