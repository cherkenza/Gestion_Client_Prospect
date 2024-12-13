package tests;

import entities.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class SocieteTest {
    private Societe societe;

    @BeforeEach
    void setUp() throws GestionException {


        societe = new SocieteTestSet(1, "Test Raison", new Adresse("5", " gigii","58235","kikou"), "0102030405", "test@example.com", "Test commentaire");
    }

    @Test
    void testSetEmailValid() throws GestionException {
        societe.setEmail("valid@example.com");
        assertEquals("valid@example.com", societe.getEmail());
    }
    @Test
    void testSetEmailInvalid() {
        assertThrows(GestionException.class, () -> {
            societe.setEmail("invalid-email");
        });
    }

    @Test
    void testSetTelephoneValid() throws GestionException {
        societe.setTelephone("0102030405");
        assertEquals("0102030405", societe.getTelephone());
    }

    @Test
    void testSetTelephoneInvalid() {
        assertThrows(GestionException.class, () -> {
            societe.setTelephone("12345");
        });
    }

    @Test
    void testSetRaisonSocialeValid() throws GestionException {
        societe.setRaisonSociale("New Raison");
        assertEquals("New Raison", societe.getRaisonSociale());
    }


    @Test
    void testSetRaisonSocialeEmpty() {
        assertThrows(GestionException.class, () -> {
            societe.setRaisonSociale("");
        });
    }

    @Test
    void testSetRaisonSocialeDuplicate() throws GestionException {
        societe= new SocieteTestSet(2, "Test Raison", new Adresse("8", "rirou", "58693","fifou"), "0203040506", "duplicate@example.com", "Another comment");
        assertThrows(GestionException.class, () -> {
            societe.setRaisonSociale("Test Raison");
        });
    }

}