package activity.entities.players;

import java.util.Arrays;
import java.util.Comparator;

public class Team {

    private Hero[] heroes;
    private int id;

    public Team(int id, Hero[] heroes) {
        this.heroes = heroes;
        this.id = id;
    }

    // Остался ли кто живой
    public boolean isAnybodyLive() {
        for(Hero h : heroes) {
            if(h.isAlive()) return true;
        }
        return false;
    }

    // Найти менее здорового
    private Hero getMoreUnhealthy(){
        Hero h = heroes[0];
        for (int i =1; i < heroes.length; i++){
            if(h.health > heroes[i].health) h = heroes[i];
        }
        return h;
    }

    // Боевое построение. Более здоровый - вперед.
    private void prepareToFight() {
        Arrays.sort(heroes, new Comparator<Hero>() {
            @Override
            public int compare(Hero o1, Hero o2) {
                return o2.health - o1.health;
            }
        });
    }

    // Лечить наименее здорового в команде
    public void healing(Hero doctor) {
        doctor.healing(getMoreUnhealthy());
    }

    // Выделить героя для следующей схватки
    public Hero getNext() {
        prepareToFight();
        return heroes[0];
    }

    // Показать результаты
    public void showResults(){
        for (Hero h1: heroes) {
            h1.liveCam.nextComment(h1.info());
        }
    }

  public String toString(){
        return "Team " + id;
    }
}
