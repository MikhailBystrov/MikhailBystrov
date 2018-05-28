package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Mikhail on Май, 2018
 */
public class HomeWork3 {

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//header//nav//a[text() = 'Home']")
    private WebElement headerElementHome;

    @FindBy(xpath = "//header//nav//a[text() = 'Contact form']")
    private WebElement headerElementContact;

    @FindBy(xpath = "//*[contains(a, 'Service')]")
    private WebElement headerElementService;

    @FindBy(xpath = "//header//nav//a[text() = 'Metals & Colors']")
    private WebElement headerElementMetals;

    @FindBy(css = "span[class = 'icons-benefit icon-practise']")
    private WebElement mainIconPractise;

    @FindBy(css = "span[class = 'icons-benefit icon-custom']")
    private WebElement mainIconCustom;

    @FindBy(css = "span[class = 'icons-benefit icon-multi']")
    private WebElement mainIconMulti;

    @FindBy(css = "span[class = 'icons-benefit icon-base']")
    private WebElement mainIconBase;

    @FindBy(xpath = "//*[contains(span, 'To include')]")
    private WebElement textUnderIconToInclude;

    @FindBy(xpath = "//*[contains(span, 'To be flexible')]")
    private WebElement textUnderIconToBeFlexible;

    @FindBy(xpath = "//*[contains(span, 'To be multiplatform')]")
    private WebElement textUnderIconToBeMultiplatform;

    @FindBy(xpath = "//*[contains(span, 'good base')]")
    private WebElement textUnderIconGoodBase;

    @FindBy(css = ".main-title")
    private WebElement mainContentTitle;

    @FindBy(css = ".main-txt")
    private WebElement mainContentText;

    @FindBy(xpath = "//*[@class = 'main-content']//a[text() = 'JDI Github']")
    private WebElement subHeaderText;

    @FindBy(css = "div[name = 'navigation-sidebar']")
    private WebElement leftSection;

    @FindBy(css = "div[class = 'footer-bg']")
    private WebElement footer;

    public void open(WebDriver driver, String siteURL) {
        driver.navigate().to(siteURL);
    }

    public void checkSiteOpen(WebDriver driver, String expectedURL) {
        assertEquals(driver.getCurrentUrl(), expectedURL);
    }

    public void checkHomePageTitle(WebDriver driver, String title) {
        assertEquals(driver.getTitle(), title);
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkHeaderSection(WebDriver driver, int numberOfElements) {
        List<WebElement> headerElements = driver.findElements(By.cssSelector(".nav > li"));
        assertEquals(headerElements.size(), numberOfElements);
        assertEquals(headerElementHome.getText(), "HOME");
        assertEquals(headerElementContact.getText(), "CONTACT FORM");
        assertEquals(headerElementService.getText(), "SERVICE");
        assertEquals(headerElementMetals.getText(), "METALS & COLORS");
    }

    public void checkImagesOnIndexPage(WebDriver driver, int numberOfImages) {
        List<WebElement> allImages = driver.findElements(By.className("benefit"));
        assertEquals(allImages.size(), numberOfImages);
        assertTrue(mainIconPractise.isDisplayed());
        assertTrue(mainIconCustom.isDisplayed());
        assertTrue(mainIconMulti.isDisplayed());
        assertTrue(mainIconBase.isDisplayed());
    }

    public void checkTextOnIndexPage(WebDriver driver, int numberOfElements) {
        List<WebElement> benefit = driver.findElements(By.className("benefit"));
        assertEquals(benefit.size(), numberOfElements);
        assertEquals(textUnderIconToInclude.getText(), "To include good practices\n" +
                "and ideas from successful\n" +
                "EPAM project");
        assertEquals(textUnderIconToBeFlexible.getText(), "To be flexible and\n" +
                "customizable");
        assertEquals(textUnderIconToBeMultiplatform.getText(), "To be multiplatform");
        assertEquals(textUnderIconGoodBase.getText(), "Already have good base\n" +
                "(about 20 internal and\n" +
                "some external projects),\n" +
                "wish to get more…");
    }

    public void checkTextOfMainContent(WebDriver driver) {
        assertEquals(mainContentTitle.getText(), "EPAM FRAMEWORK WISHES…");
        assertEquals(mainContentText.getText(), "LOREM IPSUM DOLOR SIT AMET, CONSECTETUR ADIPISICING ELIT, " +
                "SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. UT ENIM AD MINIM VENIAM, " +
                "QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO CONSEQUAT DUIS AUTE IRURE " +
                "DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT NULLA PARIATUR.");
    }

    public void checkTextOfSubHeader(WebDriver driver, String text) {
        assertEquals(subHeaderText.getText(), text);
    }

    public void checkJDIGITHUBIsALink(WebDriver driver, String url) {
        assertEquals(subHeaderText.getAttribute("href"), url);
    }

    public void checkThereIsLeftSection(WebDriver driver) {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkThereIsFooter(WebDriver driver) {
        assertTrue(footer.isDisplayed());
    }
}
