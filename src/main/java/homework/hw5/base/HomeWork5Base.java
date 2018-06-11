package homework.hw5.base;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

/**
 * Created by Mikhail on 01.06.2018
 */
public class HomeWork5Base {

    @BeforeSuite
    public void beforeSuite() {
        Configuration.browser = "chrome";
        Configuration.screenshots = false;
    }
}