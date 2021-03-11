package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Visualizacao {
	private static int counter = 0;
	private int id;
	private LocalDateTime datahora = LocalDateTime.now();
	private int nota;
	private Usuario usuario;
	private Video video;
	
	public Visualizacao(int nota, Usuario usuario, Video video) {
		this.id = ++counter;
		this.nota = nota;
		this.usuario = usuario;
		this.video = video;
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getDataHora() {
		return this.datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss"));
	}
	
	public String getUsuario() {
		return this.usuario.getEmail();
	}
	
	public String getVideo() {
		return this.video.getLink();
	}
	
	public int getNota() {
		return this.nota;
	}

	@Override
	public String toString() {
		return "[id=" + id + 
				", datahora=" + datahora.format(DateTimeFormatter.ofPattern("dd/MM/yyy hh:mm:ss")) + 
				", nota=" + nota +
				"\n usuario=" + usuario.getEmail() + ", video=" + video.getNome() + "]"; 
	}
}
