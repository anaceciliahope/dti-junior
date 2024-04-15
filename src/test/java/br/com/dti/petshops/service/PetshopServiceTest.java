package br.com.dti.petshops.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PetshopServiceTest {

    private PetshopService petshopService;

    @BeforeEach
    void setUp() {
        petshopService = new PetshopService();
    }

    @Test
    void deveRetornarMeuCaninoFeliz() {
        String result = petshopService.calcularMelhorPetshop("11/04/2024 3 5");
        assertEquals("Meu Canino Feliz 180.0", result);
    }

    @Test
    void deveRetornarChowChawgas() {
        String result = petshopService.calcularMelhorPetshop("14/04/2024 3 5");
        assertEquals("ChowChawgas 315.0", result);
    }

}