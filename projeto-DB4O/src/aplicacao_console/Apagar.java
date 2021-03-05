package aplicacao_console;

import fachada.*;

public class Apagar {

	public Apagar() {
		
		try {
			Fachada.inicializar();
			
			System.out.println("Apagando... ");
			Fachada.apagarAssunto("youtube.com/poo");
			Fachada.apagarUsuario("carlos@email.com");
			Fachada.apagarVisualizacao(1);
			Fachada.apagarVideo("youtube.com/poo");
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
	
}
