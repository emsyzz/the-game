package lv.autentica.game;

import lv.autentica.models.GameRound;
import lv.autentica.models.Team;

import java.util.ArrayList;
import java.util.List;

public class StandardGameRules implements GameRules
{
    public StandardGameRules()
    {

    }

    public List<GameRound> getGameResults(List<Team> teams)
    {
        List<GameRound> results = new ArrayList<>();

        for (int i = 0; i < teams.size(); i++) {
            for (int j = i+1; j < teams.size(); j++) {

                Team teamA = teams.get(i);
                Team teamB = teams.get(j);

                GameRound gameRound = new GameRound(teamA, teamB);

                float teamAOverall = teamA.getOverallAverage();
                float teamBOverall = teamB.getOverallAverage();

                if (teamAOverall > teamBOverall) {
                    gameRound.setTeamAScore(2);
                } else if (teamAOverall < teamBOverall) {
                    gameRound.setTeamBScore(2);
                } else {
                    gameRound.setTeamAScore(1);
                    gameRound.setTeamBScore(1);
                }

                results.add(gameRound);
            }
        }

        return results;
    }
}
