package activity.interactor;

import activity.entities.players.Assassin;
import activity.entities.players.Doctor;
import activity.entities.players.Hero;
import activity.entities.players.Warrior;
import static activity.entities.ShareData.*;

import java.util.ArrayList;
import java.util.Random;


public class TeamHelper {

    /**
     * Персонажи
     */
    private static String[] nameCollection = {
            "Тигрил",
            "Минотавр",
            "Акали",
            "Джинкс",
            "Зои",
            "Жанна",
            "Кратос",
            "Букер",
            "Геральт",
            "Шепард",
            "Данте",
            "Брюс"};

    /**
     * Генератор героев
     */
    public static Hero[] genHeroes() {
        int seedNum = inRange(0, nameCollection.length - 1);

        ArrayList<Hero> al = new ArrayList<>();

        for(int i = 0; i < nameCollection.length; i++){
            if(seedNum == nameCollection.length) seedNum = 0;

            switch (i % TEAM_SIZE) {
                case 0:
                    al.add(genWarrior(nameCollection[seedNum++]));
                    break;
                case 1:
                    al.add(genAssassin(nameCollection[seedNum++]));
                    break;
                    default:
                        al.add(genDoctor(nameCollection[seedNum++]));
            }
        }
        return al.toArray(new Hero[al.size()]);
    }

    public static Warrior genWarrior(String name) {
        return new Warrior(name,
                inRange(HEAL_MAX_WARRIOR - HEAL_RANGE, HEAL_MAX_WARRIOR),
                inRange(DMG_MAX_WARRIOR - DMG_RANGE, DMG_MAX_WARRIOR),
                HEAL_INC_ZERO);
    }

    public static Assassin genAssassin(String name) {
        return new Assassin(name,
                inRange(HEAL_MAX_ASSASSIN - HEAL_RANGE, HEAL_MAX_ASSASSIN),
                inRange(DMG_MAX_ASSASSIN - DMG_RANGE, DMG_MAX_ASSASSIN),
                HEAL_INC_ZERO);
    }

    public static Doctor genDoctor(String name) {
        return new Doctor(name,
                inRange(HEAL_MAX_DOCTOR - HEAL_RANGE, HEAL_MAX_DOCTOR),
                DMG_MAX_DOCTOR,
                inRange(HEAL_INC_MIN, HEAL_INC_MAX));
    }

    public static int inRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
