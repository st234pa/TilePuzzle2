public class PuzzleSolver {
    
    private Puzzle _puzzle;
    
    private int _count;
    private String _moves;
    
    // pre condition:
    // post condition:
    // bigO notation:  
    public PuzzleSolver(Puzzle p) {
        _puzzle = p;
    }

    // pre condition:
    // post condition:
    // bigO notation:  
    public int count() {
        return _count;
    }

    // pre condition:
    // post condition:
    // bigO notation:  
    public String moves() {
        return _moves;
    }
    
    // pre condition:
    // post condition:
    // bigO notation:  
    private boolean solve(int count, int last, String stack) {
        if(_puzzle.isSolved())
        {
            if((_count == 0) || (_count > count)) {
                _count = count;
                _moves = stack;
            }
            //System.out.println(stack);
            return true;
        }
        
        count++;
        if((count > 31) || ((_count != 0) && (count >= _count)))
            return false;

        // move the one over
        if(last != 2) {
            if(_puzzle.move(-1, 0)) {
                solve(count, 0, stack+_puzzle.emptyPos()+":");
                _puzzle.move(1, 0);
            }
        }
        // move the one to the right
        if(last != 3) {
            if(_puzzle.move(0, 1)) {
                solve(count, 1, stack+_puzzle.emptyPos()+":");
                _puzzle.move(0, -1);
            }
        }
        // move the one below
        if(last != 0) {
            if(_puzzle.move(1, 0)) {
                solve(count, 2, stack+_puzzle.emptyPos()+":");
                _puzzle.move(-1, 0);
            }
        }
        // move the one to the left
        if(last != 1) {
            if(_puzzle.move(0, -1)) {
                solve(count, 3, stack+_puzzle.emptyPos()+":");
                _puzzle.move(0, 1);
            }
        }
        return false;
    }
    
    // pre condition:
    // post condition:
    // bigO notation:  
    public boolean solve() {
        _count = 0;
        _moves = "";
        solve(0, -1, "");
        return _count != 0;
    }

    // pre condition: the tiles are shuffled and the user is going to click on tiles
    // post condition: the user has clicked on a tile to move
    // bigO notation: O(N^2) 
    public void play(PuzzlePlayer player) {
        for(int i=0, s=0; i<_count; i++) {
            int n = _moves.indexOf(':', s);
            int p = Integer.parseInt(_moves.substring(s, n));
            s = n+1;
            player.puzzleMove(p);
        }
    }
}
