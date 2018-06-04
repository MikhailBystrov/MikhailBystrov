package homework.pageObjects;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by Mikhail on Май, 2018
 */
public class DatesPage {

    private SelenideElement leftSlider = $("a[style^='left:']:first-child");
    private SelenideElement leftSliderSpan = $("a[style^='left:']:first-child span");
    private SelenideElement rightSlider = $("a[style^='left:']:last-child");
    private SelenideElement rightSliderSpan = $("a[style^='left:']:last-child span");
    private SelenideElement logRows = $(".info-panel-body-log > .info-panel-section");
    private SelenideElement range2Slider = $("div .uui-slider");

    public void moveSlidersRange2(int leftSliderPosition, int rightSliderPosition) {
        double sliderWidth = range2Slider.getSize().getWidth();
        int leftSliderCurrPosition = Integer.parseInt(leftSliderSpan.getText());
        int rightSliderCurrPosition = Integer.parseInt(rightSliderSpan.getText());
        if(leftSliderPosition >= rightSliderCurrPosition) {
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

