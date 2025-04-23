package rpg.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;
import rpg.controller.SceneLoader;
import rpg.model.SceneNode;

public class SceneView {
    private Scene scene;
    private final String currentSceneId;

    public SceneView(Stage stage, String sceneId) {
        this.currentSceneId = sceneId;
        SceneNode node = SceneLoader.loadScene(sceneId);

        TextArea text = new TextArea(node.getText());
        text.setEditable(false);
        text.setWrapText(true);

        VBox layout = new VBox(15, text);
        layout.setPadding(new Insets(20));

        // Botones de opciones de escena
        if (node.getChoices() != null) {
            for (SceneNode.Choice choice : node.getChoices()) {
                Button choiceBtn = new Button(choice.label);
                choiceBtn.setOnAction(e -> {
                    SceneView next = new SceneView(stage, choice.next);
                    stage.setScene(next.getScene());
                });
                layout.getChildren().add(choiceBtn);
            }
        }

        // Botón de estado
        Button estadoBtn = new Button("📊 Ver Estado");
        estadoBtn.setOnAction(e -> {
            PlayerStatusView status = new PlayerStatusView(stage, this);
            stage.setScene(status.getScene());
        });

        // Botón de inventario
        Button inventarioBtn = new Button("🎒 Ver Inventario");
        inventarioBtn.setOnAction(e -> {
            InventoryView inv = new InventoryView(stage, this);
            stage.setScene(inv.getScene());
        });

        layout.getChildren().addAll(estadoBtn, inventarioBtn);
        scene = new Scene(layout, 600, 450);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());
    }

    public Scene getScene() {
        return scene;
    }

    public String getCurrentSceneId() {
        return currentSceneId;
    }
}
