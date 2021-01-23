package me.simzahn.minecraftdays.util;

public class Team {

    private TeamColor color;
    private String player1;
    private String player2;

    public Team(TeamColor color, String player1, String player2) {
        this.color = color;
        this.player1 = player1;
        this.player2 = player2;
    }

    public TeamColor getColor() {
        return color;
    }

    public String getPlayer1() {
        return player1;
    }

    public String getPlayer2() {
        return player2;
    }
}
