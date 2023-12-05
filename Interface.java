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

        Iterator<Senha> iterador2 = lista.iterator();
        
        Arvore arvore = new Arvore();
        
        Lista lista2 = new Lista();
        

        while (iterador2.hasNext()) 
        {
            Senha u = iterador2.next();
            
            if(arvore.adicionar(u) == true)
            {
                
            }
            
            else
            {
                lista2.insere(u);
            }
        }
        
        System.out.println(arvore.preOrdem(arvore.getRaiz()));
        
        System.out.println(arvore.emOrdem(arvore.getRaiz()));
        
        System.out.println(arvore.posOrdem(arvore.getRaiz()));
        
        System.out.println(lista2.toString());
