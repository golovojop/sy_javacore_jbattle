package activity.interactor;

public interface Preparator {
    String commitCandidate(int teamId);
    void setCandidate(int teamId, int candidatId);
    boolean commandToFight();
    void reInit();
}
