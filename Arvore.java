package Classe;

public class Arvore<T extends Comparable> {
    
    private Elemento<T> raiz;
    
    public Arvore()
    {
        this.raiz = null;
    }
    
    
    public Elemento<T> getRaiz()
    {
        return raiz;
    }
    
    public void setRaiz(Elemento<T> r)
    {
        this.raiz = r;
    }
    
    public boolean adicionar(T valor)
    {
        Elemento<T> novoElemento = new Elemento<T>(valor);
        
        if(raiz == null)
        {
            this.raiz = novoElemento;
            
            return true;
        }
        
        else
        {
            Elemento<T> atual = this.raiz;
            
            while(true)
            {
                switch (novoElemento.getValor().compareTo(atual.getValor())) {
                    case -1:
                        if(atual.getEsquerda() != null)
                        {
                            atual = atual.getEsquerda();
                        }
                        
                        else
                        {
                            atual.setEsquerda(novoElemento);
                            
                            return true;
                        }   break;
                    case 1:
                        if (atual.getDireita() != null)
                        {
                            atual = atual.getDireita();
                        }
                        
                        else
                        {
                            atual.setDireita(novoElemento);
                            
                            return true;
                        }   break;
                    default:
                        return false;
                }
            }
        }
    }
    
    public String emOrdem(Elemento<T> atual)
    {
        if(atual != null)
        {
            return emOrdem(atual.getEsquerda()) + atual.getValor() + ", " + emOrdem(atual.getDireita());
        }
        
        else
        {
            return "";
        }
    }
    
    public String preOrdem(Elemento<T> atual)
    {
        if(atual != null)
        {
            return atual.getValor() + ", " + preOrdem(atual.getEsquerda()) + preOrdem(atual.getDireita());
        }
        
        else
        {
            return "";
        }
    }
    
    public String posOrdem(Elemento<T> atual)
    {
        if(atual != null)
        {
            return posOrdem(atual.getEsquerda()) + posOrdem(atual.getDireita()) + atual.getValor() + ", ";
        }
        
        else
        {
            return "";
        }
    }
    
    public boolean remover(T valor){
        
        Elemento<T> atual = this.raiz;
        
        Elemento<T> paiAtual = null;
        
        while(atual != null){
            
            if (atual.getValor().equals(valor))
            { 
                break;                
            }
            
            else if (valor.compareTo(atual.getValor()) == -1)
            {  
                paiAtual = atual;
                
                atual = atual.getEsquerda();
            }
            
            else
            {     
                paiAtual = atual;
                
                atual = atual.getDireita();
            }
        }
        
        if (atual != null)
        {
            Elemento<T> removeEle = atual;
            
            Elemento<T> removePai = paiAtual; 
            
            if (removeEle.getDireita() != null){
                
                Elemento<T> substituto = removeEle.getDireita();
                
                Elemento<T> paiSubstituto = removeEle;
                
                char paiFoi = 'D';                  
                
                while(substituto.getEsquerda() != null){
                    paiSubstituto = substituto;
                    substituto = substituto.getEsquerda();
                    paiFoi = 'E';
                }
                
                if(paiFoi == 'D')
                    paiSubstituto.setEsquerda(substituto.getDireita());
                
                else                  
                    paiSubstituto.setDireita(substituto.getDireita());
                
                substituto.setEsquerda(removeEle.getEsquerda());
                
                substituto.setDireita(removeEle.getDireita());
                
                if (removePai != null){
                    
                    if (removeEle.getValor().compareTo(removePai.getValor()) == -1)
                    { 
                        removePai.setEsquerda(substituto);
                    }
                    
                    else
                    {
                        removePai.setDireita(substituto);
                    }
                }
                
                else
                {
                    this.raiz = substituto;
                }   
            }
            
            else if (removeEle.getEsquerda() != null){ 
                
                Elemento<T> substituto = removeEle.getEsquerda();
                
                Elemento<T> paiSubstituto = removeEle;
                
                char paiFoi = 'E';
                
                
                while(substituto.getDireita() != null)
                {
                    paiSubstituto = substituto;
                    
                    substituto = substituto.getDireita();
                    
                    paiFoi = 'D';
                }
                               
                if(paiFoi == 'E') 
                    paiSubstituto.setEsquerda(substituto.getEsquerda());
                
                else                        
                   paiSubstituto.setDireita(substituto.getEsquerda());
                
                
                substituto.setEsquerda(removeEle.getEsquerda());
                
                substituto.setDireita(removeEle.getDireita());

                if (removePai != null){
                    
                    if (removeEle.getValor().compareTo(removePai.getValor()) == -1)
                    {
                        removePai.setEsquerda(substituto); 
                    }
                    
                    else
                    {
                        removePai.setDireita(substituto);
                    }
                }
                
                else
                { 
                    this.raiz = substituto;
                }

            }
            
            else if (removePai != null){
                
                
                if (removeEle.getValor().compareTo(removePai.getValor()) == -1){ 
                    removePai.setEsquerda(null);
                }
                
                else
                { 
                    removePai.setDireita(null);
                }
            }
            
            else
            { 
                    this.raiz = null;
            }
            
            return true;
        }
        
        
        else
        { 
            return false;
        }        
    }
}
