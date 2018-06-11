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
import static com.codeborne.selenide.Selenide.$x;

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
        String xPath = "//label[contains(.,'" + checkBoxes.name + "')]";
        SelenideElement checkBox = $x(xPath);
        checkBox.click();
    }

    @Step("Checking that the log row describes state and name of a certain check box")
    public void checkLogRowsForCheckbox(int rowNumber, CheckBoxes checkBoxes, Boolean state) {
        logRows.get(rowNumber - 1).shouldHave(text(checkBoxes.name + ": condition changed to " + state.toString()));
    }

    @Step("Click on a certain radio button on different elements page")
    public void selectRadio(RadioButtons radioButton) {
        String xPath = "//label[contains(.,'" + radioButton.name + "')]";
        SelenideElement radio = $x(xPath);
        radio.click();
    }

    @Step("Checking that the log row have a right text about chosen radio button")
    public void checkLogRowsForRadioButton(int rowNumber, RadioButtons radioButtons) {
        logRows.get(rowNumber - 1).shouldHave(text("metal: value changed to " + radioButtons.name));
    }

    @Step("Click on the dropdown menu and choose the color")
    public void selectInDropDown(ColorsDropDown color) {
        diffElementsPageDropDown.click();
        String xPath = "//select/option[text()='" + color.name + "']";
        SelenideElement colorButton = $x(xPath);
        colorButton.click();
    }

    @Step("Checking that the log row have correct name of color from dropdown menu")
    public void checkLogRowsForColorsDropDown(int rowNumber, ColorsDropDown color) {
        logRows.get(rowNumber - 1).shouldHave(text("Colors: value changed to " + color.name));
    }
}

