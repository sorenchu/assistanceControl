package dao;

import java.util.ArrayList;


import model.Player;

import static model.Category.*;

public class PlayerDao {

    private static ArrayList<Player> sub18List = new ArrayList<Player>() {
        {
            add(new Player("Pepito", "Pérez", U18));
            add(new Player("Antonio", "Torres", U18));
            add(new Player("Manolito", "Márquez", U18));
        }
    };

    private static ArrayList<Player> sub16List = new ArrayList<Player>() {
        {
            add(new Player("Paquito", "Parquet", U16));
            add(new Player("Jorge", "Alessandro", U16));
            add(new Player("Marc", "Márquez", U16));
        }
    };

    public static void addPlayerToCagetory(Player player) {
        // TODO: this will end being a database query. For the time being, just returning made-up data
        switch (player.getCategory()) {
            case U18:
                PlayerDao.sub18List.add(player);
                break;
            case U16:
                PlayerDao.sub16List.add(player);
            default:
                System.out.println("do nothing");
        }
    }

    public static ArrayList<Player> getPlayerByCategory(String category) {
        // TODO: this will end being a database query. For the time being, just returning made-up data
        switch (category) {
            case "Sub18":
                return PlayerDao.sub18List;
            case "Sub16":
                return PlayerDao.sub16List;
            case "Sub14":
            case "Sub12":
            case "Sub10":
            case "Sub8":
            case "Sub6":
            default:
                return null;
        }
    }
}
