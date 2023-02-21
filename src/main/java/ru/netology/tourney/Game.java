package ru.netology.tourney;

import java.util.ArrayList;
import java.util.List;

import ru.netology.tourney.NotRegisteredException;


public class Game {
    List<Player> players = new ArrayList<Player>();

    public void register(Player player) {
        players.add(player);
    }

    public Player findPlayer(String name) {
        for (Player player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    public int round(String name1, String name2) {
        Player player1 = findPlayer(name1);
        Player player2 = findPlayer(name2);
        if (player1 == null) {
            throw new NotRegisteredException(
                    "Игрок " + name1 + " не зарегистрирован");
        }
        if (player2 == null) {
            throw new NotRegisteredException(
                    "Игрок " + name2 + " не зарегистрирован");
        }
        if (player1.getStrength() > player2.getStrength()) {
            return 1;
        }
        if (player1.getStrength() < player2.getStrength()) {
            return 2;
        }
        return 0;
    }
}

