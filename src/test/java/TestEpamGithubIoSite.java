import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static java.lang.String.format;

/*
1. Create new test
 */
public class TestEpamGithubIoSite {
    private WebDriver driver = new ChromeDriver();

    //2. Open test site by URL
    @BeforeTest
    public void openBrowser() {
        driver.navigate().to("https://epam.github.io/JDI/");
        driver.manage().window().maximize();
    }

    @Test
    public void testSiteShouldBeOpen() {
        Assert.assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/");
    }

    //3. Assert browser title
    @Test
    public void browserTitleShouldBeEqualIndexPage() {
        Assert.assertEquals(driver.getTitle(), "Index Page");
    }

    //4. Perform login
    @Test
    public void logginedUserNameShouldBeDisplayedAndEqualsToExpectedResult() {
        WebElement userIcon = driver.findElement(By.cssSelector(".profile-photo"));
        userIcon.click();

        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();

        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Assert.assertTrue(userName.isDisplayed());
        Assert.assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }

    //5. Assert User name in the left-top side of screen that user is loggined
    @Test
    public void userNameshouldBeInTheLeftTopSide() {
        WebElement userName = driver.findElement(By.cssSelector(".profile-photo span"));
        Point point = userName.getLocation();
        Assert.assertEquals(format("(%s,%s)", point.getX(), point.getY()), "(20, 20)");
        System.out.println(userName.getLocation());
    }

    //6. Assert browser title
    @Test
    public void browserTitleShouldBeEqualHomePage() {
        Assert.assertEquals(driver.getTitle(), "Home Page");
    }

    //7. Assert that there are 4 items on the header section are displayed and they have proper texts
    @Test
    public void menuButtonsAreDisplayedAndHaveProperText() {
        Assert.assertTrue(driver.findElement(By.linkText("HOME")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("CONTACT FORM")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("SERVICE")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.linkText("METALS & COLORS")).isDisplayed());

    }

    //8. Assert that there are 4 images on the Index Page and they are displayed
    @Test
    public void imagesAreDisplayed() {
        List<WebElement> allImages = driver.findElements(By.tagName("img"));
        int counter = 0;
        for (WebElement image : allImages) {
            if (image.isDisplayed()) {
                counter++;
            }
        }
        Assert.assertEquals(counter, 4);
    }

    //9. Assert that there are 4 texts on the Index Page under icons and they have proper text
    @Test
    public void textWithIconsIsDisplayed() {
        List<WebElement> benefit = driver.findElements(By.className("benefit"));
        for (WebElement element : benefit) {
            WebElement childBox = element.findElement(By.className("benefit-icon"));
            Assert.assertTrue(childBox.isDisplayed());
            WebElement childText = element.findElement(By.className("benefit-txt"));
            Assert.assertTrue(childText.isDisplayed());
        }

    }

    //10. Assert a text of the main header
    @Test
    public void assertATextOfAMainHeader() {
        WebElement text = driver.findElement(By.cssSelector(".main-title"));
        Assert.assertEquals(text.getText(), "EPAM FRAMEWORK WISHES…");
        Assert.assertTrue(text.isDisplayed());

        WebElement secondText = driver.findElement(By.cssSelector(".main-txt"));
        Assert.assertEquals(secondText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
        Assert.assertTrue(secondText.isDisplayed());
    }

    //11. Assert a text of the sub header
    @Test
    public void assertATextOfASubHeader() {
        WebElement text = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(text.getText(), "JDI GITHUB");
        Assert.assertTrue(text.isDisplayed());
    }

    //12. Assert that JDI GITHUB is a link and has a proper URL
    @Test
    public void assertThatJDIGITHUBHasAProperURL() {
        WebElement text = driver.findElement(By.linkText("JDI GITHUB"));
        Assert.assertEquals(text.getAttribute("href"), "https://github.com/epam/JDI");
    }

    //13. Assert that there is Left Section
    @Test
    public void leftSectionShouldBeDisplayed() {
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        Assert.assertTrue(leftSection.isDisplayed());
    }

    //14. Assert that there is Footer
    @Test
    public void footerIsDisplayed() {
        WebElement footer = driver.findElement(By.className("footer-bg"));
        Assert.assertTrue(footer.isDisplayed());
    }

    //15. Close Browser
    @AfterClass
    public void close() {
        driver.close();
    }
}
