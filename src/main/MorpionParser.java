import java.util.LinkedHashMap;



public interface MorpionParser {

    int parseCasesNumber(String dimension);

    LinkedHashMap<String, Player> parsePlayers(String ... player1Input);

    Position parsePosition(String position);

}
