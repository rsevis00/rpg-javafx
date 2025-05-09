package rpg.model;

public class Enemy {
    private String id;
    private String name;
    private int hp;
    private int attack;
    private int defense;

    public Enemy() {} // Necesario para que Jackson funcione

    public Enemy(String id, String name, int hp, int attack, int defense) {
        this.id = id;
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.defense = defense;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }

    public void takeDamage(int damage) {
        int realDamage = Math.max(damage - defense, 0);
        hp = Math.max(hp - realDamage, 0);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
