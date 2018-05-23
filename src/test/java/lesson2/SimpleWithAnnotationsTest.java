package lesson2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

public class SimpleWithAnnotationsTest {
    private WebDriver driver;
    private ChromeOptions options;

    @BeforeClass
    public void beforeClass() {
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("download.default_directory", "targer");

        options = new ChromeOptions();
        options.setExperimentalOption("prefs", chromePrefs);
    }

    @BeforeMethod
    public void beforeMethod() {

    }

    @AfterMethod
    public void afterMethod() {

    }

    @Test
    public void simpleSeleniumTest() {
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        Assert.assertEquals(driver.getTitle(), "Index Page");

        WebElement userIcon = driver.findElement(By.cssSelector(".fa-user"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Login")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");

        driver.close();
    }
}
