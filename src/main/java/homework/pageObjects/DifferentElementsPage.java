package homework.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.enums.CheckBoxes;
import homework.enums.ColorsDropDown;
import homework.enums.RadioButtons;
import org.openqa.selenium.support.FindBy;

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
    @FindBy(css = ".info-panel-body-log > .info-panel-section")
    private SelenideElement logRows;

    public void checkDiffElementsPageInterface() {
        diffElementsPageCheckBoxes.shouldHave(size(4));
        diffElementsPageRadios.shouldHave(size(4));
        diffElementsPageCheckButtons.shouldHave(size(2));
        diffElementsPageDropDown.shouldBe(visible);
    }

    public void checkThatThereIsRightSection() {
        rightSection.shouldBe(visible);
    }

    public void checkThatThereIsLeftSection() {
        leftSection.shouldBe(visible);
    }

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

    public void checkLogRowsForCheckbox(CheckBoxes checkBoxes, Boolean state) {
        logRows.shouldHave(text(checkBoxes.name), text(state.toString()));
    }

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

    public void checkLogRowsForRadioButton(RadioButtons radioButtons) {
        logRows.shouldHave(text(radioButtons.name));
    }

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

    public void checkLogRowsForColorsDropDown(ColorsDropDown color) {
        logRows.shouldHave(text(color.name));
    }
}

