package ru.netology.tourney;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    Game game = new Game();

    Player player1 = new Player(1, "Петр", 300);
    Player player2 = new Player(22, "Степан", 100);
    Player player3 = new Player(333, "Колян", 250);
    Player player4 = new Player(4, "Виталий", 99);
    Player player5 = new Player(1055, "Игнат", 300);

    @Test
    public void compareStrengthPlayersIfBothAreUnregistered() {

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player2.getName(), player3.getName());
        });
    }

    @Test
    public void compareStrengthPlayersIfOneIsUnregistered() {
        game.register(player3);

        assertThrows(NotRegisteredException.class, () -> {
            game.round(player3.getName(), player1.getName());
        });
    }

    @Test
    public void comparePlayersWhenFirstIsStrongerThanSecond() {
        game.register(player1);
        game.register(player2);

        assertEquals(1, game.round(player1.getName(), player2.getName()));
    }

    @Test
    public void comparePlayersWhenFirstIsWeakerThanSecond() {
        game.register(player4);
        game.register(player5);

        assertEquals(2, game.round(player4.getName(), player5.getName()));
    }

    @Test
    public void comparePlayersOfEqualStrength() {
        game.register(player1);
        game.register(player5);

        assertEquals(0, game.round(player1.getName(), player5.getName()));
    }
}