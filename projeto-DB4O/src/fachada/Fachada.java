package fachada;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
	
	public static Video cadastrarVideo(String link, String nome, String palavra) throws  Exception{
		DAO.begin();	
		Video v = daovideo.read(link);
		if(v != null) {
			DAO.rollback();
			throw new Exception("video ja cadastrado:" + link);
		}
		
		LocalDateTime currentDateTime = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String dataStr = currentDateTime.format(formatter);
		
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
	
	public static void registrarVisualizacao(String link, String email, int nota) throws Exception{
		DAO.begin();
		Video video = daovideo.read(link);
		if(video == null) {
			DAO.rollback();
			throw new Exception("video inexistente:" + link);
		}
		Usuario usuario = daousuario.read(email);
		if(usuario == null) {
			//DAO.rollback();
			//throw new Exception("usuario inexistente:" + email);
			usuario = cadastrarUsuario(email);
		}
		Visualizacao vis = new Visualizacao(nota, usuario, video);
		usuario.adicionar(vis);
		video.adicionar(vis);
		daovisualizacao.create(vis);
		DAO.commit();
		//id++;
	}
	
	public static Visualizacao localizarVisualizacao(int id) {
		DAO.begin();
		Visualizacao vis = daovisualizacao.read(id);
		if(vis == null) {
			DAO.rollback();
			return null;
		}else {
			return vis;	
		} 
	}
	
	public static void apagarVisualizacao(int id) throws Exception {
		DAO.begin();
		Visualizacao visual = localizarVisualizacao(id);
		// verifica se a visualizacao existe
		if(visual == null) {
			DAO.rollback();
			throw new Exception("Visualizacao de id " + id + " inexistente");
		}
		daovisualizacao.delete(visual);
		DAO.commit();
	}
	
	//Métodos de listagem
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
	
	public static List<Video> consultarVideosPorAssunto(String palavra) {
		return daovideo.consultarVideosPorAssunto(palavra); 
	}
	
	public static List<Video> consultarVideosPorUsuario(String email) {
		return daovideo.consultarVideosPorUsuario(email);
	}
	
	public static List<Usuario> consultarUsuarioPorVideo(String link) {
		return daousuario.consultarUsuarioPorVideo(link);
		
	}
}
