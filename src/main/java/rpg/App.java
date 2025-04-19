package rpg;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.HashSet;
import java.util.Set;

public class App extends Application {

    private final Set<KeyCode> keysPressed = new HashSet<>();
    private Player player;

    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();
        root.setPrefSize(800, 600);
        root.setStyle("-fx-background-color: #a0d8ef;");

        TileMap tileMap = new TileMap(root);

        player = new Player(tileMap);
        root.getChildren().add(player.getView());

        Scene scene = new Scene(root);
        scene.setOnKeyPressed(event -> keysPressed.add(event.getCode()));
        scene.setOnKeyReleased(event -> keysPressed.remove(event.getCode()));

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                boolean moving = false;

                if (keysPressed.contains(KeyCode.W) || keysPressed.contains(KeyCode.UP)) {
                    player.moveUp();
                    moving = true;
                } else if (keysPressed.contains(KeyCode.S) || keysPressed.contains(KeyCode.DOWN)) {
                    player.moveDown();
                    moving = true;
                }

                if (keysPressed.contains(KeyCode.A) || keysPressed.contains(KeyCode.LEFT)) {
                    player.moveLeft();
                    moving = true;
                } else if (keysPressed.contains(KeyCode.D) || keysPressed.contains(KeyCode.RIGHT)) {
                    player.moveRight();
                    moving = true;
                }

                if (moving) {
                    player.update(now); // avanzar frame de animación
                } else {
                    player.resetFrame(); // volver al primer frame
                }
            }
        }.start();

        primaryStage.setTitle("RPG con JavaFX - Movimiento y Animación");
        primaryStage.setScene(scene);
        primaryStage.show();

        root.requestFocus();
    }
}
