package homework.enums;

/**
 * Created by Mikhail on 04.06.2018
 */
public enum ServiceDropDownOptions {
    OPTION1("SUPPORT"),
    OPTION2("DATES"),
    OPTION3("COMPLEX TABLE"),
    OPTION4("SIMPLE TABLE"),
    OPTION5("USER TABLE"),
    OPTION6("TABLE WITH PAGES"),
    OPTION7("DIFFERENT ELEMENTS"),
    OPTION8("PERFORMANCE");

    public String text;

    ServiceDropDownOptions(String text) {
        this.text = text;
    }
}
