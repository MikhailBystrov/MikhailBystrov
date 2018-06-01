package pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

/**
 * Created by Mikhail
 */
public class HW4TestCase1DifferentElements {

    private SelenideElement pageTitle = $("title");
    private SelenideElement userIcon = $(".profile-photo");
    private SelenideElement loginInput = $("#Name");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement submitButton = $(".form-horizontal button[type = 'submit']");
    private SelenideElement profilePhoto = $(".profile-photo span");

    private ElementsCollection homePageImages = $$("div.row div.benefit-icon");
    private ElementsCollection homePageText = $$("div.row span.benefit-txt");
    private SelenideElement homePageTitleCenterText = $(".main-title");
    private SelenideElement homePageSecondCenterText = $(".main-txt");

    private SelenideElement serviceDropDown = $(".dropdown");
    private ElementsCollection dropDownOptions = $$(".dropdown-menu li > a");
    private SelenideElement refToDiffElementsPage = $("a[href = 'different-elements.html']");

    private ElementsCollection diffElementsPageCheckBoxes = $$(".label-checkbox");
    private ElementsCollection diffElementsPageRadios = $$(".label-radio");
    private ElementsCollection diffElementsPageCheckButtons = $$("div.main-content-hg .uui-button");

    private SelenideElement diffElementsPageDropDown = $(".colors");
    private SelenideElement rightSection = $("div[name='log-sidebar']");
    private SelenideElement leftSection = $("div[name='navigation-sidebar']");

    private SelenideElement checkboxWater = $(".label-checkbox:nth-child(1)");
    private SelenideElement checkboxEarth = $(".label-checkbox:nth-child(2)");
    private SelenideElement checkboxWind = $(".label-checkbox:nth-child(3)");
    private SelenideElement checkboxFire = $(".label-checkbox:nth-child(4)");

    private SelenideElement goldRadio = $(".label-radio:nth-child(1)");
    private SelenideElement silverRadio = $(".label-radio:nth-child(2)");
    private SelenideElement bronzeRadio = $(".label-radio:nth-child(3)");
    private SelenideElement selenRadio = $(".label-radio:nth-child(4)");

    private SelenideElement dropDownColorRed = $("select option:nth-child(1)");
    private SelenideElement dropDownColorGreen = $("select option:nth-child(2)");
    private SelenideElement dropDownColorBlue = $("select option:nth-child(3)");
    private SelenideElement dropDownColorYellow = $("select option:nth-child(4)");

    private SelenideElement topLogRow = $(".info-panel-body-log li:first-child");


    public void checkHomePageTitle(String title) {
        pageTitle.shouldHave(attribute("text", title));
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserIsLoggined(String name) {
        profilePhoto.shouldHave(text(name));
    }

    public void checkHomePageInterface() {
        homePageImages.shouldHave(size(4));
        homePageText.shouldHave(size(4));
        homePageTitleCenterText.shouldBe(visible);
        homePageSecondCenterText.shouldBe(visible);
    }

    public void openDropDownMenuService() {
        serviceDropDown.click();
    }

    public void checkDropDownContainsOptions() {
        dropDownOptions.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    public void openDiffElementsPage() {
        refToDiffElementsPage.click();
    }

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

    public void selectCheckboxes(String name) {
        switch (name) {
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

    public void checkTwoTopLogRowsForCheckbox(int logRowNumber, String name, String state) {
        $(".info-panel-body-log li:nth-child(" + logRowNumber + ")").shouldHave(text(name), text(state));
    }

    public void selectRadio(String name) {
        switch (name) {
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

    public void checkTopLogRowForRadioButton(String name) {
        topLogRow.shouldHave(text(name));
    }

    public void selectInDropDown(String color) {
        diffElementsPageDropDown.click();
        switch (color) {
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
}

