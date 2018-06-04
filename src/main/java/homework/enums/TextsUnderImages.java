package homework.enums;

/**
 * Created by Mikhail on 01.06.2018
 */
public enum TextsUnderImages {

    TEXT1("To include good practices\n" +
            "and ideas from successful\n" +
            "EPAM project"),
    TEXT2("To be flexible and\n" +
            "customizable"),
    TEXT3("To be multiplatform"),
    TEXT4("Already have good base\n" +
            "(about 20 internal and\n" +
            "some external projects),\n" +
            "wish to get more…");

    public String text;

    TextsUnderImages(String text) {
        this.text = text;
    }
}
