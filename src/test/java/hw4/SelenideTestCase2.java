package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HW4TestCase2Dates;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail
 */
public class SelenideTestCase2 {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser ="chrome";
        Configuration.screenshots = false;
    }

    @Test
    public void testRange2AndLogsRows() {
        HW4TestCase2Dates hw4TestCase2Dates = page(HW4TestCase2Dates.class);
        //1. Open test site
        open("https://epam.github.io/JDI/index.html");

        //2. Assert browser title
        hw4TestCase2Dates.checkHomePageTitle("Home Page");

        //3. Perform login.
        hw4TestCase2Dates.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the right-top side of screen that user is loggined
        hw4TestCase2Dates.checkUserIsLoggined(PITER_CHAILOVSKII.name);

        //5. Open through the header menu Service -> Dates Page
        hw4TestCase2Dates.openDatesPage();

        //6. Set Range sliders. left sliders - the most left position, right slider - the most right position
        hw4TestCase2Dates.moveLeftSliderRange2(0);
        hw4TestCase2Dates.moveRightSliderRange2(100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        hw4TestCase2Dates.checkLogRowsForSliders("(To):100");
        hw4TestCase2Dates.checkLogRowsForSliders("(From):0");

        //8. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        hw4TestCase2Dates.moveLeftSliderRange2(0);
        hw4TestCase2Dates.moveRightSliderRange2(0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        hw4TestCase2Dates.checkLogRowsForSliders("(To):0");
        hw4TestCase2Dates.checkLogRowsForSliders("(From):0");

        //10. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        hw4TestCase2Dates.moveRightSliderRange2(100);
        hw4TestCase2Dates.moveLeftSliderRange2(100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        hw4TestCase2Dates.checkLogRowsForSliders("(To):100");
        hw4TestCase2Dates.checkLogRowsForSliders("(From):100");

        //12. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        hw4TestCase2Dates.moveLeftSliderRange2(30);
        hw4TestCase2Dates.moveRightSliderRange2(70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        hw4TestCase2Dates.checkLogRowsForSliders("(From):30");
        hw4TestCase2Dates.checkLogRowsForSliders("(To):70");
    }
}