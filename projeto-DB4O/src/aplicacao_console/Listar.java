package aplicacao_console;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();

			System.out.println("\nListagem de videos:");
			for(Video v : Fachada.listarVideos() )		
				System.out.println(v + "\n");
			
			System.out.println("\nListagem de usuarios:");
			for(Usuario u : Fachada.listarUsuarios() )		
				System.out.println(u + "\n");
			
			System.out.println("\nListagem de visualizaçoes:");
			for(Visualizacao vis : Fachada.listarVisualizacao() )		
				System.out.println(vis + "\n");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
	}


	//=================================================
	public static void main(String[] args) {
		new Listar();
	}
}
