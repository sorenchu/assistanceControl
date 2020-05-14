package dao;

import java.util.ArrayList;

import model.Category;
import model.Player;

public class PlayerDao {

    private static ArrayList<Player> sub18List = new ArrayList<Player>() {
        {
            add(new Player("Pepito", "Pérez", Category.U18));
            add(new Player("Antonio", "Torres", Category.U18));
            add(new Player("Manolito", "Márquez", Category.U18));
        }
    };

    private static ArrayList<Player> sub16List = new ArrayList<Player>() {
        {
            add(new Player("Paquito", "Parquet", Category.U16));
            add(new Player("Jorge", "Alessandro", Category.U16));
            add(new Player("Marc", "Márquez", Category.U16));
        }
    };

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
