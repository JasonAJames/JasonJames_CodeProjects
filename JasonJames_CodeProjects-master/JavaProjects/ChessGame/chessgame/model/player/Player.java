/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Player.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */
 

package chessgame.model.player;

import java.util.Collection;
import java.util.List;

import chessgame.model.Alliance;
import chessgame.model.board.Board;
import chessgame.model.board.Move;
import chessgame.model.board.MoveTransition;
import chessgame.model.piecesFactory.King;
import chessgame.model.piecesFactory.Piece;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import org.magicwerk.brownies.collections.GapList;


public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    private final boolean isInCheck;

    Player(final Board board,
           final Collection<Move> playerLegals,
           final Collection<Move> opponentLegals) {
        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = ImmutableList.copyOf(
                Iterables.concat(playerLegals, calculateKingCastles(playerLegals, opponentLegals)));
        this.isInCheck = !Player.calculateAttacksOnTile(this.getPlayerKing().getPiecePosition(), opponentLegals).isEmpty();
    }

    public boolean isMoveLegal(final Move move) {
        return !(move.isCastlingMove() && isInCheck()) && this.legalMoves.contains(move);
    }

    public boolean isInCheck() {
        return this.isInCheck && hasEscapeMoves();
    }

    public boolean isInCheckMate() {
        return (this.isInCheck && !hasEscapeMoves());
    }

    public boolean isInStaleMate() {
        
        return this.getOpponent().getLegalMoves().isEmpty() && !this.isInCheck;
    }

    public boolean isCastled() {
        return this.playerKing.isCastled();
    }

    public boolean isKingSideCastleCapable() {
        return this.playerKing.isKingSideCastleCapable();
    }

    public boolean isQueenSideCastleCapable() {
        return this.playerKing.isQueenSideCastleCapable();
    }

    public King getPlayerKing() {
        return this.playerKing;
    }
    
    public String playerInfo() {
        boolean isInCheck = isInCheck(), isInCheckMate = isInCheckMate(), isCastled = isCastled(), isInStaleMate = isInStaleMate();
        return ("\nThe " + this.getAlliance() + " Player:\nIs in Check = " +
                isInCheck_booleanToString(isInCheck) + "\nIs In Check Mate = " + isInCheckMate_booleanToString(isInCheckMate) +
                "\nIs in Stale Mate = " + isInStaleMate_booleanToString(isInStaleMate) +
                "\nIs Castled = " + isCastled_booleanToString(isCastled))+ "\n";

    }

    private String isInStaleMate_booleanToString(boolean isInStaleMate) {
        isInStaleMate = isInStaleMate();
        return isInStaleMate ? "Yes\nGAME OVER" : "No";
    }

    private String isInCheck_booleanToString(boolean isInCheck) {
        isInCheck = isInCheck();
        return isInCheck ? "Yes" : "No";
    }

    private String isInCheckMate_booleanToString(boolean isInCheckMate) {
        isInCheckMate = isInCheckMate();
        return isInCheckMate ? "Yes\nGAME OVER" : "No";
    }

    private String isCastled_booleanToString(boolean isCastled) {
        isCastled = isCastled();
        return isCastled ? "Yes" : "No";
    }

    protected King establishKing() {
        for (final Piece piece : getActivePieces()) {
            if (piece.getPieceType().isKing()) {
                return (King) piece;
            }
        }

       throw new RuntimeException("Oops... You should have never reached this point and never will!\nI guess if you did, I screwed the pooch!\nThe " + this.getAlliance() + " King could not be established.");

    }

    protected boolean hasEscapeMoves() {
        for(final Move move : getLegalMoves()) {
            final MoveTransition transition = makeMove(move);
            if (transition.getMoveStatus().isDone()) {
                return true;
            }
        }
        return false;
    }

    public Collection<Move> getLegalMoves() {
        return this.legalMoves;
    }

    public static Collection<Move> calculateAttacksOnTile(final int tile,
                                                          final Collection<Move> moves) {
        final List<Move> attackMoves = new GapList<>();
        for (final Move move : moves) {
            if (tile == move.getDestinationCoordinate()) {
                attackMoves.add(move);
            }
        }
        return ImmutableList.copyOf(attackMoves);
    }

    public MoveTransition makeMove(final Move move) {
        if (!isMoveLegal(move)) {
            return new MoveTransition(this.board, move, MoveStatus.ILLEGAL_MOVE);
        }
        final Board transitionedBoard = move.execute();
        final Collection<Move> kingAttacks = Player.calculateAttacksOnTile(
                transitionedBoard.currentPlayer().getOpponent().getPlayerKing().getPiecePosition(),
                transitionedBoard.currentPlayer().getLegalMoves());
        if (!kingAttacks.isEmpty()) {
            return new MoveTransition(this.board, move, MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        return new MoveTransition(transitionedBoard, move, MoveStatus.DONE);
    }

    public MoveTransition unMakeMove(final Move move) {
        return new MoveTransition(move.undo(), move, MoveStatus.DONE);
    }

    public abstract Collection<Piece> getActivePieces();
    public abstract Alliance getAlliance();
    public abstract Player getOpponent();
    protected abstract Collection<Move> calculateKingCastles(Collection<Move> playerLegals, Collection<Move> opponentLegals);

}
