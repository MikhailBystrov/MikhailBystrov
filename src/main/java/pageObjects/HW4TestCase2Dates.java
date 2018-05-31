package pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Mikhail on Май, 2018
 */
public class HW4TestCase2Dates {

    private SelenideElement pageTitle = $("title");
    private SelenideElement userIcon = $(".profile-photo");
    private SelenideElement loginInput = $("#Name");
    private SelenideElement passwordInput = $("#Password");
    private SelenideElement submitButton = $(".form-horizontal button[type = 'submit']");
    private SelenideElement profilePhoto = $(".profile-photo span");
    private SelenideElement serviceDropDown = $(".dropdown");
    private SelenideElement refToDatesPage = $("a[href = 'dates.html']");
    private SelenideElement leftSlider = $("a[style^='left:']:first-child");
    private SelenideElement leftSliderSpan = $("a[style^='left:']:first-child span");
    private SelenideElement rightSlider = $("a[style^='left:']:last-child");
    private SelenideElement rightSliderSpan = $("a[style^='left:']:last-child span");
    private SelenideElement logRows = $(".info-panel-body-log > .info-panel-section");
    private SelenideElement range2Slider = $("div .uui-slider");

    public void checkHomePageTitle(String title) {
        pageTitle.shouldHave(attribute("text", title));
    }

    public void login(String login, String password) {
        userIcon.click();
        loginInput.sendKeys(login);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public void checkUserIsLoggined(String name) {
        profilePhoto.shouldHave(text(name));
    }

    public void openDatesPage() {
        serviceDropDown.click();
        refToDatesPage.click();
    }

    public void moveLeftSliderRange2(int position) {
        double sliderWidth = range2Slider.getSize().getWidth();
        int sliderPosition = Integer.parseInt(leftSliderSpan.getText());
        Selenide.actions().dragAndDropBy(leftSlider, (int)(sliderWidth*(position - sliderPosition - 1)/100), 0)
                .build().perform();
    }

    public void moveRightSliderRange2(int position) {
        double sliderWidth = range2Slider.getSize().getWidth();
        int sliderPosition = Integer.parseInt(rightSliderSpan.getText());
        Selenide.actions().dragAndDropBy(rightSlider, (int)(sliderWidth*(position - sliderPosition - 1)/100), 0)
                .build().perform();
    }

    public void checkLogRowsForSliders(String text) {
        logRows.shouldHave(text(text));
    }
}

