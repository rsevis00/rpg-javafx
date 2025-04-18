package rpg;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Player {
    private final Image image1;
    private final Image image2;
    private final ImageView imageView;
    private final Group node;

    private boolean toggleFrame = false;
    private final double speed = 2;

    private boolean facingRight = true;

    private long lastFrameTime = 0;
    private final long frameDuration = 200_000_000; // 200ms

    public Player() {
        image1 = new Image(getClass().getResource("/images/soldierwalk/Soldier-Walk1.PNG").toExternalForm());
        image2 = new Image(getClass().getResource("/images/soldierwalk/Soldier-Walk2.PNG").toExternalForm());

        imageView = new ImageView(image1);
        imageView.setFitWidth(128);
        imageView.setFitHeight(128);
        imageView.setPreserveRatio(true);
        // Centramos el ImageView dentro del Group para que al reflejar no "salte"
        imageView.setTranslateX(-imageView.getFitWidth() / 2);
        imageView.setTranslateY(-imageView.getFitHeight() / 2);

        node = new Group(imageView);
        node.setLayoutX(100);
        node.setLayoutY(100);
    }

    public Group getView() {
        return node;
    }

    public void moveUp() {
        node.setLayoutY(node.getLayoutY() - speed);
    }

    public void moveDown() {
        node.setLayoutY(node.getLayoutY() + speed);
    }

    public void moveLeft() {
        node.setLayoutX(node.getLayoutX() - speed);
        if (facingRight) {
            imageView.setScaleX(-1); // solo reflejo
            facingRight = false;
        }
    }
    
    public void moveRight() {
        node.setLayoutX(node.getLayoutX() + speed);
        if (!facingRight) {
            imageView.setScaleX(1);
            facingRight = true;
        }
    }
    

    // Llamado en cada ciclo del juego para alternar entre los 2 sprites
    public void update(long now) {
        if (now - lastFrameTime >= frameDuration) {
            toggleFrame = !toggleFrame;
            imageView.setImage(toggleFrame ? image2 : image1);
            lastFrameTime = now;
        }
    }

    public void resetFrame() {
        imageView.setImage(image1);
    }
}
