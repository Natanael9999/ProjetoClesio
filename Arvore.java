package Classe;

public class Arvore<TIPO extends Comparable> {
    
    private Elemento<TIPO> raiz;
    
    Lista lista2 = new Lista();
    
    public Arvore()
    {
        this.raiz = null;
    }
    
    
    public Elemento<TIPO> getRaiz()
    {
        return raiz;
    }
    
    public void setRaiz(Elemento<TIPO> r)
    {
        this.raiz = r;
    }
    
    public boolean adicionar(TIPO valor)
    {
        Elemento<TIPO> novoElemento = new Elemento<TIPO>(valor);
        
        if(raiz == null)
        {
            this.raiz = novoElemento;
            
            return true;
        }
        
        else
        {
            Elemento<TIPO> atual = this.raiz;
            
            while(true)
            {
                
                if ((novoElemento.getValor().compareTo(atual.getValor()) < 0))
                {
                    if((novoElemento.getValor().equals(atual.getValor())))
                    {
                        return false;
                    }
                    
                    else
                    {
                        if(atual.getEsquerda() != null)
                        {
                            atual = atual.getEsquerda();
                        }
                        
                        else
                        {
                            atual.setEsquerda(novoElemento);
                        
                            return true;
                        }
                    }
                }
                
                else
                {
                    if((novoElemento.getValor().equals(atual.getValor())))
                    {
                        return false;
                    }
                    
                    else{
                        if (atual.getDireita() != null)
                        {
                            atual = atual.getDireita();
                        }
                        
                        else
                        {
                            atual.setDireita(novoElemento);
                        
                            return true;
                        }
                    }
                }
            }
        }
    }
    
    public String emOrdem(Elemento<TIPO> atual)
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
    
    public String preOrdem(Elemento<TIPO> atual)
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
    
    public String posOrdem(Elemento<TIPO> atual)
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
    
    public boolean remover(TIPO valor){
        
        Elemento<TIPO> atual = this.raiz;
        
        Elemento<TIPO> paiAtual = null;
        
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
            Elemento<TIPO> removeEle = atual;
            
            Elemento<TIPO> removePai = paiAtual; 
            
            if (removeEle.getDireita() != null){
                
                Elemento<TIPO> substituto = removeEle.getDireita();
                
                Elemento<TIPO> paiSubstituto = removeEle;
                
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
                
                Elemento<TIPO> substituto = removeEle.getEsquerda();
                
                Elemento<TIPO> paiSubstituto = removeEle;
                
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
