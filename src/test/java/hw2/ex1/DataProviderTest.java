package hw2.ex1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class DataProviderTest {

    @DataProvider(parallel = true)
    public Object[][] simpleDataProvider() {
        return new Object[][]{
                {0, "1st image"},
                {1, "2nd image"},
                {2, "3rd image"},
                {3, "4th image"}
        };
    }

    @Test(dataProvider = "simpleDataProvider")
    public void testWithDataProvider(int i, String s) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.github.io/JDI/index.html");

        List<WebElement> benefit = driver.findElements(By.className("benefit"));
        WebElement childText = benefit.get(i).findElement(By.className("benefit-txt"));
        Assert.assertTrue(childText.isDisplayed());

        driver.close();
    }
}
