package rpg.model;

import java.util.ArrayList;
import java.util.List;

public class Inventory {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item) {
        items.add(item);
    }

    public List<Item> getItems() {
        return items;
    }

    public void useItem(Item item, Player player) {
        if (item.getHealAmount() > 0) {
            player.heal(item.getHealAmount());
        }
        items.remove(item);
    }
}
