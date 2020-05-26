package com.example.assistancecontrol;

import org.junit.Test;

import model.Category;
import model.Player;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getNameAndSurname() {
        Player player = new Player("John", "Doe", Category.U12);
        assertEquals(
                "patata patata",
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
