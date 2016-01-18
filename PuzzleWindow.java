import wheels.users.*;

public class PuzzleWindow {

    // pre condition: this is the driver class, so there is no preconditon
    // post condition: makes a new frame and new board and sets board to a given position
    // bigO notation: O(1) 
    public PuzzleWindow() {
        Frame f = new Frame(); 
        PuzzleBoard board = new PuzzleBoard(3);
        board.setLocation(100, 100);
    }
    
    // pre condition: there is no precondition
    // post condition: makes a new puzzle window (GUI)
    // bigO notation: O(1)
    public static void main(String[] args) {
        PuzzleWindow w = new PuzzleWindow();
    }
}
