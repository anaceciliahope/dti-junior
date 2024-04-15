package br.com.dti.petshops;

import br.com.dti.petshops.service.PetshopService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe: <data> <quantidade de cães pequenos> <quantidade cães grandes>");
        String input = sc.nextLine();
        PetshopService petshopService = new PetshopService();
        String resposta = petshopService.calcularMelhorPetshop(input);
        System.out.println(resposta);
    }

}