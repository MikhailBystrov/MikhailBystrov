package hw4;

import homework.hw4.base.HomeWork4Base;
import homework.hw4.pageObjects.DatesPage;
import homework.hw4.pageObjects.HomePageSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homework.hw4.enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail
 */
public class SelenideTestCase2 extends HomeWork4Base {

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
        homePageSelenide.openSite();

        //2. Assert browser title
        homePageSelenide.checkHomePageTitle();

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