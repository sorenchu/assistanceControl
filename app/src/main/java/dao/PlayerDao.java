package dao;

import java.util.ArrayList;

import model.Category;
import model.Player;

public class PlayerDao {

    public static ArrayList<Player> getPlayerByCategory(String category) {
        // TODO: this will end being a database query. For the time being, just returning made-up data
        switch (category) {
            case "Sub18":
                ArrayList<Player> playerList = new ArrayList<>();
                playerList.add(
                        new Player("Pepito", "Pérez", Category.U18)
                );
                playerList.add(
                        new Player("Antonio", "Torres", Category.U18)
                );
                playerList.add(
                        new Player("Manolito", "Márquez", Category.U18)
                );
                return playerList;
            case "Sub12":
            default:
                return null;
        }
    }
}
