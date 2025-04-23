package rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;
import rpg.model.Player;

public class IntroView {
    private Scene scene;

    public IntroView(Stage stage) {
        Player player = GameController.getInstance().getPlayer();

        TextArea introText = new TextArea(
            "🌲 Has despertado en un bosque desconocido...\n\n" +
            "Tu memoria está borrosa, pero sabes que debes avanzar.\n" +
            "Una aventura te espera, " + player.getName() + "."
        );
        introText.setWrapText(true);
        introText.setEditable(false);
        introText.setFocusTraversable(false);
        introText.setStyle("-fx-font-size: 16px; -fx-control-inner-background: #1e1e1e; -fx-text-fill: #eeeeee;");

        Button continuarBtn = new Button("▶️ Continuar");
        continuarBtn.setStyle("-fx-font-size: 14px; -fx-padding: 10px 20px;");
        continuarBtn.setOnAction(e -> {
            GameView gameView = new GameView(stage);
            stage.setScene(gameView.getScene());
        });

        VBox layout = new VBox(20, introText, continuarBtn);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2b2b2b;");

        scene = new Scene(layout, 600, 400);
    }

    public Scene getScene() {
        return scene;
    }
}
