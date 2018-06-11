package homework.hw5.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.hw5.enums.Users;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;

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


    public void checkHomePageTitle(String title) {
        pageTitle.shouldHave(attribute("text", title));
    }

    public void login(Users users) {
        userIcon.click();
        loginInput.sendKeys(users.login);
        passwordInput.sendKeys(users.password);
        submitButton.click();
    }

    public void checkUserIsLoggined(Users users) {
        userIcon.shouldHave(text(users.name));
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

    public void openDatesPage() {
        serviceDropDown.click();
        refToDatesPage.click();
    }
}