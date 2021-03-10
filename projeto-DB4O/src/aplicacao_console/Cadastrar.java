package aplicacao_console;

import fachada.Fachada;

public class Cadastrar {

	public Cadastrar(){
		try {
			Fachada.inicializar();
			
			System.out.println("cadastrando...");
			
			Fachada.cadastrarVideo("youtube.com/pob", "aula 1-pob", "persistencia");
			Fachada.cadastrarVideo("youtube.com/poo", "aula 1-poo", "objetos");
			Fachada.cadastrarVideo("youtube.com/pweb", "aula 1-pweb", "typescript");
			Fachada.cadastrarVideo("youtube.com/bd2", "aula 1-bd2", "postgreSql");
			
			Fachada.cadastrarUsuario("carlos@email.com");
			Fachada.cadastrarUsuario("guilherme@email.com");
			Fachada.cadastrarUsuario("jack@email.com");
			Fachada.cadastrarUsuario("david@email.com");
			
			Fachada.registrarVisualizacao("youtube.com/pob", "carlos@email.com", 5); 
			Fachada.registrarVisualizacao("youtube.com/pob", "guilherme@email.com", 5);
			Fachada.registrarVisualizacao("youtube.com/poo", "jack@email.com", 4);
			Fachada.registrarVisualizacao("youtube.com/poo", "david@email.com", 4);
			Fachada.registrarVisualizacao("youtube.com/pweb", "carlos@email.com", 5);
			Fachada.registrarVisualizacao("youtube.com/pweb", "guilherme@email.com", 5);
			Fachada.registrarVisualizacao("youtube.com/bd2", "jack@email.com", 3);
			Fachada.registrarVisualizacao("youtube.com/bd2", "david@email.com", 3);
			
			
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