package hw3;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomeWork3;

/**
 * Created by Mikhail on Май, 2018
 */
public class Exercise extends TestBase {

    private WebDriver driver;
    private HomeWork3 homeWork3;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homeWork3 = PageFactory.initElements(driver, HomeWork3.class);
    }

    @AfterClass
    public void close() {
        driver.close();
    }

    @Test
    public void testEPAMGithubIoSite() {
        homeWork3.open(driver, "https://epam.github.io/JDI/index.html");

        //2. Assert test site is open
        homeWork3.checkSiteOpen(driver, "https://epam.github.io/JDI/index.html");

        //3. Assert browser title
        homeWork3.checkHomePageTitle(driver, "Home Page");

        //4. Perform login. Assert User name in the left-top side of screen that user is loggined
        homeWork3.login("epam", "1234");

        //5. Assert browser title
        homeWork3.checkHomePageTitle(driver, "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        homeWork3.checkHeaderSection(driver, 4);

        //7. Assert that there are 4 images on the Index Page and they are displayed
        homeWork3.checkImagesOnIndexPage(driver, 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        homeWork3.checkTextOnIndexPage(driver, 4);

        //9. Assert a text of the main content
        homeWork3.checkTextOfMainContent(driver);

        //10. Assert a text of the sub header
        homeWork3.checkTextOfSubHeader(driver, "JDI GITHUB");

        //11. Assert that JDI GITHUB is a link and has a proper URL
        homeWork3.checkJDIGITHUBIsALink(driver, "https://github.com/epam/JDI");

        //12. Assert that there is Left Section
        homeWork3.checkThereIsLeftSection(driver);

        //13. Assert that there is Footer
        homeWork3.checkThereIsFooter(driver);
    }
}
