import java.util.LinkedHashMap;

public class DefaultParser implements MorpionParser {

    @Override
    public int parseCasesNumber(String dimension) {
        int param1 = new Integer(dimension.charAt(0)+"");
        int param2 = new Integer(dimension.charAt(2)+"");
        return param1 * param2;
    }

    @Override
    public LinkedHashMap<String, Player> parsePlayers(String... playersInput) {
        LinkedHashMap<String, Player> players = new LinkedHashMap<String, Player>();
        for (int currentPlayerIndex = 0; currentPlayerIndex < playersInput.length; currentPlayerIndex++) {
            String playerName = playersInput[currentPlayerIndex].split(":")[0];
            String playerGameChar = playersInput[currentPlayerIndex].split(":")[1];
            Player player = new Player(playerName, playerGameChar);
            players.put(playerName, player);
        }
        return players;
    }

    @Override
    public Position parsePosition(String position) {
        int xPosition = new Integer(position.charAt(0));
        int yPosition = new Integer(position.charAt(2));
        return new Position(xPosition, yPosition);
    }

}
