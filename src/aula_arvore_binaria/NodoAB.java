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

    public int grau(){
        if(this.eFolha()){
            return 0;
        }else if((this.getNodoesquerdo()!=null) && (this.getNododireito()!=null)){
            return 2;
        }
        return 1;
    }

    public Object irmao(){
        NodoAB pai = this.getPai();
        if(pai.getNododireito()==this){
            return pai.getNodoesquerdo().getInfo();
        }
        return pai.getNododireito().getInfo();
    }

    public int nivel(){
        int nivel=1;
        NodoAB nodo = this;
        while(!nodo.eRaiz()){
            nodo=nodo.getPai();
            nivel++;
        }
        return nivel;
    }

}
