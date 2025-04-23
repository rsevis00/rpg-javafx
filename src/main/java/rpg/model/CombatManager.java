package rpg.model;

public class CombatManager {
    private Player player;
    private Enemy enemy;

    public CombatManager(Player player, Enemy enemy) {
        this.player = player;
        this.enemy = enemy;
    }

    public String playerAttack() {
        enemy.takeDamage(player.getAttack());
        return player.getName() + " ataca a " + enemy.getName() + " por " + player.getAttack() + " de daño.";
    }

    public String enemyAttack() {
        player.takeDamage(enemy.getAttack());
        return enemy.getName() + " te ataca por " + enemy.getAttack() + " de daño.";
    }

    public boolean isCombatOver() {
        return !player.isAlive() || !enemy.isAlive();
    }

    public Player getPlayer() { return player; }
    public Enemy getEnemy() { return enemy; }
}
