/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Queen.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */


package chessgame.model.piecesFactory;

import chessgame.model.Alliance;
import chessgame.model.board.Board;
import chessgame.model.board.BoardUtils;
import chessgame.model.board.Move;
import chessgame.model.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Queen extends Piece {

    private final static int[] CANDIDATE_MOVE_VECTOR_COORDINATES = { -9, -8, -7, -1, 1, 7, 8, 9 };

    public Queen(final Alliance pieceAlliance, final int piecePosition) {
        super(PieceType.QUEEN, pieceAlliance, piecePosition, true);
    }

    public Queen(final Alliance pieceAlliance,
                 final int piecePosition,
                 final boolean isFirstMove) {
        super(PieceType.QUEEN, pieceAlliance, piecePosition, isFirstMove);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {

        final List<Move> legalMoves = new ArrayList<>();

        for(final int candidateCoordinateOffset : CANDIDATE_MOVE_VECTOR_COORDINATES) {

            int candidateDestinationCoordinate = this.piecePosition;

            while (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {

                if (isFirstColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset) ||
                        isEighthColumnExclusion(candidateDestinationCoordinate, candidateCoordinateOffset)) {

                    break;

                }

                candidateDestinationCoordinate += candidateCoordinateOffset;
                if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                    final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);

                    if(!candidateDestinationTile.isTileOccupied()){

                        legalMoves.add(new Move.MajorMove(board, this, candidateDestinationCoordinate));

                    } else {

                        final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                        final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                        if(this.pieceAlliance != pieceAlliance) {

                            legalMoves.add(new Move.AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));

                        }

                        break;

                    }

                }

            }

        }

        return ImmutableList.copyOf(legalMoves);

    }

    @Override
    public int locationBonus() {
        return this.pieceAlliance.queenBonus(this.piecePosition);
    }

    @Override
    public Queen movePiece(final Move move) {
        return new Queen(move.getMovedPiece().getPieceAlliance(), move.getDestinationCoordinate());
    }

    @Override
    public String toString() {
        return PieceType.QUEEN.toString();
    }

    private static boolean isFirstColumnExclusion (final int currentPosition, final int candidateOffset) {

        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidateOffset == -1 || candidateOffset == -9 || candidateOffset == 7);

    }

    private static boolean isEighthColumnExclusion (final int currentPosition, final int candidateOffset) {

        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidateOffset == -7 || candidateOffset == 1 || candidateOffset == 9);

    }
}
