package runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;
import pageObjects.HomePageCucumberSelenide;

import static com.codeborne.selenide.Selenide.page;

/**
 * Created by Mikhail on 31.05.2018
 */

@CucumberOptions(features = "src/test/java/lesson6", glue = "pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    public HomePageCucumberSelenide homePage;

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";

        homePage = page(HomePageCucumberSelenide.class);
    }
}
