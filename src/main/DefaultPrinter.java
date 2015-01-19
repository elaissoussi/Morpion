import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

public class DefaultPrinter implements MorpionPrinter {

    @Override
    public String reportRemaining(LinkedHashMap<String, Player> players, int casesNumber) {
        List<String> reports = new ArrayList<String>();
        int addedPlays = casesNumber;
        List<Player> playerList = new ArrayList<Player>();
        for (Player currentPlayer : players.values()) {
            addedPlays -= currentPlayer.calculatePlays();
            playerList.add(currentPlayer);
        }
        double emptyPlays = (double) addedPlays / 2;
        Player player1 = playerList.get(0);
        if ((int) emptyPlays == emptyPlays) {
            reports.add(player1.print((int) emptyPlays));
        } else {
            reports.add(player1.print((int) emptyPlays + 1));

        }
        Player player2 = playerList.get(1);
        reports.add(player2.print((int) emptyPlays));
        return String.join(", ", reports);
    }

    @Override
    public String reportWinner(Player playerMorpin) {
        // TODO Auto-generated method stub
        return playerMorpin.printWinner();
    }

    @Override
    public String reportEquality() {
       return "Game Over, equality";
        
    }
}
