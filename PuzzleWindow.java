

import wheels.users.*;

public class PuzzleWindow {

    public PuzzleWindow() {
        Frame f = new Frame();
        PuzzleBoard board = new PuzzleBoard(3);
        board.setLocation(100, 100);
    }
    
    public static void main(String[] args) {
        PuzzleWindow w = new PuzzleWindow();
    }
}
