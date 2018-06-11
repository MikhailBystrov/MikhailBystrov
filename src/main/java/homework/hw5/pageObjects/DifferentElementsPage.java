package homework.hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw5.enums.CheckBoxes;
import homework.hw5.enums.ColorsDropDown;
import homework.hw5.enums.RadioButtons;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

/**
 * Created by Mikhail
 */
public class DifferentElementsPage {

    @FindBy(css = ".label-checkbox")
    private ElementsCollection diffElementsPageCheckBoxes;
    @FindBy(css = ".label-radio")
    private ElementsCollection diffElementsPageRadios;
    @FindBy(css = "div.main-content-hg .uui-button")
    private ElementsCollection diffElementsPageCheckButtons;
    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;
    @FindBy(css = ".colors")
    private SelenideElement diffElementsPageDropDown;
    @FindBy(css = "div[name='log-sidebar']")
    private SelenideElement rightSection;
    @FindBy(css = "div[name='navigation-sidebar']")
    private SelenideElement leftSection;

    @FindBy(css = ".label-checkbox:nth-child(1)")
    private SelenideElement checkboxWater;
    @FindBy(css = ".label-checkbox:nth-child(2)")
    private SelenideElement checkboxEarth;
    @FindBy(css = ".label-checkbox:nth-child(3)")
    private SelenideElement checkboxWind;
    @FindBy(css = ".label-checkbox:nth-child(4)")
    private SelenideElement checkboxFire;

    @FindBy(css = ".label-radio:nth-child(1)")
    private SelenideElement goldRadio;
    @FindBy(css = ".label-radio:nth-child(2)")
    private SelenideElement silverRadio;
    @FindBy(css = ".label-radio:nth-child(3)")
    private SelenideElement bronzeRadio;
    @FindBy(css = ".label-radio:nth-child(4)")
    private SelenideElement selenRadio;

    @FindBy(css = "select option:nth-child(1)")
    private SelenideElement dropDownColorRed;
    @FindBy(css = "select option:nth-child(2)")
    private SelenideElement dropDownColorGreen;
    @FindBy(css = "select option:nth-child(3)")
    private SelenideElement dropDownColorBlue;
    @FindBy(css = "select option:nth-child(4)")
    private SelenideElement dropDownColorYellow;

    @Step("Checking the presence of page items such as 4 checkboxes, 4 radios, 2 buttons and 1 dropdown")
    public void checkDiffElementsPageInterface() {
        diffElementsPageCheckBoxes.shouldHave(size(4));
        diffElementsPageRadios.shouldHave(size(4));
        diffElementsPageCheckButtons.shouldHave(size(2));
        diffElementsPageDropDown.shouldBe(visible);
    }

    @Step("Checking the presence of the right section")
    public void checkThatThereIsRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Checking the presence of the left section")
    public void checkThatThereIsLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Click on a certain checkbox on different elements page")
    public void selectCheckboxes(CheckBoxes checkBoxes) {
        switch (checkBoxes.name) {
            case "Water":
                checkboxWater.click();
                break;
            case "Earth":
                checkboxEarth.click();
                break;
            case "Wind":
                checkboxWind.click();
                break;
            case "Fire":
                checkboxFire.click();
                break;
            default:
                break;
        }
    }

    @Step("Checking that the log row describes state and name of a certain check box")
    public void checkLogRowsForCheckbox(int rowNumber, CheckBoxes checkBoxes, Boolean state) {
        logRows.get(rowNumber - 1).shouldHave(text(checkBoxes.name + ": condition changed to " + state.toString()));
    }

    @Step("Click on a certain radio button on different elements page")
    public void selectRadio(RadioButtons radioButtons) {
        switch (radioButtons.name) {
            case "Gold":
                goldRadio.click();
            case "Silver":
                silverRadio.click();
                break;
            case "Bronze":
                bronzeRadio.click();
                break;
            case "Selen":
                selenRadio.click();
                break;
            default:
                break;
        }
    }

    @Step("Checking that the log row have a right text about chosen radio button")
    public void checkLogRowsForRadioButton(int rowNumber, RadioButtons radioButtons) {
        logRows.get(rowNumber - 1).shouldHave(text("metal: value changed to " + radioButtons.name));
    }

    @Step("Click on the dropdown menu and choose the color")
    public void selectInDropDown(ColorsDropDown color) {
        diffElementsPageDropDown.click();
        switch (color.name) {
            case "Red":
                dropDownColorRed.click();
            case "Green":
                dropDownColorGreen.click();
                break;
            case "Blue":
                dropDownColorBlue.click();
                break;
            case "Yellow":
                dropDownColorYellow.click();
                break;
            default:
                break;
        }
    }

    @Step("Checking that the log row have correct name of color from dropdown menu")
    public void checkLogRowsForColorsDropDown(int rowNumber, ColorsDropDown color) {
        logRows.get(rowNumber - 1).shouldHave(text("Colors: value changed to " + color.name));
    }
}

