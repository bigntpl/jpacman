package nl.tudelft.jpacman.board;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BoardTest {

    @Test
    void testConstruct() {
        Square square = new BasicSquare();
        Square[][] grid = new Square[1][1];
        grid[0][0] = square;
        Board board = new Board(grid);
        assertThat(board.invariant()).isTrue();
    }

    @Test
    void testSquareAt(){
        Square square = new BasicSquare();
        Square[][] grid = new Square[1][1];
        grid[0][0] = square;
        Board board = new Board(grid);
        assertThat(board.squareAt(0, 0)).isEqualTo(square);
    }

    @Test
    void testSquareAtWithNullSquare(){
        Square[][] grid = new Square[1][1];
        Board board = new Board(grid);
    }
}
