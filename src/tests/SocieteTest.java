package tests;

import entities.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class SocieteTest {
    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = "xxxxx.xxx")
    void testMailInvalide(String mailinvalide){
        assertThrows(GestionException.class, () -> new Client().setEmail(mailinvalide));
    }

    @ParameterizedTest
    @ValueSource(strings = "xxx@xxx.com")
    void testMailValide(String mailvalide){
        assertDoesNotThrow(() -> new Client().setEmail(mailvalide));

    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = "")
    void testRaisonSocialeInvalide(String raisonSocialeInvalide){
       assertThrows(GestionException.class,() -> new Prospect().setRaisonSociale(raisonSocialeInvalide));
    }
    @ParameterizedTest
    @ValueSource(strings = "lidec")
    void testRaisonSocialeValide(String raisonSocialeValide){
        assertDoesNotThrow(() -> new Prospect().setRaisonSociale(raisonSocialeValide));
    }

    @ParameterizedTest
    @EmptySource
    @ValueSource(strings = "9868578545")
    void testTelephoneInvalide(String telephoneInvalide){
        assertThrows(GestionException.class, () -> new Client().setTelephone(telephoneInvalide));
    }

    @ParameterizedTest
    @ValueSource(strings = "+33 07 84 98 68 19")
    void testTelephoneValide(String telephoneValide){
        assertDoesNotThrow(() -> new Client().setTelephone(telephoneValide));
    }


}