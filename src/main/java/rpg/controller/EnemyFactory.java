package rpg.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import rpg.model.Enemy;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EnemyFactory {
    private static Map<String, Enemy> enemyMap = new HashMap<>();

    static {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream is = EnemyFactory.class.getResourceAsStream("/data/enemies.json");
            List<Enemy> enemies = mapper.readValue(is, new TypeReference<List<Enemy>>() {});
            for (Enemy enemy : enemies) {
                enemyMap.put(enemy.getId(), enemy);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Enemy getEnemyById(String id) {
        return enemyMap.get(id);
    }
}
