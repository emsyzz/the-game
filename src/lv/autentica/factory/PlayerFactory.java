package lv.autentica.factory;

import lv.autentica.models.Player;
import lv.autentica.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class PlayerFactory
{

    private static final String[] PLAYER_FIRST_NAMES =
            new String[] { "Juris", "Janis", "Ilja", "Arturs", "Toms", "Ivars", "Sandis" };

    private static final String[] PLAYER_LAST_NAMES =
            new String[] { "Abols", "Zirnis", "Kalns", "Semjonovs", "Rumba", "Vagars", "Poga" };

    public static List<Player> generateRandomPlayers(int playerCount)
    {
        List<Player> players = new ArrayList<>();

        while (playerCount > 0) {
            Player player = new Player(
                RandomUtil.getRandomStringFromArray(PLAYER_FIRST_NAMES),
                RandomUtil.getRandomStringFromArray(PLAYER_LAST_NAMES),
                RandomUtil.randInt(60, 100)
            );
            players.add(player);
            playerCount--;
        }

        return players;
    }
}
