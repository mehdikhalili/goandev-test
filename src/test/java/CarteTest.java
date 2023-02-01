import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarteTest {

    private final Carte carte = new Carte();

    @Test
    void givenCarteTxtFile_whenInitializeCarteConstructor_thenNbX_andNbYShouldBe20() {
        assertEquals(20, carte.getNbX());
        assertEquals(20, carte.getNbY());
    }

    @Test
    void givenCarteTxtFile_whenInitializeCarteConstructor_thenMapSizeShouldBe400() {
        // map.size() = nbX * nbY = 20 * 20
        assertEquals(400, carte.getMap().size());
    }

    @Test
    void givenValidPoint_whenPointIsValid_thenReturnTrue() {
        var point = new Point(0,0);
        assertTrue(carte.pointIsValid(point));
    }

    @Test
    void givenInvalidPoint_whenPointIsValid_thenReturnFalse() {
        var point = new Point(-1,-1);
        assertFalse(carte.pointIsValid(point));
    }

    @Test
    void givenAnotherInvalidPoint_whenPointIsValid_thenReturnFalse() {
        var point = new Point(30,30);
        assertFalse(carte.pointIsValid(point));
    }

    @Test
    void givenEmptyString_whenDirectionsIsValid_thenReturnFalse() {
        assertFalse(carte.directionsIsValid(""));
    }

    @Test
    void givenValidDirections_whenDirectionsIsValid_thenReturnTrue() {
        assertTrue(carte.directionsIsValid("NSEO"));
    }

    @Test
    void givenInvalidDirections_whenDirectionsIsValid_thenReturnTrue() {
        assertFalse(carte.directionsIsValid("fdjfhjdfjd"));
    }

    @Test
    void givenAllowedPoint_whenPointIsAllowed_thenReturnTrue() {
        var point = new Point(3,1);
        assertTrue(carte.pointIsAllowed(point));
    }

    @Test
    void givenRestrictedPoint_whenPointIsAllowed_thenReturnFalse() {
        var point = new Point(0,0);
        assertFalse(carte.pointIsAllowed(point));
    }

    @Test
    void givenAnotherRestrictedPoint_whenPointIsAllowed_thenReturnFalse() {
        var point = new Point(6,9);
        assertFalse(carte.pointIsAllowed(point));
    }
}