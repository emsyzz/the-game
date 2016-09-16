package lv.autentica.factory;

import java.util.*;

import lv.autentica.models.Team;
import lv.autentica.util.RandomUtil;

public class TeamFactory
{

    private static final String[] TEAM_NAMES_1 =
            new String[] { "Rīgas", "Liepājas", "Daugavpils", "Jelgavas", "Saulkrastu", "Ventspils", "Valmieras" };

    private static final String[] TEAM_NAMES_2 =
            new String[] { "Eži", "Vilki", "Raķetes", "Degunradži", "Lodes", "Saule", "Ogļrači" };

    private static String getRandomUniqueTeamName(List<String> teamNames)
    {
        StringBuilder sb = new StringBuilder();

        while (teamNames.indexOf(sb.toString()) < 0) {
            sb.setLength(0);
            sb.append(RandomUtil.getRandomStringFromArray(TEAM_NAMES_1));
            sb.append(" "); // add whitespace to separate
            sb.append(RandomUtil.getRandomStringFromArray(TEAM_NAMES_2));
        }

        return sb.toString();
    }

    public static List<Team> generateRandomTeams(int teamCount)
    {
        List<Team> teams = new ArrayList<>();

        List<String> usedTeamNames = new ArrayList<>();

        String teamName;

        Team team;

        while (teamCount > 0) {
            team = new Team();
            teamName = getRandomUniqueTeamName(usedTeamNames);
            team.setName(teamName);
            teams.add(team);
            usedTeamNames.add(teamName);
            teamCount--;
        }

        return teams;
    }
}
