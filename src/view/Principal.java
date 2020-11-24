package view;

import java.io.IOException;

import controller.FifaController;
import controller.IFifaController;

public class Principal {

	public static void main(String[] args) {
		IFifaController arqCont = new FifaController();
		String dir = "C:\\TEMP";
		String arq = "data.csv";
		
		try {
			
			//arqCont.desmpilhaBonsBrasileiros(arqCont.empilhaBrasileiros(dir,arq));
			arqCont.buscaListaBonsJovens(arqCont.listaRevelacoes(dir,arq));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
