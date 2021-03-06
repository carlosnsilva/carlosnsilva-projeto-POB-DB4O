package modelo;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double media;
	private LocalDateTime dataHora;
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video(String link, String nome, String palavra, String dataStr) {
		this.link = link;
		this.nome = nome;
		this.assuntos.add(new Assunto(palavra));
		try {
			dataHora = LocalDateTime.parse(dataStr, DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));	
		} 
		catch (DateTimeParseException e) {
			throw new RuntimeException("formato datahora deve ser 00/00/0000 00:00");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getLink() {
		return link;
	}
	
	public double getMedia() {
		double total = 0;
		for(Visualizacao v : visualizacoes) {
		    total += v.getNota();
		}
		media = total / visualizacoes.size();
		return media;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	@Override
	public String toString() {
		String texto = "\nVideo [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + getMedia() + ", " + "dataHora=" + dataHora;
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra() + ",";
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			//texto += vis;
			texto += (vis != null ? vis + ", " : "");
		}
		return texto;
	}
}
