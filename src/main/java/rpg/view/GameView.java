package rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;

public class GameView {
    private Scene scene;

    public GameView(Stage stage) {
        var player = GameController.getInstance().getPlayer();

        Label bienvenida = new Label("Bienvenido, " + player.getName() + ". Estás listo para combatir.");
        bienvenida.setStyle("-fx-font-size: 16px; -fx-text-fill: #eeeeee;");

        Button lucharBtn = new Button("⚔️ Iniciar combate");
        lucharBtn.setStyle("-fx-font-size: 14px;");
        lucharBtn.setOnAction(e -> {
            CombatView combate = new CombatView(stage);
            stage.setScene(combate.getScene());
        });

        VBox layout = new VBox(20, bienvenida, lucharBtn);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(40));
        layout.setStyle("-fx-background-color: #2b2b2b;");

        scene = new Scene(layout, 600, 300);
    }

    public Scene getScene() {
        return scene;
    }
}
