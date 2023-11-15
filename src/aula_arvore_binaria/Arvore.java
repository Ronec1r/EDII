package aula_arvore_binaria;

public class Arvore {
    private NodoAB raiz;
    private int tamanho;

    public NodoAB criaRaiz(Object info){
        if (raiz!=null){
            throw new RuntimeException("Raiz já existe!");
        }
        this.raiz = new NodoAB(info);
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

    public void removeNodo(NodoAB nodo){
        //Remove sem mover os nodos filhos
        if(nodo.eRaiz()){
            this.raiz=null;
        }else{
            NodoAB pai = nodo.getPai();
            if(pai.getNodoesquerdo()==nodo){
                pai.setNodoesquerdo(null);
            }else{
                pai.setNododireito(null);
            }
        }
        nodo.setPai(null);
        tamanho--;
    }

    public void remove(NodoAB nodo){
        //Remove alocando os nodos filhos
        NodoAB pai = nodo.getPai();
        if(pai.getNodoesquerdo()==nodo){
            pai.setNodoesquerdo(nodo.getNodoesquerdo());
            if(pai.getNododireito()==null){
                pai.setNododireito(nodo.getNododireito());
            }
        }
        if(pai.getNododireito()==nodo){
            pai.setNododireito(nodo.getNododireito());
            if(pai.getNodoesquerdo()==null){
                pai.setNodoesquerdo(nodo.getNodoesquerdo());
            }
        }
        nodo.setPai(null);
        tamanho--;
    }

    public NodoAB busca(Object info){
        Visitante visitante = new Visitante(info);
        this.travessiaPreOrdem(this.raiz, visitante);
        return visitante.getResultado();
    }

    public Arvore copia(){
        Arvore nova_arvore = new Arvore();
        nova_arvore.criaRaiz(this.raiz.getInfo());
        this.copiaTravessiaPreOrdem(this.raiz, nova_arvore, nova_arvore.raiz);
        return nova_arvore;
    }

    private void copiaTravessiaPreOrdem(NodoAB nodo, Arvore arvore, NodoAB pai){
        if(nodo.getNodoesquerdo()!=null){
            arvore.inserirNodoEsquerdo(nodo.getNodoesquerdo().getInfo(), pai);
            pai = pai.getNodoesquerdo();
            copiaTravessiaPreOrdem(nodo.getNodoesquerdo(),arvore,pai);
        }
        pai = pai.getPai();
        if(nodo.getNododireito()!=null){
            arvore.inserirNodoDireito(nodo.getNododireito().getInfo(), pai);
            pai = pai.getNododireito();
            copiaTravessiaPreOrdem(nodo.getNododireito(),arvore, pai);
        }
    }

    public void travessiaPreOrdem(NodoAB nodo,Visitante visitante){
        //System.out.println(nodo.getInfo());
        if(visitante!=null) {
            visitante.setResultado(nodo);
        }
        if(nodo.getNodoesquerdo()!=null){
            travessiaPreOrdem(nodo.getNodoesquerdo(), visitante);
        }
        if(nodo.getNododireito()!=null){
            travessiaPreOrdem(nodo.getNododireito(), visitante);
        }
    }


    public void travessiaPosOrdem(NodoAB nodo,Visitante visitante){
        if(nodo.getNodoesquerdo()!=null){
            travessiaPosOrdem(nodo.getNodoesquerdo(), visitante);
        }
        if(nodo.getNododireito()!=null){
            travessiaPosOrdem(nodo.getNododireito(), visitante);
        }
        System.out.println(nodo.getInfo());
        if(visitante!=null) {
            visitante.setResultado(nodo);
        }
    }

    public void travessiaEmOrdem(NodoAB nodo, Visitante visitante ){
        if(nodo.getNodoesquerdo()!=null){
            travessiaEmOrdem(nodo.getNodoesquerdo(), visitante);
        }
        //System.out.println(nodo.getInfo());
        if (visitante!=null){
            visitante.setResultado(nodo);
        }
        if(nodo.getNododireito()!=null){
            travessiaEmOrdem(nodo.getNododireito(), visitante);
        }
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
