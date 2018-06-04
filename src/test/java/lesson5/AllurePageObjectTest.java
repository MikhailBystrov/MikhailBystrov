package lesson5;

import lessons.base.TestBase;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Feature;
import io.qameta.allure.Flaky;
import io.qameta.allure.Story;
import lessons.listeners.AllureAttachmentListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import lessons.pageObjects.HomePageSelenide;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Mikhail on 5/18/2018.
 */

@Feature("Home page")
@Story("Login and check interface")
@Listeners({AllureAttachmentListener.class})
public class AllurePageObjectTest extends TestBase {

    private HomePageSelenide homePage;

    @BeforeClass
    public void beforeClass() {
        homePage = page(HomePageSelenide.class);
    }

    @AfterMethod
    public void afterMethod() {
        WebDriverRunner.closeWebDriver();
    }

    @Flaky
    @Test
    public void simpleSeleniumTest() {
        //1
        homePage.openHomePage();

        //2
        homePage.checkHomePageTitle();

        //3
        homePage.login("epam", "1234");

        //4
        homePage.checkUserName();
    }
}