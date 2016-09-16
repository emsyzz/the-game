package lv.autentica.game;

import lv.autentica.models.GameRound;
import lv.autentica.models.Team;

import java.util.List;

public interface GameRules
{
    List<GameRound> getGameResults(List<Team> teams);
}
