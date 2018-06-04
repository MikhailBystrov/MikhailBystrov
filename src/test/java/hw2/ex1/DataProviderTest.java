package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataProviderTest {

    @DataProvider(parallel = true)
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {1, "To include good practices\n" +
                        "and ideas from successful\n" +
                        "EPAM project"},
                {2, "To be flexible and\n" +
                        "customizable"},
                {3, "To be multiplatform"},
                {4, "Already have good base\n" +
                        "(about 20 internal and\n" +
                        "some external projects),\n" +
                        "wish to get more…"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void testWithDataProvider(int textNumber, String text) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //1 Open test site by URL
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        //2 Check 4 texts below 4 pictures on the Index Page
        List<WebElement> benefit = driver.findElements(By.cssSelector(".benefit-txt"));
        assertEquals(benefit.get(textNumber - 1).getText(), text);

        driver.close();
    }
}
