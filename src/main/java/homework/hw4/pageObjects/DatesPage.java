package homework.hw4.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;

/**
 * Created by Mikhail on May, 2018
 */
public class DatesPage {

    @FindBy(css = "a[style^='left:']:first-child")
    private SelenideElement leftSlider;
    @FindBy(css = "a[style^='left:']:first-child span")
    private SelenideElement leftSliderSpan;
    @FindBy(css = "a[style^='left:']:last-child")
    private SelenideElement rightSlider;
    @FindBy(css = "a[style^='left:']:last-child span")
    private SelenideElement rightSliderSpan;
    @FindBy(css = ".info-panel-body-log > .info-panel-section")
    private SelenideElement logRows;
    @FindBy(css = "div .uui-slider")
    private SelenideElement range2Slider;

    public void moveSlidersRange2(int leftSliderPosition, int rightSliderPosition) {
        double sliderWidth = range2Slider.getSize().getWidth();
        int leftSliderCurrPosition = Integer.parseInt(leftSliderSpan.getText());
        int rightSliderCurrPosition = Integer.parseInt(rightSliderSpan.getText());
        if (leftSliderPosition >= rightSliderCurrPosition) {
            Selenide.actions().dragAndDropBy(rightSlider, (int) (sliderWidth * (rightSliderPosition - rightSliderCurrPosition - 1) / 100), 0)
                    .build().perform();
            Selenide.actions().dragAndDropBy(leftSlider, (int) (sliderWidth * (leftSliderPosition - leftSliderCurrPosition - 1) / 100), 0)
                    .build().perform();
        } else {
            Selenide.actions().dragAndDropBy(leftSlider, (int) (sliderWidth * (leftSliderPosition - leftSliderCurrPosition - 1) / 100), 0)
                    .build().perform();
            Selenide.actions().dragAndDropBy(rightSlider, (int) (sliderWidth * (rightSliderPosition - rightSliderCurrPosition - 1) / 100), 0)
                    .build().perform();
        }
    }

    public void checkLogRowsForSliders(String text) {
        logRows.shouldHave(text(text));
    }
}

