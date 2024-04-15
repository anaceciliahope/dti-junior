package br.com.dti.petshops.model;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class Petshop {

    private String nome;
    private Double distancia;
    private Double precoPequenhoSemana;
    private Double precoGrandeSemana;
    private Double precoPequenoFimSemana;
    private Double precoGrandeFimSemana;

    public Petshop(String nome, Double distancia, Double precoPequenhoSemana, Double precoGrandeSemana, Double precoPequenoFimSemana, Double precoGrandeFimSemana) {
        this.nome = nome;
        this.distancia = distancia;
        this.precoPequenhoSemana = precoPequenhoSemana;
        this.precoGrandeSemana = precoGrandeSemana;
        this.precoPequenoFimSemana = precoPequenoFimSemana;
        this.precoGrandeFimSemana = precoGrandeFimSemana;
    }

    public double clacularPreco(LocalDate data, int qtdPequeno, int qtdGrande) {
        double preco = 0;
        if (data.getDayOfWeek() == DayOfWeek.SATURDAY || data.getDayOfWeek() == DayOfWeek.SUNDAY) {
            preco = qtdPequeno * precoPequenoFimSemana;
            preco += qtdGrande * precoGrandeFimSemana;
        } else {
            preco = qtdPequeno * precoPequenhoSemana;
            preco += qtdGrande * precoGrandeSemana;
        }
        return preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getDistancia() {
        return distancia;
    }

    public void setDistancia(Double distancia) {
        this.distancia = distancia;
    }

    public Double getPrecoPequenhoSemana() {
        return precoPequenhoSemana;
    }

    public void setPrecoPequenhoSemana(Double precoPequenhoSemana) {
        this.precoPequenhoSemana = precoPequenhoSemana;
    }

    public Double getPrecoGrandeSemana() {
        return precoGrandeSemana;
    }

    public void setPrecoGrandeSemana(Double precoGrandeSemana) {
        this.precoGrandeSemana = precoGrandeSemana;
    }

    public Double getPrecoPequenoFimSemana() {
        return precoPequenoFimSemana;
    }

    public void setPrecoPequenoFimSemana(Double precoPequenoFimSemana) {
        this.precoPequenoFimSemana = precoPequenoFimSemana;
    }

    public Double getPrecoGrandeFimSemana() {
        return precoGrandeFimSemana;
    }

    public void setPrecoGrandeFimSemana(Double precoGrandeFimSemana) {
        this.precoGrandeFimSemana = precoGrandeFimSemana;
    }

}
