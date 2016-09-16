package lv.autentica.game;

import lv.autentica.GameResult;
import lv.autentica.models.Team;

import java.util.ArrayList;
import java.util.List;

public class StandardGameRules implements GameRules
{
    public StandardGameRules()
    {

    }

    public List<GameResult> getGameResults(List<Team> teams)
    {
        List<GameResult> results = new ArrayList<>();

        System.out.println("=== Game started ===");
        for (int i = 0; i < teams.size(); i++) {
            for (int j = i+1; j < teams.size(); j++) {

                Team teamA = teams.get(i);
                Team teamB = teams.get(j);

                GameResult result = new GameResult();

                result.addTeam("teamA", teamA);
                result.addTeam("teamB", teamB);

                float teamAOverall = teamA.getOverall();
                float teamBOverall = teamB.getOverall();

                if (teamAOverall > teamBOverall) {
                    result.addScore("teamA", 2);
                    //addPointsToTeam(teamA, 2);

                    System.out.println(teamA + " (" + teamAOverall + ")  2 : 0 " + teamB + " (" + teamBOverall + ")");
                } else if (teamAOverall < teamBOverall) {
                    result.addScore("teamB", 2);
                    //addPointsToTeam(teamB, 2);

                    System.out.println(teamA + " (" + teamAOverall + ")  0 : 2 " + teamB + " (" + teamBOverall + ")");
                } else {
                    result.addScore("teamA", 1);
                    result.addScore("teamB", 1);
                    //addPointsToTeam(teamA, 1);
                    //addPointsToTeam(teamB, 1);

                    System.out.println(teamA + " (" + teamAOverall + ") 1 : 1 " + teamB + " (" + teamBOverall + ")");
                }

                results.add(result);
            }
        }
        System.out.println("=== Game over ===");

        return results;
    }

    private float getAverageTeamOverall(Team team) {
        /*int totalC = 0;
        float averageOverall = 0;
        for (HashMap<String, Object> player: players) {
            if (player.get("team") == team) {
                averageOverall = averageOverall + ((int) player.get("overall"));
                totalC++;
            }
        }
        averageOverall = averageOverall / totalC;*/
        return 1 / 2; //averageOverall;
    }

    /*private void addPointsToTeam(Team team, int score) {
        int totalScore = results.get(team);
        results.replace(team, totalScore + score);
    }*/
}
