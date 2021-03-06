package aplicacao_console;

import fachada.Fachada;

public class Consultar {

	public Consultar(){

		try {
			Fachada.inicializar();
			System.out.println("1.video por assunto 'persistencia'\n"+Fachada.consultarVideosPorAssunto("persistencia")+"\n");
			System.out.println("2.video pelo usuario 'guilherme@email.com'\n"+Fachada.consultarVideosPorUsuario("guilherme@email.com")+"\n");
			System.out.println("3.usuario por video 'youtube.com/pob'\n"+Fachada.consultarUsuarioPorVideo("youtube.com/pob")+"\n");
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}finally {
			Fachada.finalizar();
		}
		System.out.println("\nfim do programa");
	}


	//=================================================
	public static void main(String[] args) {
		new Consultar();
	}
}

