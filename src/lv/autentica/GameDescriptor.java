package lv.autentica;

import lv.autentica.models.Player;
import lv.autentica.models.Team;

public class GameDescriptor
{
    public static void describeTeams(Game game)
    {
        System.out.println("=== Teams info ===");
        for (Team team: game.getTeams()) {
            System.out.println("== Info for team: " + team + " (" + team.getOverall() + ")");
            //noinspection Convert2streamapi
            for (Player player: team.getPlayers()) {
                System.out.println("  " + player.getFullName() + " (" + player.getOverall() + ")");
            }
        }
    }

    public static void describeResults(Game game)
    {

    }
}
