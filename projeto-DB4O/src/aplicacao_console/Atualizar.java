package aplicacao_console;

import fachada.Fachada;

public class Atualizar {

	public Atualizar(){
		Fachada.inicializar();
		try {
			Fachada.adicionarAssunto("youtube.com/pob", "db40");
			System.out.println("adicionando mais um assunto no video");
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		Fachada.finalizar();
		System.out.println("fim do programa");
	}




	//=================================================
	public static void main(String[] args) {
		new Atualizar();
	}
}

