package me.smudge.client.items.chessboard.pieces;

import me.smudge.client.game.ChessBoard;
import me.smudge.client.game.ChessColour;
import me.smudge.client.game.Tile;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Represents a chess board piece
 */
public abstract class Piece {

    /**
     * The colour of the chess piece
     */
    private ChessColour colour;

    /**
     * The options tied to the piece
     */
    private PieceOptions options;

    /**
     * Create a new instance of {@link Piece}
     * @param colour Colour of the chess piece
     */
    public Piece(ChessColour colour) {
        this.colour = colour;
        this.options = new PieceOptions();
    }

    /**
     * Get image paths
     */
    public abstract String getPathWhite();
    public abstract String getPathBlack();

    /**
     * Used to get the value of the piece that an algorithm can use
     * to determine what is the best move to make
     * @return Value of the piece as an integer
     */
    public abstract int getValue();

    /**
     * Used to get the pieces options
     * @return Piece options
     */
    public PieceOptions getOptions() {
        return options;
    }

    /**
     * Get piece colour
     */
    public ChessColour getColour() {
        return colour;
    }

    /**
     * Used to render the piece to the tile panel
     * @param panel The panel of the tile
     */
    public void render(JButton panel) {
        String path = getPathBlack();
        if (this.colour == ChessColour.WHITE) path = getPathWhite();

        Icon icon = new ImageIcon(path);
        panel.setIcon(icon);
        panel.setVisible(true);
    }

    /**
     * Used to get valid positions on the board
     * @return Valid tiles
     */
    public abstract ArrayList<Tile> getValidPositions(ChessBoard board, Tile tile);

    /**
     * Used to get the positions that the piece can take other pieces from
     * @return Valid tiles
     */
    public abstract ArrayList<Tile> getTakePositions(ChessBoard board, Tile tile);
}