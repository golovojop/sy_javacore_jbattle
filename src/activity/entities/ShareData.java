/**
 * Materials
 *
 * TeaxArea borders
 * https://docs.oracle.com/javase/tutorial/uiswing/components/border.html#code
 *
 * JComboBox
 * http://www.java2s.com/Code/Java/Swing-JFC/Usingdropdownlists.htm
 */


package activity.presenter.entities;

public class ShareData {
    public static String[] team1 = {"Samuel", "Ronald", "Mike", "Rocky", "Garry"};
    public static String[] team2 = {"Don", "Boris", "Miguel", "Louis", "John"};

    /**
     * Action Commands
     */
    public static final String CMD_ADD_TO_TEAM1 = "CMD_ADD_TO_TEAM1";
    public static final String CMD_ADD_TO_TEAM2 = "CMD_ADD_TO_TEAM2";
    public static final String CMD_SELECTED_FOR_TEAM1 = "CMD_SELECTED_FOR_TEAM1";
    public static final String CMD_SELECTED_FOR_TEAM2 = "CMD_SELECTED_FOR_TEAM2";

    public static final String CMD_START_BATTLE = "CMD_START_BATTLE";

    public static void logDbg(String msg) {
        System.out.println(msg);
    }
}
