package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Video;

public class DAOVideo extends DAO<Video>{

	public Video read (Object chave) {
		String nome = (String) chave;
		
		Query q = manager.query();
		q.constrain(Video.class);
		q.descend("nome").constrain(nome);
		List<Video> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}

