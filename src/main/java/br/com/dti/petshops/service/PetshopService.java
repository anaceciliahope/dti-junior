package br.com.dti.petshops.service;

import br.com.dti.petshops.model.Petshop;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class PetshopService {

    public String calcularMelhorPetshop(String input) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String[] params = input.split(" ");
        LocalDate data = LocalDate.parse(params[0], formatter);
        int qtdCaesPequenos = Integer.parseInt(params[1]);
        int qtdCaesGrandes = Integer.parseInt(params[2]);

        Petshop meuCanilFeliz = new Petshop("Meu Canino Feliz", 2.0, 20.0, 24.0, 40.0, 48.0);
        Petshop vaiRex = new Petshop("Vai Rex", 1.7, 15.0, 50.0, 20.0, 55.0);
        Petshop chowChawgas = new Petshop("ChowChawgas", 0.8, 30.0, 45.0, 30.0, 45.0);

        double precoMeuCanilFeliz = meuCanilFeliz.clacularPreco(data, qtdCaesPequenos, qtdCaesGrandes);
        double precoVaiRex = vaiRex.clacularPreco(data, qtdCaesPequenos, qtdCaesGrandes);
        double precoChowChawgas = chowChawgas.clacularPreco(data, qtdCaesPequenos, qtdCaesGrandes);
        String melhorCanil = null;
        if (precoChowChawgas <= precoVaiRex && precoChowChawgas <= precoMeuCanilFeliz) {
            melhorCanil = "ChowChawgas " + precoChowChawgas;
        } else if (precoVaiRex <= precoMeuCanilFeliz) {
            melhorCanil = "Vai Rex " + precoVaiRex;
        } else {
            melhorCanil = "Meu Canino Feliz " + precoMeuCanilFeliz;
        }
        return melhorCanil;
    }

}
