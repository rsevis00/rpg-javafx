package rpg.model;

import java.util.List;

public class SceneNode {
    private String id;
    private String text;
    private List<Choice> choices;

    public static class Choice {
        public String label;
        public String next;
    }

    public String getId() { return id; }
    public String getText() { return text; }
    public List<Choice> getChoices() { return choices; }
}
