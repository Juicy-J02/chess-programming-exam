package chess;

import java.util.ArrayList;
import java.util.Collection;

public class King {

    Collection<ChessMove> moveCalculator(ChessPiece piece, ChessBoard board, ChessPosition myPosition) {

        Collection<ChessMove> moves = new ArrayList<>();

        directional_move(piece, board, myPosition, 1, 0, moves);
        directional_move(piece, board, myPosition, -1, 0, moves);
        directional_move(piece, board, myPosition, 1, 1, moves);
        directional_move(piece, board, myPosition, -1, 1, moves);
        directional_move(piece, board, myPosition, 0, 1, moves);
        directional_move(piece, board, myPosition, 0, -1, moves);
        directional_move(piece, board, myPosition, 1, -1, moves);
        directional_move(piece, board, myPosition, -1, -1, moves);

        return moves;

    }

    void directional_move(ChessPiece piece, ChessBoard board, ChessPosition myPosition, int x, int y, Collection<ChessMove> moves) {

        int row = myPosition.getRow();
        int col = myPosition.getColumn();

        ChessMove move = new ChessMove(myPosition, new ChessPosition(row + x, col + y), null);

        if (board.validPosition(move.endposition) && (board.emptyPosition(move.endposition) || board.isEnemy(piece, move.endposition))) {
            moves.add(move);
        }
    }
}