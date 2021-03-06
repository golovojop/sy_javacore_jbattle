package activity.entities.players;

import java.util.Random;

import static activity.entities.ShareData.*;

public class Assassin extends Hero {

    private int criticalHit;

    public Assassin(String name, int heal, int damage, int addHeal) {
        super(name, heal, damage, addHeal);
        Random random = new Random();
        this.criticalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        // Себя бить нельзя
        if (hero != this) {
            // Бить может только живой
            if (isDead()) {
                liveCam.nextComment(this.name + " погиб и бить не может!");
            } else {
                liveCam.nextComment(this.name + " бьет по " + hero.name);
                hero.causeDamage(damage + criticalHit);
            }
        }
    }

    @Override
    // Пополнить свое здоровье
    public void addHealth(int health) {
        this.health += health;
        if (this.health > HEAL_MAX_ASSASSIN) this.health = HEAL_MAX_ASSASSIN;
    }

    @Override
    public void healing(Hero hero) {
        liveCam.nextComment(name + " не умеет лечить!");
    }

    public String getCapacity() {
        return getClass().getSimpleName() + ":" + name + "\n damage:" + damage + " (+ " + criticalHit + "), health:" + health;
    }
}
