package rpg.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import rpg.model.Item;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ItemFactory {
    private static Map<String, Item> itemMap = new HashMap<>();

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = ItemFactory.class.getResourceAsStream("/data/items.json");
            List<Item> items = mapper.readValue(is, new TypeReference<List<Item>>() {});
            for (Item item : items) {
                itemMap.put(item.getId(), item);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Item getItemById(String id) {
        return itemMap.get(id);
    }
}
