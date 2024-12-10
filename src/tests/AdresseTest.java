package tests;

import entities.Adresse;
import entities.GestionException;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class AdresseTest {

 @ParameterizedTest
 @EmptySource
 @ValueSource(strings = "6598")
    void testCodePostalInvalide(String codePostalinvalide) {
     assertThrows(GestionException.class, () -> new Adresse().setCodePostal(codePostalinvalide));
 }

 @ParameterizedTest
 @ValueSource(strings = "54000")
 void testCodePostalValide(String codePostalvalide) {
     assertDoesNotThrow(() -> new Adresse().setCodePostal(codePostalvalide));
 }

 @ParameterizedTest
 @EmptySource
 @ValueSource(strings = "")
 void testNomRueInvalide(String nomRueinvalide) {
     assertThrows(GestionException.class, () -> new Adresse().setNomRue(nomRueinvalide));
 }

 @ParameterizedTest
 @ValueSource(strings = "pascal")
 void testNomRueValide(String nomRuevalide) {
     assertDoesNotThrow(() -> new Adresse().setNomRue(nomRuevalide));
 }

 @ParameterizedTest
 @EmptySource
 @ValueSource( strings = "")
    void testNumeroRueInvalide(String numeroRueinvalide) {
     assertThrows(GestionException.class, () -> new Adresse().setNumeroRue(numeroRueinvalide));
 }

 @ParameterizedTest
 @ValueSource(strings = "56")
 void testNumeroRueValide(String numeroRueValide) {
     assertDoesNotThrow(() -> new Adresse().setNumeroRue(numeroRueValide));
 }

 @ParameterizedTest
 @EmptySource
 @ValueSource(strings = "")
 void testVilleInvalide(String villeinvalide) {
     assertThrows(GestionException.class, () -> new Adresse().setVille(villeinvalide));
 }

 @ParameterizedTest
 @ValueSource(strings = "Nancy")
 void testVilleValide(String villevalide) {
     assertDoesNotThrow(() -> new Adresse().setVille(villevalide));
 }

}