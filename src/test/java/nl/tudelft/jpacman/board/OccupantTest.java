package nl.tudelft.jpacman.board;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Test suite to confirm that {@link Unit}s correctly (de)occupy squares.
 *
 * @author Jeroen Roosen 
 *
 */
class OccupantTest {

    /**
     * The unit under test.
     */
    private Unit unit;

    /**
     * Resets the unit under test.
     */
    @BeforeEach
    void setUp() {
        unit = new BasicUnit();
    }

    /**
     * Asserts that a unit has no square to start with.
     */
    @Test
    void noStartSquare() {
        assertThat(unit.hasSquare()).isFalse();
    }

    /**
     * Tests that the unit indeed has the target square as its base after
     * occupation.
     */
    @Test
    void testOccupy() {
        Square square = new BasicSquare();
        unit.occupy(square);
        assertThat(unit.hasSquare()).isTrue();
        assertThat(square.isAccessibleTo(unit)).isTrue();
        assertThat(square.getOccupants()).contains(this.unit);
    }

    /**
     * Test that the unit indeed has the target square as its base after
     * double occupation.
     */
    @Test
    void testReoccupy() {
        Square square1 = new BasicSquare();
        unit.occupy(square1);
        Square square2 = new BasicSquare();
        unit.occupy(square2);
        assertThat(unit.hasSquare()).isTrue();
        assertThat(square2.isAccessibleTo(unit)).isTrue();
        assertThat(square2.getOccupants()).contains(this.unit);
    }
}
