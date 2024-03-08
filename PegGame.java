import java.util.Collection;

public interface PegGame{
    Collection<Move> getPossibleMove();
    GameState getGameState();
    void makeMove(Move move) throws PegGameException;
}