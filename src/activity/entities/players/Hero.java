package activity.entities.players;

public abstract class Hero implements Cloneable {

    // здоровье героя
    protected int health;
    // имя героя
    protected String name;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановть герой
    protected int addHeal;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    // нанести удар
    abstract void hit(Hero hero);

    // лечить
    abstract void healing(Hero hero);

    // получить удар
    void causeDamage(int damage) {
        if(health < 0) {
            System.out.println("Герой уже мертвый!");
        } else {
            health -= damage;
        }
    }

    public int getHealth() {
        return health;
    }

    // добавить здоровье
    void addHealth(int health) {
        this.health += health;
    }

    void info() {
        System.out.println(name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage);
    }

    public String toString() {
        return getClass().getSimpleName() + ":" + name;
    }

    public String getCapacity() {
        return getClass().getSimpleName() + ":" + name + "\n damage=" + damage + ", health=" + health;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

