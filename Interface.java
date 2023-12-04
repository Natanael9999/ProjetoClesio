// Questão 5, adicionar na interface

        HashMap<String, Pilha<String>> mapa = new HashMap<String, Pilha<String>>();

        Iterator<Senha> iterador = lista.iterator();
        
        while (iterador.hasNext()) 
        {
            Senha u = iterador.next();
            
            String nome = u.getNomeDoAplicativo();
            
            String senha = u.getSenha();
            
            if (!mapa.containsKey(nome)) 
            {
                Pilha<String> pilha = new Pilha<String>();
                
                mapa.put(nome, pilha);
            }
            
            mapa.get(nome).insere(senha);
        }
        
        System.out.println(mapa);

// Questão 6, adicione na interface
        
        Arvore arvore = new Arvore();
        
        Lista lista2 = new Lista();
        
        while (iterador.hasNext()) 
        {
            Senha u = iterador.next();
            
            String senha = u.getSenha();
            
            arvore.adicionar(senha);
            
            if(arvore.adicionar(senha) == false)
            {
                lista2.insere(senha);
            }
        }
        
        System.out.println(arvore.preOrdem(arvore.getRaiz()));
        
        System.out.println(arvore.emOrdem(arvore.getRaiz()));
        
        System.out.println(arvore.posOrdem(arvore.getRaiz()));
