package aula_arvore;

import javax.swing.*;

public class Programa {
    public static void main(String[] args){
        Nodo veiculo = new Nodo("Veiculo");

        Nodo aereo = new Nodo("Aereo");
        Nodo terrestre = new Nodo("Terrestre");
        Nodo aquatico = new Nodo("Aquatico");

        veiculo.adicionarFilho(aereo);
        veiculo.adicionarFilho(terrestre);
        veiculo.adicionarFilho(aquatico);

        Nodo aviao = new Nodo("Aviao");
        Nodo jatinho = new Nodo("Jatinho");
        aereo.adicionarFilho(aviao);
        aereo.adicionarFilho(jatinho);

        Nodo carro = new Nodo("Carro");
        terrestre.adicionarFilho(carro);

        Nodo navio = new Nodo("Navio");
        Nodo submarino = new Nodo("Submarino");
        aquatico.adicionarFilho(navio);
        aquatico.adicionarFilho(submarino);


        System.out.println(submarino.pegaFilhos());
        System.out.println(submarino.eraiz());
        System.out.println(submarino.efolha());
        System.out.println(submarino.getPai());
        System.out.println(submarino.nivel());
        System.out.println(submarino.grau());
        System.out.println(aquatico.irmaos());
        System.out.println(veiculo.pegaFilhos());
        veiculo.remove(aquatico);
        System.out.println(veiculo.pegaFilhos());
    }
}
