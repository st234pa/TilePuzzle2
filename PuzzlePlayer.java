public interface PuzzlePlayer {

    // pre condition: puzzle tiles are not solved
    // post condition: puzzle tiles are not necessarily solved, but one tile switched places with the blank space
    // bigO notation: O(1) because a single move 
    public void puzzleMove(int pos);
    // either the user or the computer makes a single move
    // SLIGHTLY CONFUSED WHERE IS THIS DEFINED?
}
