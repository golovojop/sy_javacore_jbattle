package activity.presenter;

import activity.BattleWindow;
import activity.interactor.Preparator;
import activity.interactor.TeamsPreparation;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static activity.entities.ShareData.*;


public class EventHandler implements ActionListener /*, ListSelectionListener*/ {

    View mainWindow;
    Preparator preparator;

    public EventHandler(BattleWindow mainWindow) {
        this.mainWindow = mainWindow;
        preparator = new TeamsPreparation(TEAMS_QTY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String hero;

        switch (e.getActionCommand()) {
            case CMD_SELECTED_FOR_TEAM1:
                preparator.setCandidate(0, ((JComboBox) e.getSource()).getSelectedIndex());
                break;
            case CMD_SELECTED_FOR_TEAM2:
                preparator.setCandidate(1, ((JComboBox) e.getSource()).getSelectedIndex());
                break;
            case CMD_COMMIT_TO_TEAM1:
                hero = preparator.commitCandidate(0);
                if(hero != null) mainWindow.addTeam1Player(hero);
                break;
            case CMD_COMMIT_TO_TEAM2:
                hero = preparator.commitCandidate(1);
                if(hero != null) mainWindow.addTeam2Player(hero);
                break;
            case CMD_START_BATTLE:
                mainWindow.onStart(true);
                break;
        }

    }
//
//
//        if(e.getSource() instanceof JComboBox) {
//            switch (e.getActionCommand()) {
//                case CMD_SELECTED_FOR_TEAM1:
//                    preparator.setCandidate(0, ((JComboBox) e.getSource()).getSelectedIndex());
//                    break;
//                case CMD_SELECTED_FOR_TEAM2:
//                    preparator.setCandidate(0, ((JComboBox) e.getSource()).getSelectedIndex());
//                    break;
//            }
//        } else {
//            switch (e.getActionCommand()) {
//                case CMD_COMMIT_TO_TEAM1:
//                    hero = preparator.commitCandidate(0);
//                    if(hero != null) mainWindow.addTeam1Player(hero);
//                    break;
//                case CMD_COMMIT_TO_TEAM2:
//                    hero = preparator.commitCandidate(1);
//                    if(hero != null) mainWindow.addTeam1Player(hero);
//                    break;
//                case CMD_START_BATTLE:
//                    mainWindow.onStart(true);
//                    break;
//            }
//        }
//    }

}
