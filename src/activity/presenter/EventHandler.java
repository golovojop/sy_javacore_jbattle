package activity.presenter;

import activity.BattleWindow;
import activity.presenter.interactor.Preparator;
import activity.presenter.interactor.TeamsPreparation;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static activity.presenter.entities.ShareData.*;


public class EventHandler implements ActionListener /*, ListSelectionListener*/ {

    View mainWindow;
    Preparator preparator;

    public EventHandler(BattleWindow mainWindow) {
        this.mainWindow = mainWindow;
        preparator = new TeamsPreparation();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String tmp;

        switch (e.getActionCommand()) {
            case CMD_ADD_TO_TEAM1:
                break;
            case CMD_ADD_TO_TEAM2:
                break;
            case CMD_START_BATTLE:
                mainWindow.onStart(true);
                break;
            case CMD_SELECTED_FOR_TEAM1:
                //mainWindow.addTeam1Player(((JComboBox) e.getSource()).getSelectedItem().toString());
                tmp = TeamsPreparation.heroes[((JComboBox) e.getSource()).getSelectedIndex()].getCapacity();
                mainWindow.addTeam1Player(tmp);
                break;
            case CMD_SELECTED_FOR_TEAM2:
                tmp = TeamsPreparation.heroes[((JComboBox) e.getSource()).getSelectedIndex()].getCapacity();
                mainWindow.addTeam1Player(tmp);
                break;
        }
    }

//    @Override
//    public void valueChanged(ListSelectionEvent e) {
//
//    }
}
