package rpg.model;

public class Player {
    private String name;
    private int hp;
    private int maxHp;
    private int attack;
    private int defense;
    private int level;
    private int experience;

    public Player(String name) {
        this.name = name;
        this.level = 1;
        this.experience = 0;
        this.maxHp = 100;
        this.hp = maxHp;
        this.attack = 10;
        this.defense = 5;
    }

    // Getters y setters
    public String getName() { return name; }
    public int getHp() { return hp; }
    public int getAttack() { return attack; }
    public int getDefense() { return defense; }
    public int getLevel() { return level; }

    public void takeDamage(int amount) {
        int damage = Math.max(amount - defense, 0);
        hp = Math.max(hp - damage, 0);
    }

    public void heal(int amount) {
        hp = Math.min(hp + amount, maxHp);
    }

    public boolean isAlive() {
        return hp > 0;
    }
}
