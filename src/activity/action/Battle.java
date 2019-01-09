package activity.action;

import java.util.Random;

import activity.entities.players.*;
import activity.interactor.TvShow;
import static activity.entities.ShareData.*;

public class Battle {

    private TvShow tvshow;
    private Team team1;
    private Team team2;

    public Battle(Team team1, Team team2, TvShow tvShow){
        this.team1 = team1;
        this.team2 = team2;
        this.tvshow = tvShow;
    }

    public void fight() {
        Random randomTeam = new Random();

        int rounds = 0;

        do {
            Hero h;
            // Рандомно выбираем команду
            switch(randomTeam.nextInt(TEAMS_QTY)){
                case 0:
                    h = team1.getNext();
                    if(h instanceof Doctor){
                        team1.healing(h);
                    }
                    else {
                        h.hit(team2.getNext());
                    }
                    break;
                default:
                    h = team2.getNext();
                    if(h instanceof Doctor){
                        team2.healing(h);
                    }
                    else {
                        h.hit(team1.getNext());
                    }
            }

            rounds++;
        }
        while (team1.isAnybodyLive() && team2.isAnybodyLive());

        team1.showResults();
        team2.showResults();

        logDbg((team1.isAnybodyLive() ? team1 : team2) + " won in " + rounds + " rounds");
    }
}
