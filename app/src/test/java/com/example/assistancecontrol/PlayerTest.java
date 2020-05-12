package com.example.assistancecontrol;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Player;

import static org.junit.Assert.*;

public class PlayerTest {
    Player player;

    public void setUp() {
        this.player = new Player("John", "Doe", Category.U12);
    }

    @Test
    public void addPlayerToList() {
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertFalse(playerList.isEmpty());
        assertEquals(playerList.size(), 1);
        assertTrue(playerList.contains(player));
    }

}
