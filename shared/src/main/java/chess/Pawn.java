package chess;

import java.util.ArrayList;
import java.util.Collection;

public class Pawn {

    Collection<ChessMove> moveCalculator(ChessPiece piece, ChessBoard board, ChessPosition myPosition) {

        Collection<ChessMove> moves = new ArrayList<>();

        int row = myPosition.getRow();
        int col = myPosition.getColumn();
        int direction;
        if (piece.getTeamColor() == ChessGame.TeamColor.WHITE) {
            direction = 1;
        } else {
            direction = -1;
        }

        ChessMove move_1 = new ChessMove(myPosition, new ChessPosition(row + direction, col), null);
        ChessMove move_2 = new ChessMove(myPosition, new ChessPosition(row + (direction * 2), col), null);
        ChessMove move_3 = new ChessMove(myPosition, new ChessPosition(row + direction, col + 1), null);
        ChessMove move_4 = new ChessMove(myPosition, new ChessPosition(row + direction, col - 1), null);

        if (board.validPosition(move_1.endposition) && board.emptyPosition(move_1.endposition)) {
            if ((piece.getTeamColor() == ChessGame.TeamColor.WHITE && move_1.endposition.getRow() == 8) ||
                    (piece.getTeamColor() == ChessGame.TeamColor.BLACK && move_1.endposition.getRow() == 1)) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col), ChessPiece.PieceType.ROOK));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col), ChessPiece.PieceType.KNIGHT));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col), ChessPiece.PieceType.BISHOP));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col), ChessPiece.PieceType.QUEEN));
            }
            else {
                moves.add(move_1);
            }
        }

        if (board.validPosition(move_2.endposition) && (board.emptyPosition(move_1.endposition) &&
                board.emptyPosition(move_2.endposition)) &&
                ((piece.getTeamColor() == ChessGame.TeamColor.WHITE && row == 2) ||
                (piece.getTeamColor() == ChessGame.TeamColor.BLACK && row == 7))) {
            moves.add(move_2);
        }

        if (board.validPosition(move_3.endposition) && board.isEnemy(piece, move_3.endposition)) {
            if ((piece.getTeamColor() == ChessGame.TeamColor.WHITE && move_3.endposition.getRow() == 8) ||
                    (piece.getTeamColor() == ChessGame.TeamColor.BLACK && move_3.endposition.getRow() == 1)) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col + 1), ChessPiece.PieceType.ROOK));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col + 1), ChessPiece.PieceType.KNIGHT));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col + 1), ChessPiece.PieceType.BISHOP));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col + 1), ChessPiece.PieceType.QUEEN));
            }
            else {
                moves.add(move_3);
            }
        }

        if (board.validPosition(move_4.endposition) && board.isEnemy(piece, move_4.endposition)) {
            if ((piece.getTeamColor() == ChessGame.TeamColor.WHITE && move_4.endposition.getRow() == 8) ||
                    (piece.getTeamColor() == ChessGame.TeamColor.BLACK && move_4.endposition.getRow() == 1)) {
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col - 1), ChessPiece.PieceType.ROOK));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col - 1), ChessPiece.PieceType.KNIGHT));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col - 1), ChessPiece.PieceType.BISHOP));
                moves.add(new ChessMove(myPosition, new ChessPosition(row + direction, col - 1), ChessPiece.PieceType.QUEEN));
            }
            else {
                moves.add(move_4);
            }
        }

        return moves;

    }

}
