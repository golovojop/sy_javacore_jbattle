package activity;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EtchedBorder;
import activity.presenter.EventHandler;
import activity.presenter.View;
import activity.entities.players.Hero;
import activity.interactor.*;
import static activity.entities.ShareData.*;

public class BattleWindow implements View {

    /**
     * View components
     */
    private GridBagLayout gbl;
    private GridBagConstraints gbc;
    private JLabel jlabTeam1;
    private JComboBox jcbChoice1, jcbChoice2;
    private JButton jbtnAdd1, jbtnAdd2, jbtnStart;
    private JTextArea jta1, jta2, jta3;
    private EventHandler handler;

    public BattleWindow() {
        handler = new EventHandler(this);
        initViews(new JFrame("Play the game")).setVisible(true);
    }

    @Override
    public void addTeam1Player(String player) {
        jta1.append(player + "\n");
    }

    @Override
    public void addTeam2Player(String player) {
        jta2.append(player + "\n");
    }

    @Override
    public void logIt(String message) {

    }

    @Override
    public void onStart(Boolean inGame) {
        jbtnAdd1.setEnabled(!inGame);
        jbtnAdd2.setEnabled(!inGame);
        jbtnStart.setEnabled(!inGame);
    }

    /**
     * TODO: Init view components
     */
    private JFrame initViews(JFrame jfrm){
        gbl = new GridBagLayout();
        gbc = new GridBagConstraints();

        jfrm.setLayout(gbl);
        jfrm.setSize(600, 450);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set Constraints
        gbc.anchor = GridBagConstraints.NORTHWEST;
        gbc.fill   = GridBagConstraints.NONE;
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridheight = 1;
        gbc.gridwidth  = 1;
        gbc.ipadx = 0;
        gbc.ipady = 0;
        gbc.weightx = 0.0;
        gbc.weighty = 0.0;

        // Team1 list selection
        jcbChoice1 = new JComboBox();
        for(Hero hero : TeamsPreparation.heroes) {
            jcbChoice1.addItem(hero);
        }
        jcbChoice1.addActionListener(handler);
        jcbChoice1.setActionCommand(CMD_SELECTED_FOR_TEAM1);
        gbc.gridy = 0;                    // Номер строки
        gbc.gridx = 0;                    // Номер столбца
        gbl.setConstraints(jcbChoice1, gbc);
        jfrm.add(jcbChoice1);

        // Button Add1
        jbtnAdd1 = new JButton("Add to Team 1");
        jbtnAdd1.addActionListener(handler);
        jbtnAdd1.setActionCommand(CMD_COMMIT_TO_TEAM1);
        gbc.gridy = 0;
        gbc.gridx = 1;
        gbl.setConstraints(jbtnAdd1, gbc);
        jfrm.add(jbtnAdd1);

        // Team2 list selection
        jcbChoice2 = new JComboBox();
        for(Hero hero : TeamsPreparation.heroes) {
            jcbChoice2.addItem(hero);
        }
        //for(String s: team2) jcbChoice2.addItem(s);
        jcbChoice2.addActionListener(handler);
        jcbChoice2.setActionCommand(CMD_SELECTED_FOR_TEAM2);
        gbc.gridy = 0;                    // Номер строки
        gbc.gridx = 2;                    // Номер столбца
        gbl.setConstraints(jcbChoice2, gbc);
        jfrm.add(jcbChoice2);

        // Button Add2
        jbtnAdd2 = new JButton("Add to Team 2");
        jbtnAdd2.addActionListener(handler);
        jbtnAdd2.setActionCommand(CMD_COMMIT_TO_TEAM2);
        gbc.gridy = 0;                    // Номер строки
        gbc.gridx = 3;                    // Номер столбца
        gbl.setConstraints(jbtnAdd2, gbc);
        jfrm.add(jbtnAdd2);

        jta1 = new JTextArea();
        jta1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta1.setEditable(false);
        jta1.setColumns(10);
        jta1.setRows(5);
        jta1.setLineWrap(true);
        jta1.setWrapStyleWord(true);
        JScrollPane jsp1 = new JScrollPane(jta1);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;                    // Номер строки
        gbc.gridx = 0;                    // Номер столбца
        gbc.gridwidth  = 2;
        gbl.setConstraints(jsp1, gbc);
        jfrm.add(jsp1);

        jta2 = new JTextArea();
        jta2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta2.setEditable(false);
        jta2.setColumns(10);
        jta2.setRows(5);
        jta2.setLineWrap(true);
        jta2.setWrapStyleWord(true);
        JScrollPane jsp2 = new JScrollPane(jta2);
        gbc.fill   = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 1;                    // Номер строки
        gbc.gridx = 2;                    // Номер столбца
        gbc.gridwidth  = 2;
        gbl.setConstraints(jsp2, gbc);
        jfrm.add(jsp2);

        // Button Down
        jbtnStart = new JButton("Start");
        jbtnStart.addActionListener(handler);
        jbtnStart.setActionCommand(CMD_START_BATTLE);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridy = 2;
        gbc.gridx = 0;
        gbc.gridwidth  = 1;
        gbl.setConstraints(jbtnStart, gbc);
        jfrm.add(jbtnStart);

        jta3 = new JTextArea();
        gbc.anchor = GridBagConstraints.NORTHEAST;
        jta3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta3.setEditable(false);
        jta3.setColumns(20);
        jta3.setRows(5);
        jta3.setLineWrap(true);
        jta3.setWrapStyleWord(true);
        JScrollPane jsp3 = new JScrollPane(jta3);
        gbc.gridy = 2;                    // Номер строки
        gbc.gridx = 1;                    // Номер столбца
        gbc.gridwidth  = 3;
        gbl.setConstraints(jsp3, gbc);
        jfrm.add(jsp3);

        return jfrm;
    }

    /**
     * Start Battle Window
     */
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new BattleWindow();
            }
        });
    }
}
