package rpg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GameScreen {
    private Scene scene;

    public GameScreen(Stage stage) {
        Label label = new Label("Tu aventura comienza aquí...");
        StackPane layout = new StackPane(label);
        layout.setAlignment(Pos.CENTER);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
