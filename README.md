# Processo Seletivo DTI-Júnior
Atividade melhor canil

## Configuração de ambiente
Baixar IDE para visualização do código

### IDE ultilizada intellij
[https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)

Baixar JDK java versão 21
### JDK 21
[https://www.oracle.com/java/technologies/downloads/](https://www.oracle.com/java/technologies/downloads/)

## Código construído

Camada Modelo -> class que representa um petshop com suas propriedades, e o metodo calcular preço, que recebe a data, quantidade de cães pequenos e a quantidade de cães grandes e retorna o valor que sera cobrado pelo banho 
```java
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
    //gets sets

}
```

Camada Serviço -> Cria 3 objetos do tipo ```Petshop``` e calcula o valor dos banhos ultilizando os parâmetros, data, quantidade de cães pequenos e quantidade de cães grandes e retorna o nome do petshop onde o banho fica mais barato e o preço a ser pago  
```java
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

```
Classe Principal -> Inicializa o sistema
```java
package br.com.dti.petshops;

import br.com.dti.petshops.service.PetshopService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        PetshopService petshopService = new PetshopService();
        String resposta = petshopService.calcularMelhorPetshop(input);
        System.out.println(resposta);
    }

}
```

## Premissas assumidas
1. Os valores de entrada serão validos, data valida, quantidade de cães pequenos e grandes números inteiros

## Decisões de projeto
1. Ultilização da linguamgem ```java``` da qual tenho domínio 
2. Ultilização da IDE Intellij da qual tenho domínio
3. Organização do projeto em camadas modelo e serviço 
4. Ultilização do maven, para gerenciar as dependências e empacotar o projeto
5. Ultilização do junit para criação dos testes

## Instruções para executar o sistema
1. Baixar e instalar a JDK java 21
2. Baixar e instalar o Intellij
3. Importar o projeto no Intellij
4. Instalar o projeto ultilizando o plugin do maven, ```install```
5. Abrir a classe principal ```br.com.dti.petshops.Main.java``` e clicar em run 
6. Informar no console os parâmetros solicitados
7. Para executar os testes abra a classe ```PetshopServiceTest``` e clique no botão run
8. Como alternativa o maven gera um jar executavel dentro da pasta target ```dti-junior-1.0-SNAPSHOT.jar``` abrir o promp na pasta onde o jar foi gerado e executar o comado ```java -jar .\dti-junior-1.0-SNAPSHOT.jar``` 
