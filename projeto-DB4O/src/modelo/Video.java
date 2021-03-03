package modelo;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Video {
	private String link;
	private String nome;
	private double media;
	private LocalDateTime dataHora;
	private List<Assunto> assuntos = new ArrayList<>();
	private List<Visualizacao> visualizacoes = new ArrayList<>();

	
	public Video(String link, String nome, ArrayList<Assunto> assuntos) {
		this.link = link;
		this.nome = nome;
		this.assuntos = assuntos;
		this.dataHora = LocalDateTime.now();
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getLink() {
		return link;
	}

	public void adicionar(Assunto a) {
		assuntos.add(a);
	}
	
	public void adicionar(Visualizacao vis) {
		visualizacoes.add(vis);
	}

	@Override
	public String toString() {
		String texto = "Video [" + (link != null ? "link=" + link + ", " : "") + (nome != null ? "nome=" + nome + ", " : "")
				+ "media=" + media ;
		
		texto+=", assuntos=";
		for(Assunto a : assuntos) {
			texto += a.getPalavra();
		}
		texto+="\n visualizacoes=";
		for(Visualizacao vis : visualizacoes) {
			texto += vis;
		}
		return texto;
	}
}
