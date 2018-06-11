package homework.hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw5.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Mikhail on 01.06.2018
 */
public class HomePageSelenide {

    @FindBy(css = ("title"))
    private SelenideElement pageTitle;
    @FindBy(css = (".profile-photo"))
    private SelenideElement userIcon;
    @FindBy(css = ("#Name"))
    private SelenideElement loginInput;
    @FindBy(css = ("#Password"))
    private SelenideElement passwordInput;
    @FindBy(css = (".form-horizontal button[type = 'submit']"))
    private SelenideElement submitButton;

    @FindBy(css = (".main-title"))
    private SelenideElement homePageTitleCenterText;
    @FindBy(css = (".main-txt"))
    private SelenideElement homePageSecondCenterText;
    @FindBy(css = ("div.row div.benefit-icon"))
    private ElementsCollection homePageImages;
    @FindBy(css = ("div.row span.benefit-txt"))
    private ElementsCollection homePageText;

    @FindBy(css = (".dropdown"))
    private SelenideElement serviceDropDown;
    @FindBy(css = ("a[href = 'different-elements.html']"))
    private SelenideElement refToDiffElementsPage;
    @FindBy(css = ("a[href = 'dates.html']"))
    private SelenideElement refToDatesPage;
    @FindBy(css = (".dropdown-menu li > a"))
    private ElementsCollection dropDownOptions;

    @Step("Open test site")
    public void openSite() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step("Check page title")
    public void checkHomePageTitle() {
        pageTitle.shouldHave(attribute("text", "Home Page"));
    }

    @Step("Login to the site")
    public void login(Users users) {
        userIcon.click();
        loginInput.sendKeys(users.login);
        passwordInput.sendKeys(users.password);
        submitButton.click();
    }

    @Step("Check user is loggined")
    public void checkUserIsLoggined(Users users) {
        userIcon.shouldHave(text(users.name));
    }

    @Step("Check page interface")
    public void checkHomePageInterface() {
        homePageImages.shouldHave(size(4));
        homePageText.shouldHave(size(4));
        homePageTitleCenterText.shouldBe(visible);
        homePageSecondCenterText.shouldBe(visible);
    }

    @Step("Open dropdown menu 'Service'")
    public void openDropDownMenuService() {
        serviceDropDown.click();
    }

    @Step("Check dropdown's options")
    public void checkDropDownContainsOptions() {
        dropDownOptions.shouldHave(texts("SUPPORT", "DATES", "COMPLEX TABLE",
                "SIMPLE TABLE", "USER TABLE", "TABLE WITH PAGES", "DIFFERENT ELEMENTS", "PERFORMANCE"));
    }

    @Step("Open 'Different Elements' page")
    public void openDiffElementsPage() {
        refToDiffElementsPage.click();
    }

    @Step("Open 'Dates' page")
    public void openDatesPage() {
        serviceDropDown.click();
        refToDatesPage.click();
    }
}