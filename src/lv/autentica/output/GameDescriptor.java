package lv.autentica.output;

import lv.autentica.Game;
import lv.autentica.models.*;
import lv.autentica.util.SortingUtil;

import java.text.DecimalFormat;
import java.util.Map;

public class GameDescriptor
{
    private Game game;

    public GameDescriptor(Game game)
    {
        this.game = game;
    }

    private static String getTeamTitle(Team team)
    {
        DecimalFormat df = new DecimalFormat("#.#");
        String teamAvg = df.format(team.getOverallAverage());
        return team.getName() + " (Avg: " + teamAvg + ")";
    }

    private static String getPlayerTitle(Player player)
    {
        return player.getFullName() + " (" + player.getOverall() + ")";
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
        Map<String, Integer> sortedResults = SortingUtil.sortHashMap(this.game.getTeamsWithTotalScore());

        System.out.println("=== Result table (score) ===");
        displayMap(sortedResults);
    }

    public void describeResultsByWins()
    {
        Map<String, Integer> sortedResults = SortingUtil.sortHashMap(this.game.getTeamsWithTotalWins());

        System.out.println("=== Result table (wins) ===");
        displayMap(sortedResults);
    }
}
