package activity.entities.players;

public class Warrior extends Hero {

    private final int HEALTH_MAX = 300;

    public Warrior(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если у герой которого бьют жив, его можно ударить
            if(health < 0) {
                liveCam.nextComment(this.name + " погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            liveCam.nextComment(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    public void healing(Hero hero) {
        liveCam.nextComment("Воины не умеют лечить!");
    }
}