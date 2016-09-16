package lv.autentica;

import lv.autentica.game.GameRules;
import lv.autentica.models.GameRound;
import lv.autentica.models.Team;

import java.util.*;

public class Game
{

    private List<Team> teams = new ArrayList<>();

    private List<GameRound> results;

    private GameRules rules;

    public Game(GameRules rules) {
        this.rules = rules;
    }

    public Game addTeams(List<Team> teams)
    {
        this.teams = teams;

        return this;
    }

    public List<Team> getTeams()
    {
        return this.teams;
    }

    public List<GameRound> getResults()
    {
        return this.results;
    }

    private static void setTeamResultMap(Map<String, Integer> map, Team team, Integer score)
    {
        if (null != map.putIfAbsent(team.getName(), score)) {
            map.replace(team.getName(), map.get(team.getName()) + score);
        }
    }

    public Map<String, Integer> getTeamsWithTotalWins()
    {
        Map<String, Integer> winMap = new HashMap<>();

        if (this.results.size() > 0) {
            for (GameRound round: this.results) {
                setTeamResultMap(winMap, round.getTeamA(), 0);
                setTeamResultMap(winMap, round.getTeamB(), 0);
                if (round.getTeamAScore() > round.getTeamBScore()) {
                    setTeamResultMap(winMap, round.getTeamA(), 1);
                } else if (round.getTeamAScore() < round.getTeamBScore()) {
                    setTeamResultMap(winMap, round.getTeamB(), 1);
                }
            }
        }

        return winMap;
    }

    public Map<String, Integer> getTeamsWithTotalScore()
    {
        Map<String, Integer> scoreMap = new HashMap<>();

        if (this.results.size() > 0) {
            for (GameRound round: this.results) {
                setTeamResultMap(scoreMap, round.getTeamA(), round.getTeamAScore());
                setTeamResultMap(scoreMap, round.getTeamB(), round.getTeamBScore());
            }
        }

        return scoreMap;
    }

    public void play()
    {
        this.results = this.rules.getGameResults(this.teams);
    }

}
