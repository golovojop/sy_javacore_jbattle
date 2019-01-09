package activity.entities.players;

import static activity.entities.ShareData.*;

public class Warrior extends Hero {

    public Warrior(String name, int health, int damage, int addHeal) {
        super(name, health, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        // Себя бить нельзя
        if (hero != this) {
            // Бить может только живой
            if(health < 0) {
                liveCam.nextComment(this.name + " погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            liveCam.nextComment(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    // Получить здоровье
    public void addHealth(int health) {
        this.health += health;
        if(this.health > HEAL_MAX_WARRIOR) this.health = HEAL_MAX_WARRIOR;
    }

    @Override
    public void healing(Hero hero) {
        liveCam.nextComment(name + " не умеет лечить!");
    }
}