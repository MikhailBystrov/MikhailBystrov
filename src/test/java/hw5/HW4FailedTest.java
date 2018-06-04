package hw5;

import homework.base.HomeWork4Base;
import homework.pageObjects.DifferentElementsPage;
import homework.pageObjects.HomePageSelenide;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static homework.enums.CheckBoxes.WATER;
import static homework.enums.CheckBoxes.WIND;
import static homework.enums.ColorsDropDown.GREEN;
import static homework.enums.RadioButtons.SELEN;
import static homework.enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail on 31.05.2018
 */
public class HW4FailedTest extends HomeWork4Base {

    private DifferentElementsPage differentElementsPage;
    private HomePageSelenide homePageSelenide;

    @BeforeClass
    public void beforeClass() {
        differentElementsPage = page(DifferentElementsPage.class);
        homePageSelenide = page(HomePageSelenide.class);
    }

    @Test(description = "Test 'Different Elements' page content")
    public void testDiffElementsButtonsAndLogRows() {
        //1. Open test site
        open("https://epam.github.io/JDI/index.html");

        //2. Assert browser title
        homePageSelenide.checkHomePageTitle("WRONG Page");

        //3. Perform login.
        homePageSelenide.login(PITER_CHAILOVSKII);

        //4. Assert User name in the right-top side of screen that user is loggined
        homePageSelenide.checkUserIsLoggined(PITER_CHAILOVSKII);

        //5. Check interface on Home page, it contains all needed elements.
        homePageSelenide.checkHomePageInterface();

        //6. Click on "Service" subcategory in the header
        homePageSelenide.openDropDownMenuService();

        //7. Check that drop down contains options
        homePageSelenide.checkDropDownContainsOptions();

        //8. Open through the header menu Service -> Different Elements Page
        homePageSelenide.openDiffElementsPage();

        //9. Check interface on Different elements page, it contains all needed elements
        differentElementsPage.checkDiffElementsPageInterface();

        //10. Assert that there is Right Section
        differentElementsPage.checkThatThereIsRightSection();

        //11. Assert that there is Left Section
        differentElementsPage.checkThatThereIsLeftSection();

        //12. Select checkboxes
        differentElementsPage.selectCheckboxes(WATER);
        differentElementsPage.selectCheckboxes(WIND);

        //13. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogRowsForCheckbox(WIND, true);
        differentElementsPage.checkLogRowsForCheckbox(WATER, true);

        //14. Select radio
        differentElementsPage.selectRadio(SELEN);

        //15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLogRowsForRadioButton(SELEN);

        //16. Select in dropdown
        differentElementsPage.selectInDropDown(GREEN);

        //17. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.checkLogRowsForColorsDropDown(GREEN);

        //18. Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WATER);
        differentElementsPage.selectCheckboxes(WIND);

        //19. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogRowsForCheckbox(WIND, false);
        differentElementsPage.checkLogRowsForCheckbox(WATER, false);
    }
}