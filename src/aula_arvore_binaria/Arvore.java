package aula_arvore_binaria;

public class Arvore {
    private NodoAB raiz;
    private int tamanho;

    public NodoAB criaRaiz(Object info){
        if (raiz!=null){
            throw new RuntimeException("Raiz já existe!");
        }
        raiz = new NodoAB(info);
        tamanho++;
        return raiz;
    }

    public int getsize(){
        return tamanho;
    }

    public Object getRaiz(){
        return raiz.getInfo();
    }

    public NodoAB inserirNodoEsquerdo(Object info, NodoAB pai){
        if(pai.getNodoesquerdo()!=null){
            throw new RuntimeException("Já existe filho à esquerda!");
        }
        NodoAB nodo = new NodoAB(info);
        pai.setNodoesquerdo(nodo);
        nodo.setPai(pai);
        tamanho++;
        return nodo;
    }

    public NodoAB inserirNodoDireito(Object info, NodoAB pai){
        if(pai.getNododireito()!=null){
            throw new RuntimeException("Já existe filho à direita!");
        }
        NodoAB nodo = new NodoAB(info);
        pai.setNododireito(nodo);
        nodo.setPai(pai);
        tamanho++;
        return nodo;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        montaStringCentralEsquerda(raiz, sb);
        return sb.toString();
    }

    private void montaStringCentralEsquerda(NodoAB nodo, StringBuilder sb) {
        if (nodo != null) {
            if (nodo.getNodoesquerdo() != null || nodo.getNododireito() != null) {
                sb.append("(");
            }
            // desce para esquerda
            if (nodo.getNodoesquerdo() != null) {
                montaStringCentralEsquerda(nodo.getNodoesquerdo(), sb);
            }
            // processa nodo
            sb.append(nodo.getInfo());
            // desce para direita
            if (nodo.getNododireito() != null) {
                montaStringCentralEsquerda(nodo.getNododireito(), sb);
            }
            if (nodo.getNodoesquerdo() != null || nodo.getNododireito() != null) {
                sb.append(")");
            }
        }else{
            sb.append("Árvore sem nodos");
        }
    }

}
