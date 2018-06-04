package homework.hw3.enums;

/**
 * Created by Mikhail on 04.06.2018
 */
public enum TopHeader {

    TEXT1("HOME"),
    TEXT2("CONTACT FORM"),
    TEXT3("SERVICE"),
    TEXT4("METALS & COLORS");

    public String text;

    TopHeader(String text) {
        this.text = text;
    }
}
