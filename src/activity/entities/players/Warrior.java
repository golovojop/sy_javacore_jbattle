package activity.entities.players;

public class Warrior extends Hero {

    public Warrior(int health, String name, int damage, int addHeal) {
        super(health, name, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        // если герой не он сам, он может ударить
        if (hero != this) {
            // если у герой которого бьют жив, его можно ударить
            if(health < 0) {
                System.out.println("Герой погиб и бить не может!");
            } else {
                hero.causeDamage(damage);
            }
            System.out.println(this.name + " нанес урон " + hero.name);
        }
    }

    @Override
    public void healing(Hero hero) {
        System.out.println("Войны не умеют лечить!");
    }
}