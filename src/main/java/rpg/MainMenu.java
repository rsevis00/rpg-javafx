package rpg;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenu {
    private Scene scene;

    public MainMenu(Stage stage) {
        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);

        Button startButton = new Button("Nueva Partida");
        Button exitButton = new Button("Salir");

        startButton.setOnAction(e -> {
            GameScreen game = new GameScreen(stage);
            stage.setScene(game.getScene());
        });

        exitButton.setOnAction(e -> {
            stage.close();
        });

        layout.getChildren().addAll(startButton, exitButton);
        scene = new Scene(layout, 400, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
