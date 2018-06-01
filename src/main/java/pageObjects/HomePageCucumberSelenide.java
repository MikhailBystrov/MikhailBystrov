package pageObjects;

import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Danila_Morokov on 5/23/2018.
 */
public class HomePageCucumberSelenide {

    public HomePageCucumberSelenide() {
        page(this);
    }

    @FindBy(css = ".profile-photo")
    private SelenideElement userIcon;

    @FindBy(css = "#Name")
    private SelenideElement loginInput;

    @FindBy(css = "#Password")
    private SelenideElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private SelenideElement submitButton;

    @FindBy(css = ".profile-photo span")
    private SelenideElement userName;

    @Step
    @Given("I'm on the Home Page")
    public void openHomePage() {
        open("https://epam.github.io/JDI/index.html");
    }

    @Step("Login")
    @When("I login as user (.+) with password (.+)")
    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    @Step
    @Then("The browser title is Home Page")
    public void checkHomePageTitle() {
        assertEquals(getWebDriver().getTitle(), "Home Page");
    }

    @Step
    @Then("The user icon is displayed on the header")
    public void checkUserName() {
        assertTrue(userName.isDisplayed());
    }
}
