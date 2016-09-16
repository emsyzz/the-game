package lv.autentica;

import lv.autentica.factory.PlayerFactory;
import lv.autentica.factory.TeamFactory;
import lv.autentica.game.GameRules;
import lv.autentica.game.StandardGameRules;
import lv.autentica.models.Player;
import lv.autentica.models.Team;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int teamCount = 0;
        if (args.length > 0) {
            teamCount = Integer.parseInt(args[0]);
        }

        int playersInTeam = 0;
        if (args.length > 1) {
            playersInTeam = Integer.parseInt(args[1]);
        }

        List<Team> teams = TeamFactory.generateRandomTeams(teamCount);

        for (Team team : teams) {

            List<Player> players = PlayerFactory.generateRandomPlayers(playersInTeam);

            //noinspection Convert2streamapi
            for (Player player : players) {
                team.addPlayer(player);
            }
        }

        GameRules rules = new StandardGameRules();

        Game game = new Game(rules);

        game.addTeams(teams);

        GameDescriptor.describeTeams(game);

        game.play();

        //Game game = new StandardGameRules();

        //game.addTeams();

        //Game game = Game.generate(teamCount);

        //game.printTeamInfo();
        //game.play();
        //game.printResults();

	// write your code here
    }
}
