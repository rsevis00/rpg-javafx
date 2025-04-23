package rpg.view;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import rpg.controller.GameController;
import rpg.model.CombatManager;
import rpg.model.Enemy;
import rpg.model.Player;

public class CombatView {
    private Scene scene;
    private TextArea combatLog;
    private Label statusLabel;
    private CombatManager combatManager;
    private Button attackBtn;

    public CombatView(Stage stage) {
        Player player = GameController.getInstance().getPlayer();
        Enemy enemy = new Enemy("Goblin", 30, 6, 2); // Se puede mejorar luego para ser aleatorio

        this.combatManager = new CombatManager(player, enemy);

        statusLabel = new Label(getStatus());
        statusLabel.setStyle("-fx-font-size: 14px; -fx-text-fill: #eeeeee;");

        combatLog = new TextArea("¡Te enfrentas a un " + enemy.getName() + "!\n");
        combatLog.setEditable(false);
        combatLog.setWrapText(true);
        combatLog.setStyle("-fx-control-inner-background: #1e1e1e; -fx-text-fill: #eeeeee;");

        attackBtn = new Button("⚔️ Atacar");
        attackBtn.setStyle("-fx-font-size: 14px;");
        attackBtn.setOnAction(e -> ejecutarTurno());

        VBox layout = new VBox(15, statusLabel, combatLog, attackBtn);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #2b2b2b;");

        scene = new Scene(layout, 600, 400);
    }

    private void ejecutarTurno() {
        if (combatManager.isCombatOver()) return;

        combatLog.appendText(combatManager.playerAttack() + "\n");
        if (!combatManager.getEnemy().isAlive()) {
            combatLog.appendText("🎉 Has derrotado a " + combatManager.getEnemy().getName() + "!\n");
            attackBtn.setDisable(true);
            return;
        }

        combatLog.appendText(combatManager.enemyAttack() + "\n");
        if (!combatManager.getPlayer().isAlive()) {
            combatLog.appendText("💀 Has sido derrotado. Game Over.\n");
            attackBtn.setDisable(true);
        }

        statusLabel.setText(getStatus());
    }

    private String getStatus() {
        Player player = combatManager.getPlayer();
        Enemy enemy = combatManager.getEnemy();
        return "👤 " + player.getName() + " HP: " + player.getHp() + "     |     🐲 " + enemy.getName() + " HP: " + enemy.getHp();
    }

    public Scene getScene() {
        return scene;
    }
}
