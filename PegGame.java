import java.util.Collection;

public interface PegGame{
    Collection<Move> getPossibleMove();
    PegGameState getGameState();
    void makeMove(Move move) throws PegGameException;
}