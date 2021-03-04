package fachada;

import java.util.List;

import dao.DAO;
import dao.DAOAssunto;
import dao.DAOUsuario;
import dao.DAOVideo;
import dao.DAOVisualizacao;
import modelo.Assunto;
import modelo.Usuario;
import modelo.Video;
import modelo.Visualizacao;

public class Fachada {
	private static DAOAssunto daoassunto = new DAOAssunto();  
	private static DAOUsuario daousuario = new DAOUsuario();  
	private static DAOVideo daovideo = new DAOVideo();
	private static DAOVisualizacao daovisualizacao = new DAOVisualizacao();

	 
	public static void inicializar(){
		DAO.open();
	}
	public static void finalizar(){
		DAO.close();
	}
	
	public static Video cadastrarVideo(String link, String nome, String palavra, String dataStr) throws  Exception{
		DAO.begin();	
		Video v = daovideo.read(nome);
		if(v != null) {
			DAO.rollback();
			throw new Exception("video ja cadastrado:" + nome);
		}
		v = new Video(link, nome, palavra, dataStr);
		daovideo.create(v);	
		DAO.commit();
		return v;
	}
	
	public static Usuario cadastrarUsuario(String email) throws  Exception{
		DAO.begin();	
		Usuario u = daousuario.read(email);
		if(u != null) {
			DAO.rollback();
			throw new Exception("usuario ja cadastrado:" + email);
		}
		u = new Usuario(email);
		daousuario.create(u);	
		DAO.commit();
		return u;
	}
	
	public static void adicionarAssunto(String link, String assunto) throws  Exception{
		DAO.begin();	
		Video v = daovideo.read(link);	
		if(v == null) {
			DAO.rollback();	
			throw new Exception("video inexistente:" + link);
		}

		v.adicionar(new Assunto(assunto));

		daovideo.update(v);		
		DAO.commit();
	}
	
	public static List<Video> listarVideos(){
		return daovideo.readAll();
	}
	
	public static List<Usuario> listarUsuarios(){
		return daousuario.readAll();
	}
}
