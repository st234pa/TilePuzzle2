import java.util.*;
import wheels.users.*;
import java.awt.Color;
import java.awt.event.*;

public class PuzzleBoard extends Rectangle implements PuzzlePlayer {

    private ArrayList<PuzzleTile> _tiles;

    private Puzzle _puzzle;
    
    // pre condition: the frame has been created
    // post condition: a board (puzzle) is created and added onto the frame
    //                 a tile arraylist is created  and shuffled
    // bigO notation: O(N) because we are using a for loop to go through 
    public PuzzleBoard(int n) {
        super(Color.GRAY);
        //setLocation(0, 0);
        
        _puzzle = new Puzzle(n);
        _puzzle.shuffle(1000);
        
        _tiles = new ArrayList<PuzzleTile>();
        for(int i=0; i<((n*n)-1); i++)
            _tiles.add(new PuzzleTile(this, i+1));

        placeTiles();

        setSize(_tiles.get(0).getWidth()*n, _tiles.get(0).getHeight()*n);
    }

    // pre condition: a puzzle board has been created and the tile arraylist has been created and shuffled
    // post condition: the shuffled tiles from the arraylist are placed onto the board 
    // bigO notation: O(N^2)
    private void placeTiles() {
        if(_puzzle == null)
            return;
        
        int x = getXLocation();
        int y = getYLocation();

        for(int r=0; r<_puzzle.size(); r++)
            for(int c=0; c<_puzzle.size(); c++)
            {
                int n = _puzzle.at(r, c);
                if(n != 0) {
                    PuzzleTile t = _tiles.get(n - 1);
                    t.setLocation(x + c*t.getWidth(), y + r*t.getHeight());
                }
            }
    }

    // pre condition: we have all of the tiles and the locations needed to actually place the tiles
    // post condition: tiles are placed at the position (x,y)
    // bigO notation: O(N^2)  
    public void setLocation(int x, int y) {
        super.setLocation(x, y);
        placeTiles();
    }

    // pre condition: the tile we want to move has been clicked
    // post condition: the tile clicked is moved to the empty space 
    // bigO notation: O(N^2)
    public void tileClicked(int n) {
        int p = _puzzle.pos(n);
        slide(p);
    }

    // pre condition: we want to move a tile
    //                we can only move in one direction (either the row changes OR the column changes, but not both)
    // post condition: the postion of the tile is changed and all of the tiles are replaced on the board
    // bigO notation: O(N^2)
    public void slide(int p) {
        int dr = _puzzle.posRow(p) - _puzzle.emptyRow();
        int dc = _puzzle.posCol(p) - _puzzle.emptyCol();
        if(((Math.abs(dr) == 1) && (dc == 0)) ||
           ((Math.abs(dc) == 1) && (dr == 0)))
        {
            _puzzle.move(dr, dc);
            placeTiles();
        }
    }

    // pre condition: the empty (gray) cell is clicked
    // post condition: new puzzle solver is created (so, we find the most efficient solution) and then we actually play the solution
    // bigO notation: O(1) 
    public void mouseClicked(MouseEvent e) {
        PuzzleSolver s = new PuzzleSolver(_puzzle);
        if(s.solve())
            s.play(this);
    }

    // pre condition: 
    // post condition:
    // bigO notation:  
    public void puzzleMove(int pos) {
        slide(pos);
        
        try {
             _dp.paintImmediately(_dp.getBounds());  
             Thread.sleep(200);
        } catch(Exception e) {
        }
    }
}
