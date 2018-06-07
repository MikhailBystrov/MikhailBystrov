package homework.hw4.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw4.enums.CheckBoxes;
import homework.hw4.enums.ColorsDropDown;
import homework.hw4.enums.RadioButtons;
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
        String xPath = "//label[contains(.,'" + checkBoxes.name + "')]";
        SelenideElement checkBox = $x(xPath);
        checkBox.click();
    }

    public void checkLogRowsForCheckbox(int rowNumber, CheckBoxes checkBoxes, Boolean state) {
        logRows.get(rowNumber - 1).shouldHave(text(checkBoxes.name + ": condition changed to " + state.toString()));
    }

    public void selectRadio(RadioButtons radioButton) {
        String xPath = "//label[contains(.,'" + radioButton.name + "')]";
        SelenideElement radio = $x(xPath);
        radio.click();
    }

    public void checkLogRowsForRadioButton(int rowNumber, RadioButtons radioButtons) {
        logRows.get(rowNumber - 1).shouldHave(text("metal: value changed to " + radioButtons.name));
    }

    public void selectInDropDown(ColorsDropDown color) {
        diffElementsPageDropDown.click();
        String xPath = "//select/option[text()='" + color.name + "']";
        SelenideElement colorButton = $x(xPath);
        colorButton.click();
    }

    public void checkLogRowsForColorsDropDown(int rowNumber, ColorsDropDown color) {
        logRows.get(rowNumber - 1).shouldHave(text("Colors: value changed to " + color.name));
    }
}

