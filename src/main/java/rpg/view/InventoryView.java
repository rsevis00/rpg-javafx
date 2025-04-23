package rpg.view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class InventoryView {
    private final Scene scene;

    public InventoryView(Stage stage, SceneView returnTo) {
        Label label = new Label("Inventario (en desarrollo)");

        Button volverBtn = new Button("🔙 Volver");
        volverBtn.setOnAction(e -> {
            SceneView original = new SceneView(stage, returnTo.getCurrentSceneId());
            stage.setScene(original.getScene());
        });

        VBox layout = new VBox(20, label, volverBtn);
        scene = new Scene(layout, 400, 300);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

    }

    public Scene getScene() {
        return scene;
    }
}
