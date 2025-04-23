package rpg.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import rpg.model.SceneNode;

import java.io.InputStream;

public class SceneLoader {
    public static SceneNode loadScene(String id) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream input = SceneLoader.class.getResourceAsStream("/scenes/" + id + ".json");
            return mapper.readValue(input, SceneNode.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
