package lv.autentica;

import lv.autentica.models.Team;

import java.util.HashMap;
import java.util.Map;

public class GameResult
{
    private Map<String, Team> teams = new HashMap<>();

    private Map<String, Integer> scores = new HashMap<>();

    public GameResult()
    {

    }

    public GameResult addTeam(String teamIdf, Team team)
    {
        this.teams.putIfAbsent(teamIdf, team);

        return this;
    }

    public GameResult addScore(String teamIdf, Integer score)
    {
        Team team = this.teams.get(teamIdf);

        if (null == team) {
            throw new IllegalStateException("Team with identifier '"+ teamIdf +"' is not preset in GameResult");
        }

        if (null != this.scores.putIfAbsent(teamIdf, score)) {
            this.scores.put(teamIdf, this.scores.get(teamIdf) + score);
        }

        return this;
    }
}
