package aula_arvore_binaria;

import aula_arvore.Nodo;

public class Programa {
    public static void main(String[] args){
        Arvore arvore = new Arvore();
        NodoAB raiz = arvore.criaRaiz("+");

        NodoAB prod = arvore.inserirNodoEsquerdo("*", raiz);
        arvore.inserirNodoEsquerdo("A", prod);
        arvore.inserirNodoDireito("B", prod);

        NodoAB div = arvore.inserirNodoDireito("/", raiz);
        arvore.inserirNodoEsquerdo("C", div);
        arvore.inserirNodoDireito("D", div);

        System.out.println(arvore.getsize());
        System.out.println(arvore.getRaiz());
        System.out.println(arvore);


    }
}