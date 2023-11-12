package aula_arvore_binaria;

public class Visitante {
    private Object info;
    private NodoAB resultado;

    public Visitante(Object info){
        this.info=info;
    }

    public void setResultado(NodoAB nodo){
        if(this.info.equals(nodo.getInfo())){
            this.resultado=nodo;
        }
    }

    public NodoAB getResultado(){
        return resultado;
    }
}
