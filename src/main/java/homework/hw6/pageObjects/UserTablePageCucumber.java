package homework.hw6.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.qameta.allure.Description;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

/**
 * Created by Mikhail on 02.07.2018
 */
public class UserTablePageCucumber {

    public UserTablePageCucumber() {
        Selenide.page(this);
    }

    @FindBy(css = ("title"))
    private SelenideElement pageTitle;
    @FindBy(css = "td select")
    private List<SelenideElement> typeDropdown;
    @FindBy(css = "td a")
    private List<SelenideElement> userLink;
    @FindBy(css = "td img")
    private List<SelenideElement> descriptionImage;
    @FindBy(css = "[type ='checkbox']")
    private List<SelenideElement> vipStatusCheckbox;
    @FindBy(css = "#user-table th")
    private List<SelenideElement> userTableHeaders;
    @FindBy(css = ".user-descr span")
    private List<SelenideElement> userDescription;
    @FindBy(css = ".logs li")
    private List<SelenideElement> logRows;

    @Then("I am on Users Table Page")
    public void checkUserTablePageTitle() {
        pageTitle.shouldHave(attribute("text", "User Table"));
    }

    @Then("User Table Page's interface contains correct elements")
    public void checkUserTablePageInterfaceContent() {
        assertEquals(typeDropdown.size(), 6);
        for (SelenideElement element : typeDropdown) {
            element.shouldBe(visible);
        }
        assertEquals(userLink.size(), 6);
        for (SelenideElement element : userLink) {
            element.shouldHave(attribute("href"));
        }
        assertEquals(descriptionImage.size(), 6);
        for (SelenideElement element : descriptionImage) {
            element.shouldBe(visible);
        }
        assertEquals(vipStatusCheckbox.size(), 6);
        for (SelenideElement element : vipStatusCheckbox) {
            element.shouldBe(visible);
        }
    }

    @Description("I didn't get the meaning of this step")
    @When("I check Number and User columns of Users table")
    public void checkTableNumberAndUserColumns() {
        userTableHeaders.get(0).shouldHave(text("Number"));
        userTableHeaders.get(2).shouldHave(text("User"));
    }

    @Then("User table contain correct values for numbers and users")
    public void checkUserTableNumberAndUserValues(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 1; i < list.size(); i++) {
            assertEquals(userLink.get(i).getText(), list.get(i).get("User"));
            assertEquals(String.valueOf(i), list.get(i - 1).get("Number"));
        }
    }

    @Description("I didn't get the meaning of this step too")
    @When("I check Description column of Users table")
    public void checkTableDescriptionColumn() {
        userTableHeaders.get(3).shouldHave(text("Desciption")); //Desciption - at the site. I know that descRiption is right
    }


    @Then("All cells of 'Description' column contains text")
    public void checkUserTableDescriptionValues(DataTable dataTable) {
        List<Map<String, String>> list = dataTable.asMaps(String.class, String.class);
        for (int i = 0; i < list.size(); i++) {
            assertEquals(userDescription.get(i).getText(), list.get(i).get("Description"));
        }
    }

    @When("I set 'vip' status to Sergey Ivan")
    public void setVipStatusCheckbox() {
        vipStatusCheckbox.get(1).click();
    }

    @Then("'Log' section shows a log row in format: FIELDNAME: condition changed to (.+)")
    public void checkLogRow(String status) {
        logRows.get(0).shouldHave(text("Vip: condition changed to " + status));
    }

    @When("I click on dropdown in column Type for user Roman")
    public void expandDropdown() {
        typeDropdown.get(1).click();
    }

    @Then("droplist contains values")
    public void dropDownContains(List<String> options) {
        for(int i = 1; i < options.size(); i++) {
            assertEquals(typeDropdown.get(i - 1).getText(), options.get(i));
        }
    }
}
