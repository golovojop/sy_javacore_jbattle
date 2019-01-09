package activity.interactor;

import java.util.ArrayList;
import java.util.List;

import activity.action.Battle;
import activity.entities.players.*;
import activity.presenter.Presenter;

import static activity.entities.ShareData.*;

public class TeamPreparator implements Preparator, TvShow {

    /**
     * Класс собирающий сведения о кандидатах в команду
     */
    private class DummyTeam {
        private int commandId;
        private int candidateId;
        private List<Integer> heroesId = new ArrayList<>();

        public DummyTeam(int id) {
            this.commandId = id;
            this.candidateId = 0 * TEAMS_QTY + this.commandId;
        }

        protected void setCandidateId(int candtId) {
            this.candidateId = candtId * TEAMS_QTY + this.commandId;
        }

        protected String addHero(){
            String result = null;

            try {
                if(heroesId.size() != TEAM_SIZE) {
                    heroesId.add(this.candidateId);
                    result = heroes[candidateId].getCapacity();
                }
                else throw new TeamIsFullException();
            }
            catch (TeamIsFullException e) {
                logDbg("Command \"Team " + (commandId + 1) + "\" is completed" );
            }
            return result;
        }

        public String toString() {
            return "Team " + commandId + 1;
        }

        public int getPretenders() {
            return heroesId.size();
        }

        public Team createTeam() {
            Hero[] hr = new Hero[heroesId.size()];

            try {
                for(int i = 0; i < hr.length; i++) {
                    hr[i] = (Hero)TeamPreparator.heroes[this.heroesId.get(i)].clone();
                    hr[i].setLiveCam(TeamPreparator.this);
                }
            }
            catch (CloneNotSupportedException e){
                logDbg("Can't clone player");
            }
            return new Team(commandId + 1, hr);
        }
    }

    /**
     * Персонажи
     */
    public static final Hero[] heroes = TeamHelper.genHeroes();

    /**
     * Массив подготовленных команд
     */
    private DummyTeam[] dummyteams;
    private Presenter presenter;

    public TeamPreparator(Presenter presenter, int qty) {
        this.presenter = presenter;

        dummyteams = new DummyTeam[qty];
        for(int i = 0; i < qty; i++){
            dummyteams[i] = new DummyTeam(i);
        }
    }

    @Override
    public String commitCandidate(int teamId) {

        return dummyteams[teamId].addHero();
    }

    @Override
    public void setCandidate(int teamId, int candidateId) {
        dummyteams[teamId].setCandidateId(candidateId);
    }

    @Override
    public void nextComment(String message) {
        presenter.nextComment(message);
    }

    @Override
    public boolean commandToFight() {
        Boolean result = false;

        try {
            for(DummyTeam dt : dummyteams) {
                if(dt.getPretenders() < TEAM_SIZE) throw new TeamIsNotFullException();
            }
            Battle battle = new Battle(dummyteams[0].createTeam(), dummyteams[1].createTeam(), this);
            battle.fight();
            result = true;
        }
        catch (TeamIsNotFullException e) {
            logDbg("Not enough players in one of the teams" );
        }
        return result;
    }
}
