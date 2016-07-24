/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Piece.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */


package chessgame.model.piecesFactory;

import chessgame.model.Alliance;
import chessgame.model.board.Board;
import chessgame.model.board.Move;

import java.util.Collection;

public abstract class Piece {

    protected final PieceType pieceType;
    protected final Alliance pieceAlliance;
    protected final int piecePosition;
    protected final boolean isFirstMove;
    private final int cachedHashCode;


    Piece(final PieceType pieceType, final Alliance pieceAlliance, final int piecePosition, final boolean isFirstMove) {

        this.pieceType = pieceType;
        this.pieceAlliance = pieceAlliance;
        this.piecePosition = piecePosition;
        this.isFirstMove = isFirstMove;
        this.cachedHashCode = computeHashCode();

    }

    private int computeHashCode() {
        int result = pieceType.hashCode();
        result = 31 * result + pieceAlliance.hashCode();
        result = 31 * result + piecePosition;
        result = 31 * result + (isFirstMove ? 1 : 0);
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if(this == other) {
            return true;
        }
        if(!(other instanceof Piece)) {
            return false;
        }
        final Piece otherPiece = (Piece) other;
        return piecePosition == otherPiece.getPiecePosition() && pieceType == otherPiece.getPieceType() &&
                pieceAlliance == otherPiece.getPieceAlliance() && isFirstMove == otherPiece.isFirstMove();
    }

    @Override
    public int hashCode() { return this.cachedHashCode; }

    public PieceType getPieceType() { return this.pieceType; }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public Alliance getPieceAlliance() {
        return this.pieceAlliance;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public int getPieceValue() { return this.pieceType.getPieceValue(); }

    public abstract int locationBonus();

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public abstract Piece movePiece(Move move);

    public Alliance getPieceAllegiance() {
        return this.pieceAlliance;
    }

    public enum PieceType {

        PAWN(100, "P") {
            @Override
            public boolean isPawn() { return true; }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        KNIGHT(300, "N") {

            @Override
            public boolean isPawn() { return false; }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        BISHOP(300, "B") {

            @Override
            public boolean isPawn() { return false; }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        ROOK(500, "R") {

            @Override
            public boolean isPawn() { return false; }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return true;
            }
        },
        QUEEN(900, "Q") {

            @Override
            public boolean isPawn() { return false; }

            @Override
            public boolean isKing() {
                return false;
            }

            @Override
            public boolean isRook() {
                return false;
            }
        },
        KING(10000, "K") {

            @Override
            public boolean isPawn() { return false; }

            @Override
            public boolean isKing() {
                return true;
            }

            @Override
            public boolean isRook() { return false; }

        };

        private int pieceValue;
        private String pieceName;

        PieceType (final int pieceValue, final String pieceName) {
            this.pieceValue = pieceValue;
            this.pieceName = pieceName;
        }

        @Override
        public String toString() {
            return this.pieceName;
        }

        public int getPieceValue() { return this.pieceValue; }

        public abstract boolean isPawn();

        public abstract boolean isKing();

        public abstract boolean isRook();

    }

}
