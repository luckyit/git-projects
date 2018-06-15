package pl.luckyit.test.model.enums;

/**
 * Created by Lucjan.Kornacki on 2018-06-14.
 */
public enum Encoding {
    NOOP("{noop}"), MD5("{MD5}");

    private final String value;

    Encoding(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
