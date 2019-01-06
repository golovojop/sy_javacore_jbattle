/**
 * Materials
 *
 * TeaxArea borders
 * https://docs.oracle.com/javase/tutorial/uiswing/components/border.html#code
 *
 * JComboBox
 * http://www.java2s.com/Code/Java/Swing-JFC/Usingdropdownlists.htm
 */
package activity.entities;

import static javax.swing.JOptionPane.*;


public class ShareData {
    /**
     * Action Commands
     */
    public static final String CMD_OFFER_MEMBER_FOR_TEAM1 = "CMD_OFFER_MEMBER_FOR_TEAM1";
    public static final String CMD_OFFER_MEMBER_FOR_TEAM2 = "CMD_OFFER_MEMBER_FOR_TEAM2";
    public static final String CMD_COMMIT_MEMBER_TO_TEAM1 = "CMD_COMMIT_MEMBER_TO_TEAM1";
    public static final String CMD_COMMIT_MEMBER_TO_TEAM2 = "CMD_COMMIT_MEMBER_TO_TEAM2";
    public static final String CMD_START_BATTLE = "CMD_START_BATTLE";

    /**
     * Teams params
     */
    public static final int TEAM_SIZE = 3;
    public static final int TEAMS_QTY = 2;

    public static void logDbg(String msg) {
        showMessageDialog(null, msg);
//        System.out.println(msg);
    }
}
