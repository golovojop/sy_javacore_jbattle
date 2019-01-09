package activity.entities.players;

import java.util.Random;

import static activity.entities.ShareData.*;

public class Assassin extends Hero {

    private int cricitalHit;

    public Assassin(String name, int heal, int damage, int addHeal) {
        super(name, heal, damage, addHeal);
        Random random = new Random();
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        // Себя бить нельзя
        if (hero != this) {
            // Бить может только живой
            if(health < 0) {
                liveCam.nextComment(this.name + " погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            liveCam.nextComment(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    // Пополнить свое здоровье
    public void addHealth(int health) {
        this.health += health;
        if(this.health > HEAL_MAX_ASSASSIN) this.health = HEAL_MAX_ASSASSIN;
    }

    @Override
    public void healing(Hero hero) {
        liveCam.nextComment(name + " не умеет лечить!");
    }
}
