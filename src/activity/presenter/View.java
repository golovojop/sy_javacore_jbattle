package activity.presenter;

public interface View {
    void addTeam1Player(String player);
    void addTeam2Player(String player);
    void logIt(String message);
    void onStart(Boolean state);
    void onReset();
}
