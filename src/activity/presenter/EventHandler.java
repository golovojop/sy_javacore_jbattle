package activity.presenter;

import activity.BattleWindow;
import activity.interactor.Preparator;
import activity.interactor.TeamPreparator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static activity.entities.ShareData.*;


public class EventHandler implements Presenter, ActionListener  {

    View mainWindow;
    Preparator preparator;

    public EventHandler(BattleWindow mainWindow) {
        this.mainWindow = mainWindow;
        preparator = new TeamPreparator(this, TEAMS_QTY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hero;

        switch (e.getActionCommand()) {
            case CMD_OFFER_MEMBER_FOR_TEAM1:
                preparator.setCandidate(0, ((JComboBox) e.getSource()).getSelectedIndex());
                break;
            case CMD_OFFER_MEMBER_FOR_TEAM2:
                preparator.setCandidate(1, ((JComboBox) e.getSource()).getSelectedIndex());
                break;
            case CMD_COMMIT_MEMBER_TO_TEAM1:
                hero = preparator.commitCandidate(0);
                if(hero != null) mainWindow.addTeam1Player(hero);
                break;
            case CMD_COMMIT_MEMBER_TO_TEAM2:
                hero = preparator.commitCandidate(1);
                if(hero != null) mainWindow.addTeam2Player(hero);
                break;
            case CMD_START_BATTLE:
                mainWindow.onStart(preparator.commandToFight());
                //preparator.commandToFight();
                break;
        }
    }

    @Override
    public void nextComment(String message) {
        mainWindow.logIt(message);
    }
}
