package lv.autentica;

import lv.autentica.factory.PlayerFactory;
import lv.autentica.factory.TeamFactory;
import lv.autentica.game.GameRules;
import lv.autentica.game.StandardGameRules;
import lv.autentica.models.Player;
import lv.autentica.models.Team;
import lv.autentica.output.GameDescriptor;

import java.util.*;

public class Main
{
    public static void main(String[] args)
    {
        int teamCount = 8;
        if (args.length > 0) {
            teamCount = Integer.parseInt(args[0]);
        }

        int playersInTeam = 5;
        if (args.length > 1) {
            playersInTeam = Integer.parseInt(args[1]);
        }

        if (teamCount < 2) {
            System.out.println("There must be at least 2 teams");
        } else if (playersInTeam <= 0) {
            System.out.println("There must be at least 1 player in team");
        } else if (!TeamFactory.isEnoughNamesForTeams(teamCount)) {
            System.out.println("Too much teams requested. Not enough names. Max teams: "+ TeamFactory.getMaxTeams());
        } else {
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
            GameDescriptor descriptor = new GameDescriptor(game);

            game.addTeams(teams);

            game.play();

            descriptor.describeTeams();
            descriptor.describeGameFlow();
            descriptor.describeResults();
        }

    }
}
