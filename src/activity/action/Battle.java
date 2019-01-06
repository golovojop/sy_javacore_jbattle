package activity.action;

import java.util.Random;

import activity.entities.players.Doctor;
import activity.entities.players.Hero;
import activity.entities.players.Warrior;
import activity.interactor.TvShow;

public class Battle {

    private Hero[] team1;
    private Hero[] team2;
    private TvShow tvshow;

    public Battle(Hero[] team1, Hero[] team2, TvShow tvshow) {
        this.team1 = team1;
        this.team2 = team2;
        this.tvshow = tvshow;
    }

    public void fight() {
        Random randomStep = new Random();
        Random randomHealing = new Random();
        // количество раундов
        int round = 3;

        for (int j = 0; j < round; j++) {
            // проходим по всем участникам команды
            for (int i = 0; i < team1.length; i++) {
                // рандомно выбираем кто будет первый ходить
                if(randomStep.nextInt(2) == 0) {
                    // если персонаж не доктор, то он может удрарить
                    // если доктор, то он лечит
                    if(team1[i] instanceof Doctor) {
                        team1[i].healing(team1[randomHealing.nextInt(2)]);
                    } else {
                        team1[i].hit(team2[i]);
                    }
                } else {
                    if(team2[i] instanceof Doctor) {
                        team2[i].healing(team2[randomHealing.nextInt(2)]);
                    } else {
                        team2[i].hit(team1[i]);
                    }
                }
            }
        }

        for (Hero t1: team1) {
            tvshow.nextComment(t1.info());
        }

        for (Hero t2: team2) {
            tvshow.nextComment(t2.info());
        }

    }


}
