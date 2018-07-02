package homework.hw6.pageObjects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homework.hw6.enums.Users;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Mikhail on 02.07.2018
 */
public class HomePageCucumber {

    public HomePageCucumber() {
        Selenide.page(this);
    }

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
    @FindBy(css = (".dropdown-menu [href = 'different-elements.html']"))
    private SelenideElement refToDiffElementsPage;

    @FindBy(css = (".dropdown-menu [href = 'user-table.html']"))
    private SelenideElement refToUserTablePage;

    @Step("Open test site")
    @Given("I am on the Home Page")
    public void openSite() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step("Check page title")
    @Then("Home Page is the browser title")
    public void checkHomePageTitle() {
        pageTitle.shouldHave(attribute("text", "Home Page"));
    }

    @Step("Login to the site")
    @When("I login as user (.+)")
    public void login(String users) {
        Users user = Users.valueOf(users);
        userIcon.click();
        loginInput.sendKeys(user.login);
        passwordInput.sendKeys(user.password);
        submitButton.click();
    }

    @Step("Check user is loggined")
    @Then("(.+) name is displayed on the header")
    public void checkUserIsLoggined(String users) {
        Users user = Users.valueOf(users);
        userIcon.shouldHave(text(user.name));
    }

    @Step("Check page interface")
    @Then("Home Page contains 4 pictures")
    public void checkHomePageImages() {
        homePageImages.shouldHave(size(4));
    }

    @Then("Home Page contains 4 texts under them")
    public void checkHomePageTextsUnderImages() {
        homePageText.shouldHave(size(4));
    }

    @Then("Home Page contains 2 texts above")
    public void checkHomePageTextsAbove() {
        homePageTitleCenterText.shouldBe(visible);
        homePageSecondCenterText.shouldBe(visible);
    }

    @Step("Open 'Different Elements' page")
    @When("I open Different Elements page through the header menu")
    public void openDiffElementsPage() {
        serviceDropDown.click();
        refToDiffElementsPage.click();
    }

    @Step("Open 'User table' page")
    @When("I open User table page through the header menu")
    public void openUserTablePage() {
        serviceDropDown.click();
        refToUserTablePage.click();
    }
}
