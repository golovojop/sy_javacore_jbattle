package activity.interactor;

import activity.entities.players.Assassin;
import activity.entities.players.Doctor;
import activity.entities.players.Hero;
import activity.entities.players.Warrior;

import java.util.ArrayList;
import java.util.Random;

public class TeamHelper {

    /**
     * Персонажи
     */
    //public static final Hero[] heroes = genHeroes();

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

    public static Hero[] genHeroes() {
        int seedNum = inRange(0, nameCollection.length - 1);

        ArrayList<Hero> al = new ArrayList<>();

        for(int i = 0; i < nameCollection.length; i++){
            if(seedNum == nameCollection.length) seedNum = 0;

            switch (i % 3) {
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
        return new Warrior(inRange(200, 280), name, inRange(30, 60), 0);
    }

    public static Assassin genAssassin(String name) {
        return new Assassin(inRange(130, 160), name, inRange(60, 90), 0);
    }

    public static Doctor genDoctor(String name) {
        return new Doctor(inRange(100, 120), name, 0, inRange(30, 60));
    }

    public static int inRange(int min, int max) {
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
