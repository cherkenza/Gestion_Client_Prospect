package tests;
import entities.Client;
import entities.Adresse;
import entities.GestionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
class ClientTest {
    @ParameterizedTest
    @ValueSource(longs = 199)
    void testChiffreAffairesInvalide (long chiffreAffairesinvalide) {
        assertThrows(GestionException.class, () -> new Client().setChiffreAffaires(chiffreAffairesinvalide));
    }

    @ParameterizedTest
    @ValueSource(longs = 230)
    void testChiffreAffairesValide (long chiffreAffairesvalide) {
        assertDoesNotThrow(() -> new Client().setChiffreAffaires(chiffreAffairesvalide));
    }

    @ParameterizedTest
    @ValueSource(ints = -9)
    void testNombreEmployesInvalide (int nombreEmployesinvalide) {
        assertThrows(GestionException.class, () -> new Client().setNombreEmployes(nombreEmployesinvalide));
    }

    @ParameterizedTest
    @ValueSource(ints = 10)
    void testNombreEmployesValide (int nombreEmployesvalide) {
        assertDoesNotThrow(() -> new Client().setNombreEmployes(nombreEmployesvalide));
    }

  
}