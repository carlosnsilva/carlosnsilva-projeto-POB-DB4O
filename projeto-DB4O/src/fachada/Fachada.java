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
	
	public static List<Assunto> listarAssunto(){
		return daoassunto.readAll();
	}
	
	public static List<Visualizacao> listarVisualizacao(){
		return daovisualizacao.readAll();
	}
	
	public static void apagarAssunto(String link) throws Exception {
		DAO.begin();
		Assunto ass = daoassunto.read(link);
		
		// verificação se existe o assunto
		if(ass == null) {
			DAO.rollback();
			throw new Exception("Assunto inexistente: "+ link);
		}
		
		daoassunto.delete(ass);
		DAO.commit();
		
	}
	
	public static void apagarUsuario(String email) throws Exception {
		DAO.begin();
		Usuario usuario = daousuario.read(email);

		// verificação se existe o usuario
		if(usuario == null) {
			DAO.rollback();
			throw new Exception("Usuario inexistente: "+ email);
		}
		
		daousuario.delete(usuario);
		DAO.commit();
	}
	
	public static void apagarVisualizacao(Integer id) throws Exception {
		DAO.begin();
		Visualizacao visual = daovisualizacao.read(id);
		
		// verificação se existe o usuario
		if(visual == null) {
			DAO.rollback();
			throw new Exception("Visualizacao inexistente: "+ id.toString());
		}
		
		daovisualizacao.delete(visual);
		DAO.commit();
	}
	
	public static void apagarVideo(String link) throws Exception{
		DAO.begin();
		Video v = daovideo.read(link);
		
		// verificação se existe video
		if(v == null) {
			DAO.rollback();
			throw new Exception("Video inexistente: "+ link);
		}
		
		daovideo.delete(v);
		DAO.commit();
	}
	
	
}
