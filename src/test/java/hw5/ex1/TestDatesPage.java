package hw5.ex1;

import homework.hw5.base.HomeWork5Base;
import homework.hw5.pageObjects.DatesPage;
import homework.hw5.pageObjects.HomePageSelenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homework.hw5.enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail on 04.06.2018
 */

@Feature("Date Page test")
@Story("Checking operations of the slider on this page")
public class TestDatesPage extends HomeWork5Base {

    private DatesPage datesPage;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        datesPage = page(DatesPage.class);
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test
    public void testDatesSliderAndLogRows() {
        //1. Open test site
        open("https://epam.github.io/JDI/index.html");

        //2. Assert browser title
        homePageSelenide.checkHomePageTitle("Home Page");

        //3. Perform login.
        homePageSelenide.login(PITER_CHAILOVSKII);

        //4. Assert User name in the right-top side of screen that user is loggined
        homePageSelenide.checkUserIsLoggined(PITER_CHAILOVSKII);

        //5. Open through the header menu Service -> Dates Page
        homePageSelenide.openDatesPage();

        //6. Set Range sliders. left sliders - the most left position, right slider - the most right position
        datesPage.moveSlidersRange2(0, 100);

        //7. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):100");
        datesPage.checkLogRowsForSliders("(From):0");

        //8. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveSlidersRange2(0, 0);

        //9. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):0");
        datesPage.checkLogRowsForSliders("(From):0");

        //10. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveSlidersRange2(100, 100);

        //11. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(To):100");
        datesPage.checkLogRowsForSliders("(From):100");

        //12. Set Range sliders. left sliders - the most left position, right slider - the most left position.
        datesPage.moveSlidersRange2(30, 70);

        //13. Assert that for "From" and "To" sliders there are logs rows with corresponding values
        datesPage.checkLogRowsForSliders("(From):30");
        datesPage.checkLogRowsForSliders("(To):70");
    }
}