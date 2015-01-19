import java.util.LinkedHashMap;

import org.hamcrest.Matcher;

public class Morpion {

    public static final String LINE_SEPARATOR = System.getProperty("line.separator");
    private int casesNumber;
    private LinkedHashMap<String, Player> players;

    public Morpion(String dimension, String player1Input, String player2Input) {
        MorpionParser parser = new DefaultParser();
        casesNumber = parser.parseCasesNumber(dimension);
        players = parser.parsePlayers(player1Input, player2Input);

    }

    public void play(String player, String position) {
        MorpionParser parser = new DefaultParser();
        Player currentPlayer = players.get(player);
        Position playPosition = parser.parsePosition(position);
        for (Player playerMorpin : players.values()) {
            if (playerMorpin.hasPlayedIn(playPosition))
                throw new BoxAlreadySelectedException();
        }
        currentPlayer.play(playPosition);
    }

    public String report() {

        MorpionPrinter printer = new DefaultPrinter();
        for (Player playerMorpin : players.values()) {
            if(playerMorpin.win(casesNumber)) return printer.reportWinner(playerMorpin);
        }
        return printer.reportRemaining(players, casesNumber);
    }

    public Matcher<String> display() {
        // TODO Auto-generated method stub
        return null;
    }

}
