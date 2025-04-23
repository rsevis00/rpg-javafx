package rpg.model;

import java.util.List;

public class SceneNode {
    private String id;
    private String text;
    private Integer experience;
    private String enemyId;
    private List<String> items;
    private List<Choice> choices;

    public static class Choice {
        public String label;
        public String next;
        public Integer experience;
        public String enemyId;
        public List<String> items;
    }

    public String getId() { return id; }
    public String getText() { return text; }
    public Integer getExperience() { return experience; }
    public String getEnemyId() { return enemyId; }
    public List<String> getItems() { return items; }
    public List<Choice> getChoices() { return choices; }
}
