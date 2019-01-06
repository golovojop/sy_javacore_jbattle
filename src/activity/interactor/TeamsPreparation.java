package activity.presenter.interactor;

import activity.presenter.entities.players.*;

public class TeamsPreparation implements Preparator {

    public static final Hero[] heroes = {
            new Warrior(250, "Тигрил", 50, 0),
            new Warrior(290, "Минотавр", 60, 0),
            new Assassin(150, "Акали", 70, 0),
            new Assassin(160, "Джинкс", 90, 0),
            new Doctor(110, "Зои", 0, 80),
            new Doctor(120, "Жанна", 0, 60),
    };

    @Override
    public boolean addToTeam1(String name) {
        return false;
    }

    @Override
    public boolean addToTeam2(String name) {
        return false;
    }

    @Override
    public void lastSelectionTeam1(String name) {

    }
}
