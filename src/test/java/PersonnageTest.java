import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonnageTest {

    private final Carte carte = new Carte();

    @Test
    void givenRestrictedPoint_whenMove_thenPersonnageWontMove() {
        var givenPoint = new Point(0, 0);
        var personnage = new Personnage(givenPoint);
        personnage.move(carte, "NSEO");
        assertEquals(givenPoint, personnage.getPosition());
    }

    @Test
    void givenAllowedPoint_whenMove_thenPersonnageWillMove() {
        var givenPoint = new Point(3, 0);
        var expectedPoint = new Point(9, 2);
        var personnage = new Personnage(givenPoint);
        personnage.move(carte, "SSSSEEEEEENN");
        assertEquals(expectedPoint, personnage.getPosition());
    }
}