package Classe;

import java.util.LinkedList;

public class Pilha<Tipo> {
    
    private LinkedList<Tipo> obje = new LinkedList<Tipo>();
    
    public void insere(Tipo obj ){
        this.obje.push(obj);
    }
    public Tipo remove(){
        return this.obje.removeLast();
    }
    public Tipo olha() {
        if(vazia())
            return null;
        else
            return this.obje.get(tamanho() - 1);
    }
    public boolean vazia() {
        return (tamanho() == 0);
    } 
    public int tamanho() {
        return this.obje.size() ;
    }
    public String toString() {
        return this.obje.toString();
   }
    
}
