package com.example.assistancecontrol;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void addPlayerToList() {
        Player player = new Player();
        List<Player> playerList = new ArrayList<>();
        playerList.add(player);
        assertFalse(playerList.isEmpty());
        assertEquals(1, playerList.size());
        assertTrue(playerList.contains(player));
    }

    @Test
    public void getNameAndSurname() {
        Player player = new Player("John", "Doe", Category.U12);
        assertEquals(
                "John Doe",
                player.getNameAndSurname()
        );
    }

    @Test
    public void getSurnameAndName() {
        Player player = new Player("John", "Doe", Category.U12);
        assertEquals(
                "Doe, John",
                player.getSurnameAndName()
        );
    }

}
