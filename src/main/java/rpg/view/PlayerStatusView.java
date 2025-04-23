package rpg.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;
import rpg.model.Player;

public class PlayerStatusView {
    private final Scene scene;

    public PlayerStatusView(Stage stage, SceneView returnTo) {
        Player player = GameController.getInstance().getPlayer();

        Label name = new Label("Nombre: " + player.getName());
        Label hp = new Label("HP: " + player.getHp());
        Label atk = new Label("Ataque: " + player.getAttack());
        Label def = new Label("Defensa: " + player.getDefense());

        Button volverBtn = new Button("🔙 Volver");
        volverBtn.setOnAction(e -> {
            SceneView original = new SceneView(stage, returnTo.getCurrentSceneId());
            stage.setScene(original.getScene());
        });

        VBox layout = new VBox(15, name, hp, atk, def, volverBtn);
        scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

    }

    public Scene getScene() {
        return scene;
    }
}
