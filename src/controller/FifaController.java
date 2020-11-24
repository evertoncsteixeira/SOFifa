package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class FifaController implements IFifaController {

	@Override
	public Stack<String> empilhaBrasileiros(String caminho, String nome) throws IOException {
		File arq = new File (caminho,nome);
		Stack<String> pilha = new Stack();
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				
			    String[] v = linha.split("[,]");
				if (v[5].equals("Brazil")) {
					pilha.push(linha);	
				}
				linha = buffer.readLine();
			} 
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo não encontrado");
		}
		return pilha;
	}

	@Override
	public void desmpilhaBonsBrasileiros(Stack<String> pilha) throws IOException {
		int tamanhoP = pilha.size();
		String linha = new String();
		for (int i = 0; i < tamanhoP ; i++) {
			 linha = pilha.pop();
			 String[] v = linha.split("[,]");
			 	int valor = Integer.parseInt(v[7]);
				if (valor >= 80) {
					System.out.println(linha);	
				}
		}
	}

	@Override
	public List<String> listaRevelacoes(String caminho, String nome) throws IOException {
		File arq = new File (caminho,nome);
		List<String> lista = new ArrayList();
		if (arq.exists() && arq.isFile()) {
			FileInputStream fluxo = new FileInputStream(arq);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);
			String linha = buffer.readLine();
			linha = buffer.readLine();
			while (linha != null) {
				
			    String[] v = linha.split("[,]");
			    int idade = Integer.parseInt(v[3]);
				if (idade <= 20) {
					lista.add(linha);	
				}
				linha = buffer.readLine();
			} 
			
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new IOException("Arquivo não encontrado");
		}
		return lista;
	}

	@Override
	public void buscaListaBonsJovens(List<String> lista) throws IOException {
		int tamanhoP = lista.size();
		String linha = new String();
		for (int i = 1; i <= tamanhoP ; i++) {
			 linha = lista.get(tamanhoP-i);
			 String[] v = linha.split("[,]");
			 	int valor = Integer.parseInt(v[7]);
				if (valor >= 80) {
					System.out.println(linha);	
				}
		}
		
	}

}
