package aplicacao_console;

import fachada.Fachada;
import modelo.Usuario;
import modelo.Video;

public class Listar {

	public Listar(){
		try {
			Fachada.inicializar();

			System.out.println("Listagem de videos:");
			for(Video v : Fachada.listarVideos() )		
				System.out.println(v);
			
			System.out.println("Listagem de usuarios:");
			for(Usuario u : Fachada.listarUsuarios() )		
				System.out.println(u);

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
