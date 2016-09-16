package lv.autentica.game;

import lv.autentica.GameResult;
import lv.autentica.models.Team;

import java.util.List;

public interface GameRules
{
    List<GameResult> getGameResults(List<Team> teams);
}
