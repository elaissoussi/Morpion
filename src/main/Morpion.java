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
        currentPlayer.play(parser.parsePosition(position));
    }

    public String report() {
     
        int playedGamesNumber=Player.calculateNumberOfPlayedGame(players);
        
        MorpionPrinter printer = new DefaultPrinter();
        return printer.reportRemaining(players,casesNumber);
    }

    public Matcher<String> display() {
        // TODO Auto-generated method stub
        return null;
    }

}
