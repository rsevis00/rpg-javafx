package rpg;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    // Tamaño del personaje en pantalla (y para colisiones)
    private final double characterWidth = 32;
    private final double characterHeight = 32;

    private final Image image1;
    private final Image image2;
    private final ImageView imageView;
    private final Group node;

    private boolean toggleFrame = false;
    private final double speed = 2;

    private boolean facingRight = true;

    private long lastFrameTime = 0;
    private final long frameDuration = 200_000_000; // 200ms

    // Dimensiones fijas del escenario
    private final double sceneWidth = 800;
    private final double sceneHeight = 600;

    private final TileMap tileMap;

    public Player(TileMap tileMap) {
        this.tileMap = tileMap;

        image1 = new Image(getClass().getResource("/images/soldierwalk/Soldier-Walk1.PNG").toExternalForm());
        image2 = new Image(getClass().getResource("/images/soldierwalk/Soldier-Walk2.PNG").toExternalForm());

        imageView = new ImageView(image1);
        imageView.setFitWidth(characterWidth);
        imageView.setFitHeight(characterHeight);
        imageView.setPreserveRatio(true);

        // Centrado del sprite en su contenedor
        imageView.setTranslateX(-characterWidth / 2);
        imageView.setTranslateY(-characterHeight / 2);

        node = new Group(imageView);
        node.setLayoutX(100);
        node.setLayoutY(100);
    }

    public Group getView() {
        return node;
    }

    public void moveUp() {
        double nextY = node.getLayoutY() - speed;
        double centerX = node.getLayoutX();
    
        if (tileMap.isWalkable(centerX, nextY) && dentroDelEscenario(centerX, nextY)) {
            node.setLayoutY(nextY);
        }
    }
    

    public void moveDown() {
        double nextY = node.getLayoutY() + speed;
        double centerX = node.getLayoutX();
    
        if (tileMap.isWalkable(centerX, nextY) && dentroDelEscenario(centerX, nextY)) {
            node.setLayoutY(nextY);
        }
    }
    

    public void moveLeft() {
        double nextX = node.getLayoutX() - speed;
        double centerY = node.getLayoutY();
    
        if (tileMap.isWalkable(nextX, centerY) && dentroDelEscenario(nextX, centerY)) {
            node.setLayoutX(nextX);
            if (facingRight) {
                imageView.setScaleX(-1);
                facingRight = false;
            }
        }
    }
    

    public void moveRight() {
        double nextX = node.getLayoutX() + speed;
        double centerY = node.getLayoutY();
    
        if (tileMap.isWalkable(nextX, centerY) && dentroDelEscenario(nextX, centerY)) {
            node.setLayoutX(nextX);
            if (!facingRight) {
                imageView.setScaleX(1);
                facingRight = true;
            }
        }
    }
    

    // Alterna entre las dos imágenes para simular caminar
    public void update(long now) {
        if (now - lastFrameTime >= frameDuration) {
            toggleFrame = !toggleFrame;
            imageView.setImage(toggleFrame ? image2 : image1);
            lastFrameTime = now;
        }
    }

    private boolean dentroDelEscenario(double x, double y) {
        return (
            x - characterWidth / 2 >= 0 &&
            x + characterWidth / 2 <= tileMap.getMapWidth() &&
            y - characterHeight / 2 >= 0 &&
            y + characterHeight / 2 <= tileMap.getMapHeight()
        );
    }
    

    // Vuelve al primer sprite si el jugador está quieto
    public void resetFrame() {
        imageView.setImage(image1);
    }
}
