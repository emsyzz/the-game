package lv.autentica;

import lv.autentica.game.GameRules;
import lv.autentica.models.Player;
import lv.autentica.models.Team;

import java.util.*;
import java.util.stream.Collectors;

public class Game
{

    private List<Team> teams = new ArrayList<>();

    private List<GameResult> results;

    private GameRules rules;

    public Game(/*List<String> teams, List<HashMap<String, Object>> players*/) {
        /*this.teams = teams;
        this.players = players;
        for (String team : teams) {
            results.put(team, 0);
        }*/
    }

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

    public void printTeamInfo() {
        /*System.out.println("=== Teams info ===");
        for (Team team: teams) {
            System.out.println("== Info for team: " + team + " (" + getAverageTeamOverall(team) + ")");
            //noinspection Convert2streamapi
            for (Player player: team.getPlayers()) {
                System.out.println("  " + player.getFullName() + " (" + player.getOverall() + ")");
            }
        }*/
    }

    public void play()
    {
        this.results = this.rules.getGameResults(this.teams);
    }

    /*public void printResults() {
        Comparator<Map.Entry<String, Integer>> valueComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        Map<String, Integer> sortedResults = results.entrySet().stream().
                                             sorted(valueComparator).
                                             collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                                                            (e1, e2) -> e1, LinkedHashMap::new));

        System.out.println("=== Result table ===");
        for (Map.Entry<String, Integer> result : sortedResults.entrySet()) {
            System.out.println(result.getKey() + ": " + result.getValue());
        }
    }*/


}
