package lv.autentica.output;

import lv.autentica.Game;
import lv.autentica.models.GameRound;
import lv.autentica.models.Player;
import lv.autentica.models.Team;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class GameDescriptor
{
    private Game game;

    public GameDescriptor(Game game)
    {
        this.game = game;
    }

    private static String getTeamTitle(Team team)
    {
        return team.getName() + " (Avg: " + team.getOverallAverage() + ")";
    }

    private static String getPlayerTitle(Player player)
    {
        return player.getFullName() + " (Avg: " + player.getOverall() + ")";
    }

    public void describeTeams()
    {
        System.out.println("=== Teams info ===");
        for (Team team: this.game.getTeams()) {
            System.out.println("== Info for team: " + getTeamTitle(team) + " ==");
            //noinspection Convert2streamapi
            for (Player player: team.getPlayers()) {
                System.out.println("  " + getPlayerTitle(player));
            }
        }
    }

    public void describeGameFlow()
    {
        System.out.println("\n=== Game started ===");

        for (GameRound result: this.game.getResults()) {
            System.out.println(
                    getTeamTitle(result.getTeamA()) + "  " + result.getTeamAScore() +
                    " : " +
                    result.getTeamBScore() + "  " + getTeamTitle(result.getTeamB())
            );
        }

        System.out.println("=== Game over ===\n");
    }

    private static Map<String, Integer> getSortedMap(Map<String, Integer> map)
    {
        Comparator<Map.Entry<String, Integer>> valueComparator = (e1, e2) -> e2.getValue().compareTo(e1.getValue());
        return map.entrySet().stream().sorted(valueComparator)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                                (e1, e2) -> e1, LinkedHashMap::new));
    }

    private static void displayMap(Map<String, Integer> map)
    {
        for (Map.Entry<String, Integer> result : map.entrySet()) {
            System.out.println(result.getKey() + ": " + result.getValue());
        }
    }

    public void describeResults()
    {
        this.describeResultsByScore();
        System.out.println();
        this.describeResultsByWins();
    }

    public void describeResultsByScore()
    {
        Map<String, Integer> sortedResults = getSortedMap(this.game.getTeamsWithTotalScore());

        System.out.println("=== Result table (score) ===");
        displayMap(sortedResults);
    }

    public void describeResultsByWins()
    {
        Map<String, Integer> sortedResults = getSortedMap(this.game.getTeamsWithTotalWins());

        System.out.println("=== Result table (wins) ===");
        displayMap(sortedResults);
    }
}
