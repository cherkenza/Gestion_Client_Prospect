package tests;

import entities.Adresse;
import entities.EnumProspectInteresse;
import entities.GestionException;
import entities.Prospect;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class ProspectTest {

    private Prospect prospect;
    private LocalDate dateProspection;
    private EnumProspectInteresse prospectInteresse;

    @BeforeEach
    void setUp() throws GestionException {
        dateProspection = LocalDate.of(2024, 12, 13);
        prospectInteresse = EnumProspectInteresse.OUI; // Replace with an actual Enum value
        prospect = new Prospect("Free", new Adresse("6","victor hugo" ,"75000" , "paris") ,
                "0524567425", "free@free.fr", "",dateProspection, prospectInteresse);
    }


    @Test
    void testDateProspection() throws GestionException {
        LocalDate newDate = LocalDate.of(2025, 1, 1);
        prospect.setDateProspection(newDate);
        assertEquals(newDate, prospect.getDateProspection());
    }

    @Test
    void testProspectInteresse() {
        EnumProspectInteresse newInterest = EnumProspectInteresse.NON;
        prospect.setProspectInteresse(newInterest);
        assertEquals(newInterest, prospect.getProspectInteresse());
    }



}