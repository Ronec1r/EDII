package aula_arvore_binaria;

public class NodoAB {
    private Object info;
    private NodoAB pai;
    private NodoAB nodoesquerdo;
    private NodoAB nododireito;

    public NodoAB(Object info){
        this.info=info;
    }

    public void setInfo(Object info) {
        this.info = info;
    }

    public void setPai(NodoAB pai) {
        this.pai = pai;
    }

    public void setNodoesquerdo(NodoAB nodoesquerdo) {
        this.nodoesquerdo = nodoesquerdo;
    }

    public void setNododireito(NodoAB nododireito) {
        this.nododireito = nododireito;
    }

    public Object getInfo() {
        return info;
    }

    public NodoAB getPai() {
        return pai;
    }

    public NodoAB getNodoesquerdo() {
        return nodoesquerdo;
    }

    public NodoAB getNododireito() {
        return nododireito;
    }

    public boolean eRaiz(){
        if (this.getPai()==null){
            return true;
        }
        return false;
    }

    public boolean eFolha(){
        if ((this.getNodoesquerdo()==null) && (this.getNododireito()==null)){
            return true;
        }
        return false;
    }

}
