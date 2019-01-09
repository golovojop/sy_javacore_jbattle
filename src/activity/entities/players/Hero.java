package activity.entities.players;

import activity.interactor.TvShow;

public abstract class Hero implements Cloneable, Comparable {

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

    public Hero(String name, int health, int damage, int addHeal) {
        this.health = health;
        this.name = name;
        this.damage = damage;
        this.addHeal = addHeal;
    }

    @Override
    public int compareTo(Object o) {
        return this.health - ((Hero)o).health;
    }

    // Нанести удар другому Hero
    public abstract void hit(Hero hero);

    // Лечить Hero
    public abstract void healing(Hero hero);

    // Пополнить свое здоровье
    public abstract void addHealth(int health);

    // Обработать полученный удар
    public void causeDamage(int damage) {
        if(health < 0) {
            liveCam.nextComment(name + " уже мертвый!");
        } else {
            health -= damage;
            liveCam.nextComment("\t<" + name + " remaining heal: " + health + ">");
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setLiveCam(TvShow liveCam) {
        this.liveCam = liveCam;
    }

    public String info() {
        return name + ": h=" + (health < 0 ? " мертв" : health) + ", d=" + damage;
    }

    public String toString() {
        return getClass().getSimpleName() + ":" + name;
    }
    public String getCapacity() {
        return getClass().getSimpleName() + ":" + name + "\n damage:" + damage + ", health:" + health;
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

