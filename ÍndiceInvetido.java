package Classe;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class IndiceInvertido {
    
    public static void main(String[] args) {
        // Criamos um mapa para armazenar o índice invertido
        Map<String, Integer> indice = new HashMap<String, Integer>();
        // Criamos um leitor de arquivo
        BufferedReader leitor = null;
        try {
            // Pedimos ao usuário que digite o endereço do arquivo de texto com as senhas
            System.out.println("Digite o endereço do arquivo de texto com as senhas:");
            // Criamos um scanner para ler a entrada do usuário
            Scanner scanner = new Scanner(System.in);
            // Lemos o endereço do arquivo
            String endereco = scanner.nextLine();
            // Fechamos o scanner
            scanner.close();
            // Abrimos o arquivo para leitura
            leitor = new BufferedReader(new FileReader(endereco));
            // Lemos a primeira linha do arquivo
            String linha = leitor.readLine();
            // Enquanto houver linhas no arquivo
            while (linha != null) {
                // Removemos os espaços em branco da linha
                linha = linha.trim();
                // Se a linha não estiver vazia
                if (!linha.isEmpty()) {
                    // Verificamos se o mapa já contém a senha da linha
                    if (indice.containsKey(linha)) {
                        // Se sim, incrementamos a contagem da senha
                        indice.put(linha, indice.get(linha) + 1);
                    } else {
                        // Se não, adicionamos a senha com a contagem inicial de 1
                        indice.put(linha, 1);
                    }
                }
                // Lemos a próxima linha do arquivo
                linha = leitor.readLine();
            }
            // Imprimimos o índice invertido
            System.out.println("Índice invertido:");
            for (Map.Entry<String, Integer> entrada : indice.entrySet()) {
                System.out.println(entrada.getKey() + " - " + entrada.getValue());
            }
        } catch (IOException e) {
            // Se ocorrer algum erro de entrada ou saída, imprimimos a mensagem de erro
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } finally {
            // Fechamos o leitor de arquivo, se ele não for nulo
            if (leitor != null) {
                try {
                    leitor.close();
                } catch (IOException e) {
                    // Se ocorrer algum erro ao fechar o leitor, imprimimos a mensagem de erro
                    System.out.println("Erro ao fechar o arquivo: " + e.getMessage());
                }
            }
        }
    }
}
