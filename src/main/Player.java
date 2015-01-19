import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Player {

    private String name;
    private String gameChar;
    private List<Position> plays = new ArrayList<Position>();

    public Player(String playerName, String playerGameChar) {
        name = playerName;
        gameChar = playerGameChar;

    }

    public void play(Position position) {
        plays.add(position);
    }

    public static int calculateNumberOfPlayedGame(HashMap<String, Player> players) {
        Player[] playersArray = players.values().toArray(new Player[2]);
        int playedCases = playersArray[0].plays.size() + playersArray[1].plays.size();
        return playedCases;
    }

    public String print(int casesNumber) {
        return casesNumber + " games for " + name;
    }

    public int calculatePlays() {
        return plays.size();
    }

    public boolean hasPlayedIn(Position playPosition) {
        return plays.contains(playPosition);
    }
}
