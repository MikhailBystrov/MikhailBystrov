package hw4;

import base.TestBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HomeWork4;

import static enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail on Май, 2018
 */
public class TestDatesPageElements extends TestBase {

    private WebDriver driver;
    private HomeWork4 homeWork4;

    @BeforeClass
    public void beforeClass() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        homeWork4 = PageFactory.initElements(driver, HomeWork4.class);
    }

    @AfterClass
    public void close() {
        driver.close();
    }

    @Test
    public void testRange2AndLogsRows() {
        //1. Open test site
        homeWork4.open(driver, "https://epam.github.io/JDI/index.html");

        //2. Assert browser title
        homeWork4.checkHomePageTitle(driver, "Home Page");

        //3. Perform login.
        homeWork4.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the right-top side of screen that user is loggined
        homeWork4.checkUserIsLoggined(PITER_CHAILOVSKII.name);

        //5. Open through the header menu Service -> Dates Page
        homeWork4.openDatesPage();

        //6. Set Range sliders. left sliders - the most left position, right slider - the most right position
        homeWork4.moveLeftSliderRange2(driver, 0);
        homeWork4.moveRightSliderRange2(driver, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homeWork4.checkLogRowsForSliders("To");
        homeWork4.checkLogRowsForSliders("From");

        //8. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        homeWork4.moveLeftSliderRange2(driver, 0);
        homeWork4.moveRightSliderRange2(driver, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homeWork4.checkLogRowsForSliders("To");
        homeWork4.checkLogRowsForSliders("From");

        //10. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        homeWork4.moveRightSliderRange2(driver, 100);
        homeWork4.moveLeftSliderRange2(driver, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homeWork4.checkLogRowsForSliders("To");
        homeWork4.checkLogRowsForSliders("From");

        //12. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        homeWork4.moveLeftSliderRange2(driver, 30);
        homeWork4.moveRightSliderRange2(driver, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        homeWork4.checkLogRowsForSliders("To");
        homeWork4.checkLogRowsForSliders("From");
    }
}
