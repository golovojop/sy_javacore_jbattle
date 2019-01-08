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
        jta3.append(message + "\n");
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
        jfrm.setSize(800, 600);
        jfrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Team1 list selection
        jcbChoice1 = new JComboBox();
        // Формировать список кандидатов в команду 1 из общего массива героев
        for(int i = 0; i < TeamPreparator.heroes.length; i++){
            if(i % 2 == 0) jcbChoice1.addItem(TeamPreparator.heroes[i]);
        }
        jcbChoice1.addActionListener(handler);
        jcbChoice1.setActionCommand(CMD_OFFER_MEMBER_FOR_TEAM1);

        // Button Add1
        jbtnAdd1 = new JButton("Add to Team 1");
        jbtnAdd1.addActionListener(handler);
        jbtnAdd1.setActionCommand(CMD_COMMIT_MEMBER_TO_TEAM1);

        // Team2 list selection
        jcbChoice2 = new JComboBox();
        // Формировать список кандидатов в команду 2 из общего массива героев
        for(int i = 0; i < TeamPreparator.heroes.length; i++){
            if(i % 2 != 0) jcbChoice2.addItem(TeamPreparator.heroes[i]);
        }
        jcbChoice2.addActionListener(handler);
        jcbChoice2.setActionCommand(CMD_OFFER_MEMBER_FOR_TEAM2);

        // Button Add2
        jbtnAdd2 = new JButton("Add to Team 2");
        jbtnAdd2.addActionListener(handler);
        jbtnAdd2.setActionCommand(CMD_COMMIT_MEMBER_TO_TEAM2);

        // Team1 players
        jta1 = new JTextArea();
        jta1.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta1.setEditable(false);
        jta1.setColumns(10);
        jta1.setRows(5);
        jta1.setLineWrap(true);
        jta1.setWrapStyleWord(true);
        JScrollPane jsp1 = new JScrollPane(jta1);

        // Team2 players
        jta2 = new JTextArea();
        jta2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta2.setEditable(false);
        jta2.setColumns(10);
        jta2.setRows(5);
        jta2.setLineWrap(true);
        jta2.setWrapStyleWord(true);
        JScrollPane jsp2 = new JScrollPane(jta2);

        // Button "Start"
        jbtnStart = new JButton("Start");
        jbtnStart.addActionListener(handler);
        jbtnStart.setActionCommand(CMD_START_BATTLE);

        // Log TextArea
        jta3 = new JTextArea();
        jta3.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
        jta3.setEditable(false);
        jta3.setColumns(15);
        jta3.setRows(5);
        jta3.setLineWrap(true);
        jta3.setWrapStyleWord(true);
        JScrollPane jsp3 = new JScrollPane(jta3);

        // Set Constraints
        gbc.insets = new Insets(5, 5, 5, 5);
        addComponent(0, 0, 1, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jcbChoice1);
        addComponent(0, 1, 1, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jbtnAdd1);
        addComponent(0, 2, 1, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jcbChoice2);
        addComponent(0, 3, 1, 1, GridBagConstraints.NONE, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jbtnAdd2);
        addComponent(1, 0, 2, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jsp1);
        addComponent(1, 2, 2, 2, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jsp2);
        addComponent(3, 0, 1, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.CENTER, 0.0, 0.0, jfrm, jbtnStart);
        addComponent(3, 1, 3, 3, GridBagConstraints.HORIZONTAL, GridBagConstraints.NORTHWEST,0.0, 0.0, jfrm, jsp3);

        return jfrm;
    }

    private void addComponent (
            int gridy,
            int gridx,
            int gridwidth,
            int gridheight,
            int fill,
            int anchor,
            double weightx,
            double weighty,
            Container frame,
            Component component ) {
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.gridwidth = gridwidth;
        gbc.gridheight = gridheight;
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbl.setConstraints( component, gbc );
        frame.add( component );
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
