package win.pipi.swiftemotionboard.model;

/**
 * Created by pipi6 on 2018/1/24.
 */

public class OneEmotion {
    private String uri;
    //emotions' src;
    private String textRepresent;
    //emotions' text in editing words;

    public OneEmotion(String uri, String textRepresent) {
        this.uri = uri;
        this.textRepresent = textRepresent;
    }

    public String getUri() {
        return uri;
    }

    public String getTextRepresent() {
        return textRepresent;
    }
}
