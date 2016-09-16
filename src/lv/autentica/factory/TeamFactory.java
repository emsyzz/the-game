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
        List<String[]> strings = new ArrayList<>();
        strings.add(TEAM_NAMES_1);
        strings.add(TEAM_NAMES_2);
        String outName = "";
        int foundIndex = -1;

        while (outName.equals("") || foundIndex >= 0) {
            outName = RandomUtil.concatenateRandomStrings(strings);
            foundIndex = teamNames.indexOf(outName);
            if (foundIndex < 0) {
                teamNames.add(outName);
            }
        }

        return outName;
    }

    public static int getMaxTeams()
    {
        return TEAM_NAMES_1.length * TEAM_NAMES_2.length;
    }

    public static boolean isEnoughNamesForTeams(int teamCount)
    {
        return teamCount <= getMaxTeams();
    }

    public static List<Team> generateRandomTeams(int teamCount)
    {
        List<Team> teams = new ArrayList<>(teamCount);

        List<String> usedTeamNames = new ArrayList<>(teamCount);

        String teamName;

        Team team;

        while (teamCount > 0) {
            team = new Team();
            teamName = getRandomUniqueTeamName(usedTeamNames);
            team.setName(teamName);
            teams.add(team);
            teamCount--;
        }

        return teams;
    }
}
