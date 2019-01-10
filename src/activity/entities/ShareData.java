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
    public static final String CMD_REPEAT = "CMD_REPEAT";

    public static final int HEAL_MAX_WARRIOR = 250;
    public static final int HEAL_MAX_ASSASSIN = 190;
    public static final int HEAL_MAX_DOCTOR = 120;
    public static final int HEAL_RANGE = 50;

    public static final int DMG_MAX_WARRIOR = 70;
    public static final int DMG_MAX_ASSASSIN = 110;
    public static final int DMG_MAX_DOCTOR = 0;
    public static final int DMG_RANGE = 40;

    public static final int HEAL_INC_MAX = 30;
    public static final int HEAL_INC_MIN = 10;
    public static final int HEAL_INC_ZERO = 0;

    /**
     * Teams params
     */
    public static final int TEAM_SIZE = 3;
    public static final int TEAMS_QTY = 2;

    public static void logDbg(String msg) {
        showMessageDialog(null, msg);
    }
}
