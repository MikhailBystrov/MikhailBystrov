package hw1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AutoTestHW1 {
    private WebDriver driver = new ChromeDriver();

    @AfterClass
    public void close() {
        driver.close();
    }

    @Test
    public void testEPAMGithubIoSite() {
        driver.navigate().to("https://epam.github.io/JDI/");
        driver.manage().window().maximize();

        //2. Assert test site is open
        assertEquals(driver.getCurrentUrl(), "https://epam.github.io/JDI/index.html");

        //3. Assert browser title
        assertEquals(driver.getTitle(), "Home Page");

        //4. Perform login. Assert User name in the left-top side of screen that user is loggined
        driver.findElement(By.cssSelector(".profile-photo")).click();
        driver.findElement(By.cssSelector("#Name")).sendKeys("epam");
        driver.findElement(By.cssSelector("#Password")).sendKeys("1234");
        driver.findElement(By.cssSelector(".form-horizontal button[type = 'submit']")).click();
        assertEquals(driver.findElement(By.cssSelector(".profile-photo span")).getText(), "PITER CHAILOVSKII");

        //5. Assert browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> headerElements = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(headerElements.size(), 4);
        assertEquals(headerElements.get(0).getText(), "HOME");
        assertEquals(headerElements.get(1).getText(), "CONTACT FORM");
        assertEquals(headerElements.get(2).getText(), "SERVICE");
        assertEquals(headerElements.get(3).getText(), "METALS & COLORS");

        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> allImages = driver.findElements(By.className("benefit"));
        assertEquals(allImages.size(), 4);
        for (WebElement element : allImages) {
            assertTrue(element.findElement(By.className("benefit-icon")).isDisplayed());
        }

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> benefit = driver.findElements(By.className("benefit"));
        assertEquals(benefit.size(), 4);
        assertEquals(benefit.get(0).getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(benefit.get(1).getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(benefit.get(2).getText(), "To be multiplatform");
        assertEquals(benefit.get(3).getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");

        //9. Assert a text of the main content
        assertEquals(driver.findElement(By.cssSelector(".main-title")).getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(driver.findElement(By.cssSelector(".main-txt")).getText(),
                "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");

        //10. Assert a text of the sub header
        assertEquals(driver.findElement(By.cssSelector(".text-center > a")).getText(), "JDI GITHUB");

        //11. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(driver.findElement(By.linkText("JDI GITHUB")).getAttribute("href"), "https://github.com/epam/JDI");

        //12. Assert that there is Left Section
        assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());

        //13. Assert that there is Footer
        assertTrue(driver.findElement(By.className("footer-bg")).isDisplayed());
    }
}
