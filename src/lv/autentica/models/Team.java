package lv.autentica.models;

import java.util.*;

public class Team
{
    private String name;

    private List<Player> players = new ArrayList<>();

    public Team setName(String name)
    {
        this.name = name;

        return this;
    }

    public String getName()
    {
        return this.name;
    }

    public Team addPlayer(Player player)
    {
        this.players.add(player);

        return this;
    }

    public List<Player> getPlayers()
    {
        return this.players;
    }

    public float getOverall()
    {
        float overall = 0;

        if (!this.players.isEmpty()) {
            for (Player player: this.players) {
                overall += player.getOverall();
            }
        }

        return overall;
    }

    public float getOverallAverage()
    {
        float overall = this.getOverall();
        int playerCount = this.players.size();

        if (playerCount == 0) {
            return 0;
        }

        return overall / playerCount;
    }

}
