package rpg;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class TileMap {
    private final int[][] map;
    private final int tileSize = 32; // cada tile será de 64x64 px
    private final Image grass;
    private final Image stone;

    public TileMap(Pane root) {
        grass = new Image(getClass().getResource("/images/tiles/grass.png").toExternalForm());
        stone = new Image(getClass().getResource("/images/tiles/stone.jpg").toExternalForm());

        // 0 = grass, 1 = stone
        map = new int[][] {
            {0,0,0,0,1,1,1,0,0,0,0,0,1,1,0,0,0,0,0,0,1,1,1,0,0},
            {0,1,1,0,1,0,0,0,1,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0},
            {0,1,0,0,1,0,0,0,1,1,0,1,0,0,0,0,0,1,1,1,0,0,0,0,0},
            {0,1,0,0,1,1,1,0,0,0,0,0,0,0,1,1,1,0,0,1,1,1,0,0,0},
            {0,1,0,0,0,0,1,1,0,0,0,0,1,1,0,0,1,1,0,0,0,1,0,0,0},
            {0,0,0,1,1,0,0,1,0,1,1,0,0,1,1,0,0,0,0,0,0,0,0,0,0},
            {0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0},
            {0,0,0,0,1,1,0,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,0,0},
            {0,0,0,0,1,1,0,0,1,1,1,1,1,0,0,0,0,1,0,0,0,1,0,0,0},
            {0,1,1,0,0,0,0,1,1,0,0,0,0,1,1,1,0,0,0,1,1,1,0,0,0},
            {0,0,1,1,1,0,0,0,1,1,0,1,1,0,0,0,1,1,0,0,0,1,1,0,0},
            {0,0,0,0,1,0,1,1,0,0,0,1,1,0,0,0,0,0,0,0,1,1,0,0,0},
            {1,1,0,0,1,1,1,0,0,1,1,0,0,0,1,1,1,0,0,0,1,0,0,0,0},
            {0,0,0,0,1,0,0,0,1,1,1,0,0,1,1,0,0,0,0,1,1,0,0,1,1},
            {0,1,1,0,0,0,1,0,0,0,1,1,1,0,0,1,1,1,0,0,1,1,0,0,0},
            {0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,1,0,0,0,0,0,1,0,0,0},
            {0,0,1,1,0,0,0,0,0,0,1,1,1,0,0,0,1,1,0,0,0,1,1,0,0},
            {0,0,0,0,0,0,1,1,0,0,0,1,1,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        

        for (int y = 0; y < map.length; y++) {
            for (int x = 0; x < map[0].length; x++) {
                Image tileImage = (map[y][x] == 0) ? grass : stone;
                ImageView tile = new ImageView(tileImage);
                tile.setFitWidth(tileSize);
                tile.setFitHeight(tileSize);
                tile.setX(x * tileSize);
                tile.setY(y * tileSize);
                root.getChildren().add(tile);
            }
        }
    }

    public boolean isWalkable(double x, double y) {
        int tileX = (int) (x / tileSize);
        int tileY = (int) (y / tileSize);

        if (tileY < 0 || tileY >= map.length || tileX < 0 || tileX >= map[0].length) {
            return false; // fuera del mapa = no transitable
        }

        return map[tileY][tileX] == 0; // solo 0 (césped) es transitable
    }

    public int getTileSize() {
        return tileSize;
    }
    
    public double getMapWidth() {
        return map[0].length * tileSize;
    }
    
    public double getMapHeight() {
        return map.length * tileSize;
    }
}
