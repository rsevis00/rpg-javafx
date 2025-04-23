package rpg.model;

public class Item {
    private String id;
    private String name;
    private String description;
    private int healAmount;

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getHealAmount() { return healAmount; }

    @Override
    public String toString() {
        return name + " (" + description + ")";
    }
}
