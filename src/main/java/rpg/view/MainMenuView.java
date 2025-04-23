package rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MainMenuView {
    private Scene scene;

    public MainMenuView(Stage stage) {
        Label title = new Label("RPG de Texto");
        title.setStyle("-fx-font-size: 28px; -fx-text-fill: #eeeeee;");

        Button startButton = new Button("🎮 Nueva Partida");
        Button exitButton = new Button("❌ Salir");

        startButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");
        exitButton.setStyle("-fx-font-size: 16px; -fx-padding: 10px 20px;");

        startButton.setOnAction(e -> {
            NameInputView nameInput = new NameInputView(stage);
            stage.setScene(nameInput.getScene());
        });

        exitButton.setOnAction(e -> stage.close());

        VBox layout = new VBox(20, title, startButton, exitButton);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(50));
        layout.setStyle("-fx-background-color: #1e1e1e;");

        scene = new Scene(layout, 500, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
