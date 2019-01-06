package activity.interactor;

import java.util.ArrayList;
import java.util.List;

import activity.action.Battle;
import activity.entities.players.*;
import activity.presenter.Presenter;

import static activity.entities.ShareData.*;

public class TeamPreparator implements Preparator, TvShow {

    /**
     * Класс для сбора членов команды
     */
    private class DummyTeam {
        private String name;
        private int candidateId;
        private List<Hero> team = new ArrayList<>();

        public DummyTeam(String name) {
            this.name = name;
            this.candidateId = 0;
        }

        protected void setCandidateId(int candidateId) {
            this.candidateId = candidateId;
        }

        protected String addHero(){
            String result = null;

            try {
                if(team.size() != TEAM_SIZE) {
                    team.add((Hero) heroes[candidateId].clone());
                    result = heroes[candidateId].toString();
                }
                else throw new CommandFullException();
            }
            catch (CloneNotSupportedException e){
                logDbg("Can't clone player");
            }
            catch (CommandFullException e) {
                logDbg("Command \"" + name + "\" completed" );
            }

            return result;
        }

        public Hero[] getTeam() {
            return team.toArray(new Hero[team.size()]);
        }
    }

    /**
     * Персонажи
     */
    public static final Hero[] heroes = {
            new Warrior(250, "Тигрил", 50, 0),
            new Warrior(290, "Минотавр", 60, 0),
            new Assassin(150, "Акали", 70, 0),
            new Assassin(160, "Джинкс", 90, 0),
            new Doctor(110, "Зои", 0, 80),
            new Doctor(120, "Жанна", 0, 60),
    };

    /**
     * Массив подготовленных команд
     */
    private DummyTeam[] teams;
    private Presenter presenter;

    public TeamPreparator(Presenter presenter, int qty) {
        this.presenter = presenter;

        teams = new DummyTeam[qty];
        for(int i = 0; i < qty; i++){
            teams[i] = new DummyTeam("Team " + (i + 1));
        }
    }

    @Override
    public String commitCandidate(int teamId) {
        return teams[teamId].addHero();
    }

    @Override
    public void setCandidate(int teamId, int candidatId) {
        teams[teamId].setCandidateId(candidatId);
    }

    @Override
    public void nextComment(String message) {
        presenter.nextComment(message);
    }

    @Override
    public boolean commandToFight() {
        Boolean result = false;

        try {
            for(DummyTeam dt : teams) {
                if(dt.getTeam().length < TEAM_SIZE) throw new CommandNotFullException();
            }

            Battle battle = new Battle(teams[0].getTeam(), teams[1].getTeam(), this);
            battle.fight();
            result = true;
        }
        catch (CommandNotFullException e) {
            logDbg("Not enough players in the team" );
        }

        return result;




    }
}
