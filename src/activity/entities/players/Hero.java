package activity.entities.players;

import activity.interactor.TvShow;

public abstract class Hero implements Cloneable {

    // имя героя
    protected String name;
    // здоровье героя
    protected int health;
    // сколько урона может нанести герой
    protected int damage;
    // сколько здоровья может восстановть герой
    protected int addHeal;
    // трансляция боя
    protected TvShow liveCam;

    public Hero(int health, String name, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    // нанести удар
    public abstract void hit(Hero hero);

    // лечить
    public abstract void healing(Hero hero);

    // получить удар
    public void causeDamage(int damage) {
        if(health < 0) {
            liveCam.nextComment("Герой уже мертвый!");
        } else {
            health -= damage;
        }
    }

    public void setLiveCam(TvShow liveCam) {
        this.liveCam = liveCam;
    }

    public int getHealth() {
        return health;
    }

    // добавить здоровье
    public void addHealth(int health) {
        this.health += health;
    }

    public String info() {
        return name + " " + (health < 0 ? "Герой мертвый" : health) + " " + damage;
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

