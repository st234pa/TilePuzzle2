

import wheels.users.*;
import java.awt.event.*;

public class PuzzleTile extends Image {
    
    private PuzzleBoard _owner;
    private int _n;
    
    // pre condition: tile is blank
    // post condition: tile is given a unique image and assigned to a board
    // bigO notation: O(1)
    public PuzzleTile(PuzzleBoard owner, int n) {
        super("images/Tile_"+n+".jpg");
        _owner = owner;
        _n = n;
    }

    // pre condition: there wwas a mouse click on a tile
    // post condition: calls tileClicked from the board class, which exchanges the place of the tile with the empty cell
    // bigO notation: //NOT SURE, DEPENDS ON TILE CLICK
    public void mouseClicked(MouseEvent e) {
        _owner.tileClicked(_n);
    }
}
