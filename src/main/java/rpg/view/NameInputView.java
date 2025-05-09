package rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;
import rpg.model.Player;

public class NameInputView {
    private Scene scene;

    public NameInputView(Stage stage) {
        Label prompt = new Label("¿Cuál es tu nombre, aventurero?");

        TextField nameInput = new TextField();
        nameInput.setPromptText("Escribe tu nombre");
        nameInput.setStyle("-fx-font-size: 14px;");

        Button continuarBtn = new Button("Comenzar aventura");
        continuarBtn.setOnAction(e -> {
            String name = nameInput.getText().trim();
            if (!name.isEmpty()) {
                Player player = new Player(name);
                GameController.getInstance().setPlayer(player);
                IntroView intro = new IntroView(stage);
                stage.setScene(intro.getScene());
            } else {
                prompt.setText("¡Por favor, escribe un nombre válido!");
                prompt.setStyle("-fx-font-size: 18px; -fx-text-fill: #ff6b6b;");
            }
        });

        VBox layout = new VBox(15, prompt, nameInput, continuarBtn);
        layout.setPadding(new Insets(40));
        layout.setAlignment(Pos.CENTER);

        scene = new Scene(layout, 500, 300);
        scene.getStylesheets().add(getClass().getResource("/styles/styles.css").toExternalForm());

    }

    public Scene getScene() {
        return scene;
    }
}
