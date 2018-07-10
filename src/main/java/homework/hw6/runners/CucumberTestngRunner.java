package homework.hw6.runners;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Danila_Morokov on 5/30/2018.
 */

@CucumberOptions(features = "src/test/java/hw6", glue = "homework.hw6.pageObjects")
public class CucumberTestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
    @AfterMethod
    public void tearDown() {
        WebDriverRunner.closeWebDriver();
    }
}
