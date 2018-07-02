package homework.hw6.runners;

import com.codeborne.selenide.Configuration;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Danila_Morokov on 5/30/2018.
 */

@CucumberOptions(features = "src/test/java/hw6/testCase1", glue = "homework.hw6.pageObjects")
public class CucumberTestCase1TestngRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
    }
}
