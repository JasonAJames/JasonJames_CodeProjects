/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Pawn.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */
 

package chessgame.model.piecesFactory;

import java.util.Collection;
import java.util.List;

import chessgame.model.Alliance;
import chessgame.model.board.Board;
import chessgame.model.board.BoardUtils;
import chessgame.model.board.Move;
import chessgame.model.board.Move.PawnMove;
import chessgame.model.board.Move.PawnPromotion;
import chessgame.model.board.Move.PawnJumpMove;
import chessgame.model.board.Move.PawnAttackMove;
import chessgame.model.board.Move.PawnEnPassantAttack;
import com.google.common.collect.ImmutableList;
import org.magicwerk.brownies.collections.GapList;

public final class Pawn extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {8, 16, 7, 9};

    public Pawn(final Alliance allegiance,
                final int piecePosition) {
        super(PieceType.PAWN, allegiance, piecePosition, true);
    }

    public Pawn(final Alliance alliance,
                final int piecePosition,
                final boolean isFirstMove) {
        super(PieceType.PAWN, alliance, piecePosition, isFirstMove);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof Pawn && (super.equals(other));
    }

    @Override
    public int locationBonus() {
        return this.pieceAlliance.pawnBonus(this.piecePosition);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new GapList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate =
                    this.piecePosition + (this.pieceAlliance.getDirection() * currentCandidateOffset);
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }
            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                if (this.pieceAlliance.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                    legalMoves.add(new PawnPromotion(
                            new PawnMove(board, this, candidateDestinationCoordinate)));
                }
                else {
                    legalMoves.add(new PawnMove(board, this, candidateDestinationCoordinate));
                }
            }
            else if (currentCandidateOffset == 16 && this.isFirstMove() &&
                    ((BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceAlliance.isBlack()) ||
                            (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.pieceAlliance.isWhite()))) {
                final int behindCandidateDestinationCoordinate =
                        this.piecePosition + (this.pieceAlliance.getDirection() * 8);
                if (!board.getTile(candidateDestinationCoordinate).isTileOccupied() &&
                        !board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new PawnJumpMove(board, this, candidateDestinationCoordinate));
                }
            }
            else if (currentCandidateOffset == 7 &&
                    !((BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                            (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack()))) {

                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceAlliance != pieceOnCandidate.getPieceAllegiance()) {
                        if (this.pieceAlliance.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                            legalMoves.add(new PawnPromotion(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                        }
                        else {
                            legalMoves.add(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                        }
                    }
                }
                else if (board.getEnPassantPawn() != null) {
                    if(board.getEnPassantPawn().getPiecePosition() == (this.piecePosition + (this.pieceAlliance.getOppositeDirection()))) {
                        final Piece pieceOnCandidate = board.getEnPassantPawn();
                        if (this.pieceAlliance != pieceOnCandidate.getPieceAllegiance()) {
                            if (this.pieceAlliance.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                                legalMoves.add(new PawnPromotion(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                            }
                            else {
                                legalMoves.add(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                            }
                        }
                    }
                }
            }
            else if (currentCandidateOffset == 9 &&
                    !((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceAlliance.isWhite()) ||
                            (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceAlliance.isBlack()))) {

                if(board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    if (this.pieceAlliance !=
                            board.getTile(candidateDestinationCoordinate).getPiece().getPieceAllegiance()) {
                        if (this.pieceAlliance.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                            legalMoves.add(new PawnPromotion(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate,
                                            board.getTile(candidateDestinationCoordinate).getPiece())));
                        }
                        else {
                            legalMoves.add(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate,
                                            board.getTile(candidateDestinationCoordinate).getPiece()));
                        }
                    }
                }
                else if (board.getEnPassantPawn() != null) {
                    if(board.getEnPassantPawn().getPiecePosition() == (this.piecePosition - (this.pieceAlliance.getOppositeDirection()))) {
                        final Piece pieceOnCandidate = board.getEnPassantPawn();
                        if (this.pieceAlliance != pieceOnCandidate.getPieceAllegiance()) {
                            if (this.pieceAlliance.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                                legalMoves.add(new PawnPromotion(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                            }
                            else {
                                legalMoves.add(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                            }
                        }
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public int getPieceValue() {
        return this.pieceType.getPieceValue();
    }

    @Override
    public String toString() {
        return this.pieceType.toString();
    }

    @Override
    public Pawn movePiece(final Move move) {
        return PieceUtils.getMovedPawn(move);
    }

    public Piece getPromotionPiece() {
        return new Queen(this.pieceAlliance, this.piecePosition, false);
    }

}
