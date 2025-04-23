package rpg.view;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.SceneLoader;
import rpg.model.SceneNode;

public class SceneView {
    private Scene scene;

    public SceneView(Stage stage, String sceneId) {
        SceneNode node = SceneLoader.loadScene(sceneId);

        TextArea text = new TextArea(node.getText());
        text.setEditable(false);
        text.setWrapText(true);
        text.setStyle("-fx-control-inner-background: #1e1e1e; -fx-text-fill: #eeeeee;");

        VBox layout = new VBox(15, text);
        layout.setPadding(new Insets(20));

        for (SceneNode.Choice choice : node.getChoices()) {
            Button btn = new Button(choice.label);
            btn.setOnAction(e -> {
                SceneView next = new SceneView(stage, choice.next);
                stage.setScene(next.getScene());
            });
            layout.getChildren().add(btn);
        }

        layout.setStyle("-fx-background-color: #2b2b2b;");
        scene = new Scene(layout, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
