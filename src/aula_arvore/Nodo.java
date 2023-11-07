package aula_arvore;

import java.util.ArrayList;
import java.util.List;

public class Nodo {
    private List<Nodo> filhos = new ArrayList<Nodo>();
    private List<Nodo> irmaos = new ArrayList<Nodo>();
    private Object dado;
    private Nodo pai;

    public Nodo(Object dado){
        this.dado=dado;
    }

    public Object getDado(){
        return this.dado;
    }

    public List<Nodo> pegaFilhos() {
        return filhos;
    }

    private void adicionarpai(Nodo pai){
        this.pai = pai;
    }

    public void adicionarFilho(Nodo filho) {
        filhos.add(filho);
        filho.adicionarpai(this);
    }

    public boolean efolha(){
        if (filhos.size()>0){
            return false;
        }else{
            return true;
        }
    }

    public boolean eraiz(){
        if (this.pai==null){
            return true;
        }else{
            return false;
        }
    }

    public Nodo getPai(){
        if (this.pai==null){
            throw new RuntimeException("É a raiz");
        }
        return this.pai;
    }

    public int grau(){
        return filhos.size();
    }

    public int nivel(){
        if (this.eraiz()){
            return 1;
        }
        int nivel = 2;
        Nodo ex_pai = this.pai;
        while(ex_pai.eraiz()==false){
            nivel+=1;
            ex_pai = ex_pai.getPai();
            System.out.println(ex_pai.getDado());
        }
        return nivel;
    }

    public void remove(Nodo nodo){
        for(int i=0; i<filhos.size(); i++){
            if (filhos.get(i)==nodo){
                filhos.remove(i);
            }
        }
    }

    public List<Nodo> irmaos(){
       try {
           Nodo pai=this.getPai();
           for(int i=0; i<pai.filhos.size(); i++){
               if(pai.filhos.get(i)!=this) {
                   irmaos.add(pai.filhos.get(i));
               }
           }
           return irmaos;
       }catch (Exception e){
           return null;
       }
    }

}
