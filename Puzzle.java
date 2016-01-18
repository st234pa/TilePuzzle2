public class Puzzle {

    private int[][] _puzzle;
    private int _empty_r;
    private int _empty_c;
    
    // pre condition: 
    // post condition:
    // bigO notation: O(N^2) because it calls a quadratic function (reset fucntion)
    public Puzzle(int size) {
        _puzzle = new int[size][size];
        reset();
    }

    // pre condition:
    // post condition:
    // bigO notation: O(N^2) because there is a loop within a loop that passes through the length of _puzzle
    public void reset() {
        for(int r=0, id=1; r<_puzzle.length; r++)
            for(int c=0; c<_puzzle.length; c++, id++)
                _puzzle[r][c] = id;
        _empty_r = _puzzle.length-1;
        _empty_c = _puzzle.length-1;
        _puzzle[_empty_r][_empty_c] = 0;
    }

    // pre condition:
    // post condition:
    // bigO notation: O(N^2) because there is a loop within a loop that passes through   
    public boolean isSolved() {
        for(int r=0, id=1; r<_puzzle.length; r++)
            for(int c=0; c<_puzzle.length; c++, id++)
                if((_puzzle[r][c] != 0) && (_puzzle[r][c] != id))
                    return false;
        return true;
    }

    // pre condition:
    // post condition:
    // bigO notation: O(1) because we are returning a single entity, size of the row doesn't matter
    public int emptyRow() {
        return _empty_r;
    }

    // pre condition:
    // post condition:
    // bigO notation: O(1) because we are returning a single entity, size of the column doesn't matter
    public int emptyCol() {
        return _empty_c;
    }

    // pre condition:
    // post condition:
    // bigO notation: O(1) because we are just multiplying 
    public int emptyPos() {
        return _empty_r*_puzzle.length+_empty_c;
    }
    // pre condition:
    // post condition:
    // bigO notation: O(1) because 
    public int at(int r, int c) {
        return _puzzle[r][c];
    }
    
    // pre condition:
    // post condition:
    // bigO notation:    
    public int pos(int n) {
        for(int r=0; r<_puzzle.length; r++)
            for(int c=0; c<_puzzle.length; c++)
                if(_puzzle[r][c] == n)
                    return r*_puzzle.length + c;
        return -1;
    }

    // pre condition:
    // post condition:
    // bigO notation:
    public int posRow(int p) {
        return p / _puzzle.length;
    }

    // pre condition:
    // post condition:
    // bigO notation:
    public int posCol(int p) {
        return p % _puzzle.length;
    }
 
    // pre condition:
    // post condition:
    // bigO notation:   
    public void print() {
        for(int r=0; r<_puzzle.length; r++)
        {
            for(int c=0; c<_puzzle.length; c++)
                System.out.print("["+String.format("%2d", _puzzle[r][c])+"] ");
            System.out.println("");
        }
    }

    // pre condition:
    // post condition:
    // bigO notation:
    public int size() {
        return _puzzle.length;
    }

    // pre condition:
    // post condition:
    // bigO notation:    
    public boolean move(int dr, int dc) {
        int nr = _empty_r+dr;
        int nc = _empty_c+dc;
        if((nr >=0) && (nr < size()) &&
           (nc >=0) && (nc < size()))
        {
            _puzzle[_empty_r][_empty_c] = _puzzle[nr][nc];
            _puzzle[nr][nc] = 0;
            _empty_r = nr;
            _empty_c = nc;
            return true;
        }
        return false;
    }
    
    // pre condition:
    // post condition:
    // bigO notation:    
    public void shuffle(int count) {
        for(int c=0; c<count; c++) {
            switch((int)(Math.random()*4)) {
              case 0: // move the one over
                move(-1, 0);
                break;
              case 1: // move the one to the right
                move(0, 1);
                break;
              case 2: // move the one below
                move(1, 0);
                break;
              case 3: // move the one to the left
                move(0, -1);
                break;
            }
        }
    }
    
    // pre condition:
    // post condition:
    // bigO notation:  
    public static void main(String[] args) {
        Puzzle p = new Puzzle(3);
        
        p.print();
        System.out.println("isSorted="+p.isSolved());
        
        //p.(1000);
        p._puzzle = new int[][] {{8, 6, 7} , {2, 5, 4} , {3, 0, 1}};
        p._empty_r = 2;
        p._empty_c = 1;
        p.print();
        System.out.println("isSorted="+p.isSolved());
        
        //p.solve(31, -1, "");

        PuzzleSolver s = new PuzzleSolver(p);
        s.solve();
        System.out.println(""+s.count()+"="+s.moves());
        p.print();
        System.out.println("isSorted="+p.isSolved());
    }

}

//https://en.wikipedia.org/wiki/15_puzzle
//https://n-puzzle-solver.appspot.com/
//http://w01fe.com/blog/2009/01/the-hardest-eight-puzzle-instances-take-31-moves-to-solve/
//http://www.cs.princeton.edu/courses/archive/fall12/cos226/assignments/8puzzle.html
