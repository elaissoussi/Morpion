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

    public boolean win(int casesNumber) {
        System.out.println(plays);
        int dim = 3;
        boolean diagWin = testIfDiagonal(dim);
        boolean lign = testIflign(dim);
        boolean colonne = testIfColonne(dim);
        return diagWin || lign || colonne;
    }

    private boolean testIfColonne(int dim) {

        for (int j = 0; j < dim; j++) {
            List<Position> ligne = new ArrayList<Position>();
            for (int i = 0; i < dim; i++) {
                ligne.add(new Position(j, i));
            }
            if (plays.containsAll(ligne))
                return true;
        }

        return false;
    }

    private boolean testIflign(int dim) {

        for (int j = 0; j < dim; j++) {
            List<Position> ligne = new ArrayList<Position>();
            for (int i = 0; i < dim; i++) {
                ligne.add(new Position(i, j));
            }
            if (plays.containsAll(ligne))
                return true;
        }

        return false;
    }

    private boolean testIfDiagonal(int dim) {
        List<Position> diagonal = new ArrayList<Position>();
        for (int i = 0; i < dim; i++) {
            diagonal.add(new Position(i, i));
        }
        
        return plays.containsAll(diagonal);
    }

    public String printWinner() {
        return "Game Over, " + name + " is a winner";
    }
}
