/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: PieceUtils.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */


package chessgame.model.piecesFactory;

import chessgame.model.Alliance;
import chessgame.model.board.BoardUtils;
import chessgame.model.board.Move;
import com.google.common.collect.ImmutableTable;
import com.google.common.collect.Table;

public class PieceUtils {

    public static final Table<Alliance, Integer, Queen> ALL_POSSIBLE_QUEENS = PieceUtils.createAllPossibleMovedQueens();
    public static final Table<Alliance, Integer, Rook> ALL_POSSIBLE_ROOKS = PieceUtils.createAllPossibleMovedRooks();
    public static final Table<Alliance, Integer, Knight> ALL_POSSIBLE_KNIGHTS = PieceUtils.createAllPossibleMovedKnights();
    public static final Table<Alliance, Integer, Bishop> ALL_POSSIBLE_BISHOPS = PieceUtils.createAllPossibleMovedBishops();
    public static final Table<Alliance, Integer, Pawn> ALL_POSSIBLE_PAWNS = PieceUtils.createAllPossibleMovedPawns();

    private PieceUtils() {
        throw new RuntimeException("Not instantiable!");
    }

    static Pawn getMovedPawn(final Move move) {
        return PieceUtils.ALL_POSSIBLE_PAWNS.get(move.getMovedPiece().getPieceAllegiance(), move.getDestinationCoordinate());
    }

    static Knight getMovedKnight(final Move move) {
        return PieceUtils.ALL_POSSIBLE_KNIGHTS.get(move.getMovedPiece().getPieceAllegiance(), move.getDestinationCoordinate());
    }

    static Bishop getMovedBishop(final Move move) {
        return PieceUtils.ALL_POSSIBLE_BISHOPS.get(move.getMovedPiece().getPieceAllegiance(), move.getDestinationCoordinate());
    }

    static Rook getMovedRook(final Move move) {
        return PieceUtils.ALL_POSSIBLE_ROOKS.get(move.getMovedPiece().getPieceAllegiance(), move.getDestinationCoordinate());
    }

    static Queen getMovedQueen(final Move move) {
        return PieceUtils.ALL_POSSIBLE_QUEENS.get(move.getMovedPiece().getPieceAllegiance(), move.getDestinationCoordinate());
    }

    private static Table<Alliance, Integer, Pawn> createAllPossibleMovedPawns() {

        final ImmutableTable.Builder<Alliance, Integer, Pawn> pieces = ImmutableTable.builder();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.WHITE, i, new Pawn(Alliance.WHITE, i, false));
        }

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.BLACK, i, new Pawn(Alliance.BLACK, i, false));
        }

        return pieces.build();

    }

    private static Table<Alliance, Integer, Knight> createAllPossibleMovedKnights() {

        final ImmutableTable.Builder<Alliance, Integer, Knight> pieces = ImmutableTable.builder();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.WHITE, i, new Knight(Alliance.WHITE, i, false));
        }

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.BLACK, i, new Knight(Alliance.BLACK, i, false));
        }

        return pieces.build();

    }

    private static Table<Alliance, Integer, Bishop> createAllPossibleMovedBishops() {

        final ImmutableTable.Builder<Alliance, Integer, Bishop> pieces = ImmutableTable.builder();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.WHITE, i, new Bishop(Alliance.WHITE, i, false));
        }

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.BLACK, i, new Bishop(Alliance.BLACK, i, false));
        }

        return pieces.build();

    }

    private static Table<Alliance, Integer, Rook> createAllPossibleMovedRooks() {

        final ImmutableTable.Builder<Alliance, Integer, Rook> pieces = ImmutableTable.builder();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.WHITE, i, new Rook(Alliance.WHITE, i, false));
        }

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.BLACK, i, new Rook(Alliance.BLACK, i, false));
        }

        return pieces.build();

    }

    private static Table<Alliance, Integer, Queen> createAllPossibleMovedQueens() {

        final ImmutableTable.Builder<Alliance, Integer, Queen> pieces = ImmutableTable.builder();

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.WHITE, i, new Queen(Alliance.WHITE, i, false));
        }

        for(int i = 0; i < BoardUtils.NUM_TILES; i++) {
            pieces.put(Alliance.BLACK, i, new Queen(Alliance.BLACK, i, false));
        }

        return pieces.build();

    }

}
