package homework.hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

/**
 * Created by Mikhail on 02.07.2018
 */
public class DifferentElementsPageCucumber {

    public DifferentElementsPageCucumber() {
        Selenide.page(this);
    }

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

    @Step("Checking the presence of 4 checkboxes")
    @Then("Different Elements page contains 4 checkboxes")
    public void checkDiffElementsPageCheckboxes() {
        diffElementsPageCheckBoxes.shouldHave(size(4));
    }

    @Step("Checking the presence of 4 radios")
    @Then("Different Elements page contains 4 radios")
    public void checkDiffElementsPageRadios() {
        diffElementsPageRadios.shouldHave(size(4));
    }

    @Step("Checking the presence of 1 dropdown")
    @Then("Different Elements page contains 1 dropdown")
    public void checkDiffElementsPageDropdown() {
        diffElementsPageDropDown.shouldBe(visible);
    }

    @Step("Checking the presence of 2 buttons")
    @Then("Different Elements page contains 2 buttons")
    public void checkDiffElementsPageButtons() {
        diffElementsPageCheckButtons.shouldHave(size(2));
    }

    @Step("Checking the presence of the right section")
    @Then("I can see right section")
    public void checkThatThereIsRightSection() {
        rightSection.shouldBe(visible);
    }

    @Step("Checking the presence of the left section")
    @Then("I can see left section")
    public void checkThatThereIsLeftSection() {
        leftSection.shouldBe(visible);
    }

    @Step("Click on a certain checkbox on different elements page")
    @When("I select checkbox: (.+)")
    public void selectCheckboxes(String checkBoxes) {
        String xPath = "//label[contains(.,'" + checkBoxes + "')]";
        SelenideElement checkBox = $x(xPath);
        checkBox.click();
    }

    @Step("Checking that the log row describes state and name of a certain check box")
    @Then("There is a log row number (.+) for checkbox (.+). State (.+)")
    public void checkLogRowsForCheckbox(String rowStringNumber, String checkBoxes, String state) {
        int rowIntNumber = Integer.parseInt(rowStringNumber);
        boolean boolState = Boolean.parseBoolean(state);
        logRows.get(rowIntNumber - 1).shouldHave(text(checkBoxes + ": condition changed to " + boolState));
    }

    @Step("Click on a certain radio button on different elements page")
    @When("I select radio: (.+)")
    public void selectRadio(String radioButton) {
        String xPath = "//label[contains(.,'" + radioButton + "')]";
        SelenideElement radio = $x(xPath);
        radio.click();
    }

    @Step("Checking that the log row have a right text about chosen radio button")
    @Then("There is a log row number (.+) for radio (.+)")
    public void checkLogRowsForRadioButton(String rowStringNumber, String radioButtons) {
        int rowIntNumber = Integer.parseInt(rowStringNumber);
        logRows.get(rowIntNumber - 1).shouldHave(text("metal: value changed to " + radioButtons));
    }

    @Step("Click on the dropdown menu and choose the color")
    @When("I select in dropdown: (.+)")
    public void selectInDropDown(String color) {
        diffElementsPageDropDown.click();
        String xPath = "//select/option[text()='" + color + "']";
        SelenideElement colorButton = $x(xPath);
        colorButton.click();
    }

    @Step("Checking that the log row have correct name of color from dropdown menu")
    @Then("There is a log row number (.+) for color (.+)")
    public void checkLogRowsForColorsDropDown(String rowStringNumber, String color) {
        int rowIntNumber = Integer.parseInt(rowStringNumber);
        logRows.get(rowIntNumber - 1).shouldHave(text("Colors: value changed to " + color));
    }
}
