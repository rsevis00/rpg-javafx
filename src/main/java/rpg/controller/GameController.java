package rpg.controller;

import rpg.model.Player;

public class GameController {
    private static GameController instance;
    private Player player;

    private GameController() {}

    public static GameController getInstance() {
        if (instance == null) instance = new GameController();
        return instance;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
