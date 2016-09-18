package lv.autentica.models;

public class GameRound
{

    private Team teamA;
    private Team teamB;

    private Integer teamAScore = 0;
    private Integer teamBScore = 0;

    public GameRound(Team teamA, Team teamB)
    {
        this.teamA = teamA;
        this.teamB = teamB;
    }


    public Team getTeamA()
    {
        return teamA;
    }

    public Team getTeamB()
    {
        return teamB;
    }

    public Integer getTeamAScore()
    {
        return teamAScore;
    }

    public void setTeamAScore(Integer teamAScore)
    {
        this.teamAScore = teamAScore;
    }

    public Integer getTeamBScore()
    {
        return teamBScore;
    }

    public void setTeamBScore(Integer teamBScore)
    {
        this.teamBScore = teamBScore;
    }
}
