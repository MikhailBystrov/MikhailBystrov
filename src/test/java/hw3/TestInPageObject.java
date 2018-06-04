package hw3;

import homework.pageObjects.HomePageSelenium;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static homework.enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail
 */

public class TestInPageObject {

    private WebDriver driver;
    private HomePageSelenium homePageSelenium;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homePageSelenium = PageFactory.initElements(driver, HomePageSelenium.class);
    }

    @AfterMethod
    public void close() {
        driver.close();
    }

    @Test
    public void testHomePage() {
        //1. Open test site by URL
        homePageSelenium.openHomePage(driver);

        //2. Assert browser title
        homePageSelenium.checkHomePageTitle(driver);

        //3. Perform login.
        homePageSelenium.login(PITER_CHAILOVSKII);

        //4. Assert User name in the left-top side of screen that user is loggined
        homePageSelenium.checkUserIcon(PITER_CHAILOVSKII);

        //5. Assert browser title
        homePageSelenium.checkHomePageTitle(driver);

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homePageSelenium.checkHeaderSection();

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homePageSelenium.checkImagesOnIndexPage();

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homePageSelenium.checkTextOnIndexPage();

        //9. Assert a text of the main content
        homePageSelenium.checkTextOfMainContent();

        //10. Assert a text of the sub header
        homePageSelenium.checkTextOfSubHeader();

        //11. Assert that JDI GITHUB is a link and has a proper URL
        homePageSelenium.checkSubHeaderIsALink();

        //12. Assert that there is Left Section
        homePageSelenium.checkThereIsLeftSection();

        //13. Assert that there is Footer
        homePageSelenium.checkThereIsFooter();
    }
}
