

import wheels.users.*;
import java.awt.event.*;

public class PuzzleTile extends Image {
    
    private PuzzleBoard _owner;
    private int _n;
    
    public PuzzleTile(PuzzleBoard owner, int n) {
        super("images/Tile_"+n+".jpg");
        _owner = owner;
        _n = n;
    }

    public void mouseClicked(MouseEvent e) {
        _owner.tileClicked(_n);
    }
}
