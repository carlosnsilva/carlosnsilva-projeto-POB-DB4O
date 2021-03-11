package aplicacao_console;

import fachada.*;

public class Apagar {

	public Apagar() {
		
		try {
			Fachada.inicializar();
			
			System.out.println("Apagando... ");
			Fachada.apagarVisualizacao(8);
			Fachada.apagarVisualizacao(9);
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void apagar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Apagar();
	}
		
}
