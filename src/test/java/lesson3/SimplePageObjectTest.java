package lesson3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import java.util.HashMap;

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

    @AfterMethod
    public void afterMethod() {
        driver.close();
    }

    @Test
    public void simpleSeleniumTest() {
        //1
        homePage.openHomePage(driver);

        //2
        homePage.checkHomePageTitle(driver);

        //3
        homePage.login("epam", "1234");

        //4
        homePage.checkUserIcon();
    }
}