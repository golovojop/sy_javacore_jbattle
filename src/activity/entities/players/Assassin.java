package activity.entities.players;

import java.util.Random;

public class Assassin extends Hero {

    int cricitalHit;
    Random random;

    public Assassin(int heal, String name, int damage, int addHeal) {
        super(heal, name, damage, addHeal);
        random = new Random();
        this.cricitalHit = random.nextInt(20);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если герой которого бьют жив, его можно ударить
            if(health < 0) {
                liveCam.nextComment(this.name + "погиб и бить не может!");
            } else {
                hero.causeDamage(damage + cricitalHit);
            }
            liveCam.nextComment(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    public void healing(Hero hero) {
        liveCam.nextComment("Убийцы не умеют лечить!");
    }
}
