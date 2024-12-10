package tests;

import entities.Adresse;
import entities.GestionException;
import entities.Prospect;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ProspectTest {
@ParameterizedTest
@EmptySource
@ValueSource(strings = "2023/03/03")
    void testDateProspectInvalide (String dateInvalide) {
    assertThrows(GestionException.class, () -> new Prospect().setDateProspection(LocalDate.parse(dateInvalide)));
}
@ParameterizedTest
 @ValueSource(strings = "03/02/2023")
    void testDateProspectValide (String dateValide) {
    assertDoesNotThrow(() -> new Prospect().setDateProspection(LocalDate.parse(dateValide)));
}



}