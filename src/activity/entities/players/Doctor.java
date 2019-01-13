package activity.entities.players;

import static activity.entities.ShareData.*;

public class Doctor extends Hero {

    public Doctor(String name, int heal, int damage, int addHeal) {
        super(name, heal, damage, addHeal);
    }

    @Override
    public void hit(Hero hero) {
        liveCam.nextComment("Доктор " + name + " не может бить!");
    }

    @Override
    // Получить здоровье
    public void addHealth(int health) {
        this.health += health;
        if (this.health > HEAL_MAX_DOCTOR) this.health = HEAL_MAX_DOCTOR;
    }

    @Override
    // Лечить другого
    public void healing(Hero hero) {
        // Себя лечить нельзя
        if (hero != this) {
            if (hero.isAlive()) {
                hero.addHealth(addHeal);
                liveCam.nextComment(this.name + " подлечил " + hero.name);
            } else liveCam.nextComment(this.name + ": " + hero.name + " уже не лечится");
        }
    }
}