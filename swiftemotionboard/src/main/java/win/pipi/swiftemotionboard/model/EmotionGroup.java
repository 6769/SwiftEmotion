package win.pipi.swiftemotionboard.model;

import java.util.List;

/**
 * Created by pipi6 on 2018/1/24.
 */

public class EmotionGroup {
    private String groupName;
    private List<OneEmotion> emotions;

    public EmotionGroup(String groupName, List<OneEmotion> emotions) {
        this.groupName = groupName;
        this.emotions = emotions;
    }

    public String getGroupName() {
        return groupName;
    }

    public List<OneEmotion> getEmotions() {
        return emotions;
    }
}
