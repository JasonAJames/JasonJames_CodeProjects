/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Tile.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */


package chessgame.model.board;

import chessgame.model.piecesFactory.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoordinate;

    private static final Map<Integer, EmptyTile> EMPTY_TILES_ALL = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile>  createAllPossibleEmptyTiles() {

        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {

            emptyTileMap.put(i, new EmptyTile(i));

        }

        return ImmutableMap.copyOf(emptyTileMap);

    }

     public static Tile createTile(final int tileCoordinate, final Piece piece) {

        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_ALL.get(tileCoordinate);

    }

    public Tile(final int tileCoordinate) {

        this.tileCoordinate = tileCoordinate;

    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();

    public int getTileCoordinate() {
        return this.tileCoordinate;
    }

    public static final class EmptyTile extends Tile {

        EmptyTile(final int coordinate) {

            super(coordinate);

        }

        @Override
        public String toString() {
            return "-";
        }

        @Override
        public boolean isTileOccupied() {
            return false;
        }

        @Override
        public Piece getPiece() {
            return null;
        }

    }

    public static final class OccupiedTile extends Tile {

        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate, final Piece pieceOnTile) {

            super(tileCoordinate);
            this.pieceOnTile = pieceOnTile;

        }

        @Override
        public String toString() {
            return getPiece().getPieceAlliance().isBlack() ? getPiece().toString().toLowerCase() :
                    getPiece().toString();
        }

        @Override
        public boolean isTileOccupied() {
            return true;
        }

        @Override
        public Piece getPiece() {
            return this.pieceOnTile;
        }

    }

}
