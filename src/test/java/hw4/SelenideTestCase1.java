package hw4;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pageObjects.HW4TestCase1DifferentElements;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static enums.Users.PITER_CHAILOVSKII;

/**
 * Created by Mikhail on 31.05.2018
 */
public class SelenideTestCase1 {

    @BeforeClass
    public void beforeClass() {
        Configuration.browser ="chrome";
        Configuration.screenshots = false;
    }

    @Test
    public void testRange2AndLogsRows() {
        HW4TestCase1DifferentElements hw4TestCase1DifferentElements = page(HW4TestCase1DifferentElements.class);
        //1. Open test site
        open("https://epam.github.io/JDI/index.html");

        //2. Assert browser title
        hw4TestCase1DifferentElements.checkHomePageTitle("Home Page");

        //3. Perform login.
        hw4TestCase1DifferentElements.login(PITER_CHAILOVSKII.login, PITER_CHAILOVSKII.password);

        //4. Assert User name in the right-top side of screen that user is loggined
        hw4TestCase1DifferentElements.checkUserIsLoggined(PITER_CHAILOVSKII.name);

        //5. Check interface on Home page, it contains all needed elements.
        hw4TestCase1DifferentElements.checkHomePageInterface();

        //6. Click on "Service" subcategory in the header
        hw4TestCase1DifferentElements.openDropDownMenuService();

        //7. Check that drop down contains options
        hw4TestCase1DifferentElements.checkDropDownContainsOptions();

        //8. Open through the header menu Service -> Different Elements Page
        hw4TestCase1DifferentElements.openDiffElementsPage();

        //9. Check interface on Different elements page, it contains all needed elements
        hw4TestCase1DifferentElements.checkDiffElementsPageInterface();

        //10. Assert that there is Right Section
        hw4TestCase1DifferentElements.checkThatThereIsRightSection();

        //11. Assert that there is Left Section
        hw4TestCase1DifferentElements.checkThatThereIsLeftSection();

        //12. Select checkboxes
        hw4TestCase1DifferentElements.selectCheckboxes("Water");
        hw4TestCase1DifferentElements.selectCheckboxes("Wind");

        //13. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        hw4TestCase1DifferentElements.checkTwoTopLogRowsForCheckbox(1, "Wind", "true");
        hw4TestCase1DifferentElements.checkTwoTopLogRowsForCheckbox(2, "Water", "true");

        //14. Select radio
        hw4TestCase1DifferentElements.selectRadio("Selen");

        //15. Assert that for radiobutton there is a log row and value is corresponded to the status of radiobutton. 
        hw4TestCase1DifferentElements.checkTopLogRowForRadioButton("Selen");

        //16. Select in dropdown
        hw4TestCase1DifferentElements.selectInDropDown("Green");

        //17. Assert that for dropdown there is a log row and value is corresponded to the selected value. 
        hw4TestCase1DifferentElements.checkTopLogRowForRadioButton("Green");

        //18. Unselect and assert checkboxes
        hw4TestCase1DifferentElements.selectCheckboxes("Water");
        hw4TestCase1DifferentElements.selectCheckboxes("Wind");

        //19. Assert that for each checkbox there is an individual log row
        // and value is corresponded to the status of checkbox. 
        hw4TestCase1DifferentElements.checkTwoTopLogRowsForCheckbox(1, "Wind", "false");
        hw4TestCase1DifferentElements.checkTwoTopLogRowsForCheckbox(2, "Water", "false");
    }
}