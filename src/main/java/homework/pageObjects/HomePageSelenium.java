package homework.pageObjects;

import homework.enums.TextsUnderImages;
import homework.enums.TopHeader;
import homework.enums.Users;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static homework.enums.MainHeader.MAIN_CONTENT_TEXT;
import static homework.enums.MainHeader.MAIN_CONTENT_TITLE;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Danila_Morokov on 5/23/2018.
 */
public class HomePageSelenium {

    @FindBy(css = ".profile-photo")
    private WebElement userIcon;

    @FindBy(css = "#Name")
    private WebElement loginInput;

    @FindBy(css = "#Password")
    private WebElement passwordInput;

    @FindBy(css = ".form-horizontal button[type = 'submit']")
    private WebElement submitButton;

    @FindBy(css = ".profile-photo span")
    private WebElement userName;

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

    @FindBy(css = ".icons-benefit icon-lessons.base")
    private WebElement mainIconBase;

    @FindBy(xpath = "//*[contains(span, 'To include')]")
    private WebElement textUnderIconToInclude;

    @FindBy(xpath = "//*[contains(span, 'To be flexible')]")
    private WebElement textUnderIconToBeFlexible;

    @FindBy(xpath = "//*[contains(span, 'To be multiplatform')]")
    private WebElement textUnderIconToBeMultiplatform;

    @FindBy(xpath = "//*[contains(span, 'good lessons.base')]")
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

    @FindBy(css = ".benefit-txt")
    private List<WebElement> benefit;

    @FindBy(css = ".nav > li")
    private List<WebElement> headerElements;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> allImages;

    public void openHomePage(WebDriver driver) {
        driver.navigate().to("https://epam.github.io/JDI/index.html");
    }

    public void login(Users users) {
        userIcon.click();
        loginInput.sendKeys(users.login);
        passwordInput.sendKeys(users.password);
        submitButton.click();
    }

    public void checkHomePageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Home Page");
    }

    public void checkUserIcon(Users users) {
        assertEquals(userName.getText(), users.name);
    }

    public void checkHeaderSection() {
        for (TopHeader texts : TopHeader.values()) {
            assertEquals(headerElements.get(texts.ordinal()).getText(), texts.text);
        }
    }

    public void checkImagesOnIndexPage() {
        assertEquals(allImages.size(), 4);
        for (WebElement element : allImages) {
            assertTrue(element.isDisplayed());
        }
    }

    public void checkTextOnIndexPage() {
        for (TextsUnderImages texts : TextsUnderImages.values()) {
            assertEquals(benefit.get(texts.ordinal()).getText(), texts.text);
        }
    }

    public void checkTextOfMainContent() {
        assertEquals(mainContentTitle.getText(), MAIN_CONTENT_TITLE.text);
        assertEquals(mainContentText.getText(), MAIN_CONTENT_TEXT.text);
    }

    public void checkTextOfSubHeader() {
        assertEquals(subHeaderText.getText(), "JDI GITHUB");
    }

    public void checkSubHeaderIsALink() {
        assertEquals(subHeaderText.getAttribute("href"), "https://github.com/epam/JDI");
    }

    public void checkThereIsLeftSection() {
        assertTrue(leftSection.isDisplayed());
    }

    public void checkThereIsFooter() {
        assertTrue(footer.isDisplayed());
    }
}
