package hw5.ex1;

import homework.hw5.base.HomeWork5Base;
import homework.hw5.pageObjects.DifferentElementsPage;
import homework.hw5.pageObjects.HomePageSelenide;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import lessons.listeners.AllureAttachmentListener;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.page;
import static homework.hw5.enums.CheckBoxes.WATER;
import static homework.hw5.enums.CheckBoxes.WIND;
import static homework.hw5.enums.ColorsDropDown.GREEN;
import static homework.hw5.enums.RadioButtons.SELEN;
import static homework.hw5.enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail on 31.05.2018
 */

@Feature("Different Elements page test")
@Story("Checking validity of operation of content presented on this page")
@Listeners(AllureAttachmentListener.class)
public class TestDifferentElementsFailed extends HomeWork5Base {

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
        homePageSelenide.openSite();

        //2. Assert browser title
        homePageSelenide.checkHomePageTitle();

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
        differentElementsPage.checkLogRowsForCheckbox(1, WIND, true);
        differentElementsPage.checkLogRowsForCheckbox(2, WATER, true);

        //14. Select radio
        differentElementsPage.selectRadio(SELEN);

        //15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        differentElementsPage.checkLogRowsForRadioButton(1, SELEN);

        //16. Select in dropdown
        differentElementsPage.selectInDropDown(GREEN);

        //17. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        differentElementsPage.checkLogRowsForColorsDropDown(1, GREEN);

        //18. Unselect and assert checkboxes
        differentElementsPage.selectCheckboxes(WATER);
        differentElementsPage.selectCheckboxes(WIND);

        //19. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        differentElementsPage.checkLogRowsForCheckbox(1, WIND, false);
        differentElementsPage.checkLogRowsForCheckbox(2, WATER, true); //'false' is right
    }
}