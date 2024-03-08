import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SquareBoardGame implements PegGame {

    private int size;
    private char[][] board;
    private int counter;

    public SquareBoardGame(int size, char[][] board) {
        this.size = size;
        this.board = board;
    }
// Returns the size of the board
    public int getSize() {
        return size;
    }

    public char[][] getBoard() {
        return board;
    }
    public void makeMove(Move move) throws PegGameException {
        int row1 = move.getFrom().getRow();
        int col1 = move.getFrom().getCol();
        int row2 = move.getTo().getRow();
        int col2 = move.getTo().getCol();

        validateMove(move);

        board[row1][col1] = '-';
        board[row2][col2] = 'o';
        board[(row1 + row2) / 2][(col1 + col2) / 2] = '-';

        counter++;
    }
    // Implementation of the getPossibleMove method from the PegGame interface
    @Override
    public Collection<Move> getPossibleMove() {
        List<Move> possibleMoves = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 'o') {
                    changeMove(possibleMoves, i, j, 0, 2);
                    changeMove(possibleMoves, i, j, 0, -2);
                    changeMove(possibleMoves, i, j, 2, 0);
                    changeMove(possibleMoves, i, j, -2, 0);
                    changeMove(possibleMoves, i, j, 2, 2);
                    changeMove(possibleMoves, i, j, 2, -2);
                    changeMove(possibleMoves, i, j, -2, 2);
                    changeMove(possibleMoves, i, j, -2, -2);
                }
            }
        }

        return possibleMoves;
    }

    private void changeMove(List<Move> possibleMoves, int i, int j, int row, int col) {
        int newRow = i + row;
        int newCol = j + col;

        if (isValidPosition(newRow, newCol) && board[newRow][newCol] == '-' && board[i + row / 2][j + col / 2] == 'o') {
            possibleMoves.add(new Move(new Location(i, j), new Location(newRow, newCol)));
        }
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < size && col >= 0 && col < size;
    }

    public static Move moveMaker(int r1, int c1, int r2, int c2) {
        return new Move(new Location(r1, c1), new Location(r2, c2));
    }

    

    private void validateMove(Move move) throws PegGameException {
        Collection<Move> possibleMoves = getPossibleMove();
        if (!possibleMoves.contains(move)) {
            throw new PegGameException("Invalid move!");
        }
    }

    public boolean hasMoved() {
        return counter > 0;
    }

    public PegGameState getGameState() {
        int Count = countPegs();
        if (!hasMoved()) {
            return PegGameState.NOT_STARTED;
        } else if (Count > 1) {
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (getPossibleMove().size() != 0) {
                        return PegGameState.IN_PROGRESS;
                    }
                }
            }
            return PegGameState.STALEMATE;
        } else if (Count == 1) {
            return PegGameState.WON;
        }
        return null;
    }

    private int countPegs() {
        int Count = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] == 'o') {
                    Count++;
                }
            }
        }
        return Count;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                result.append(board[i][j]);
                if (j < size - 1) {
                    result.append(" ");
                }
            }
            result.append("\n");
        }
        return result.toString();
    }
}
