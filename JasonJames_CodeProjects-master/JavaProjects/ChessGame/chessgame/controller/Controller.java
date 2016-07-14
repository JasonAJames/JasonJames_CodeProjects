/**
 * Attachments: Table.java, Alliance.java, Player.java, BlackPlayer.java, WhitePlayer.java, MoveStatus.java,
 * Piece.java, PieceUtils.java, Bishop.java, King.java, Knight.java, Pawn.java, Queen.java, Rook.java, Board.java, Boardutils.java,
 * Move.java, MoveTransition.java, Tile.java, Controller.java, JavaChessGameRunner.java, folder: images, guava-19.0jar, brownies-collections-0.9.4.jar
 * File: Controller.java
 * @author JasonJames
 * Description: (Chess Game)
 * Date: 6/7/2016
 */
package chessgame.controller;

import chessgame.view.Table;

/**
 *
 * @author jasonjames
 */

public final class Controller {
        
    public static void get() {
        Table.get().show();
    }

}
