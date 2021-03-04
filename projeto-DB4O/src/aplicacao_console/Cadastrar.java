package aplicacao_console;

import fachada.Fachada;

public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			Fachada.cadastrarVideo("youtube.com/pob", "aula 1-pob", "persistência", "04/03/2021 11:00:00");
			Fachada.cadastrarVideo("youtube.com/poo", "aula 1-poo", "objetos", "04/03/2021 12:00:00");
			Fachada.cadastrarUsuario("carlos@email.com");
			Fachada.cadastrarUsuario("guilherme@email.com");
			
			
		} catch (Exception e) 	{
			System.out.println(e.getMessage());
		}
		finally {
			Fachada.finalizar();
		}
		System.out.println("fim do programa");
	}


	public void cadastrar(){

	}	


	//=================================================
	public static void main(String[] args) {
		new Cadastrar();
	}
}