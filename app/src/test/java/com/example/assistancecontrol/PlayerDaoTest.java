package com.example.assistancecontrol;

import org.junit.Test;

import java.util.ArrayList;

import dao.PlayerDao;
import model.Player;

import static model.Category.U16;
import static org.junit.Assert.*;

public class PlayerDaoTest {

    @Test
    public void addPlayerToCategoryWellForm() {
        Player player = new Player("Fernando", "Fernández", U16);
        ArrayList<Player> playerList = PlayerDao.getPlayerByCategory("Sub16");
        assertEquals(3, playerList.size());
        assertFalse(playerList.contains(player));
        PlayerDao.addPlayerToCategory(player);
        assertEquals(4, playerList.size());
        assertTrue(playerList.contains(player));
    }

    @Test
    public void addPlayerToCategoryBadForm() {
        Player player = new Player("Fernando", "Fernández", null);
        ArrayList<Player> playerList = PlayerDao.getPlayerByCategory("Sub16");
        assertEquals(3, playerList.size());
        assertFalse(playerList.contains(player));
        PlayerDao.addPlayerToCategory(player);
        assertEquals(3, playerList.size());
        assertFalse(playerList.contains(player));
    }
}
