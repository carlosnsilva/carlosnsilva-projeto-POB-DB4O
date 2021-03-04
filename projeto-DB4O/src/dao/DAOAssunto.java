/**IFPB - Curso SI - Disciplina de POB
 * @author Prof Fausto Ayres
 */
package dao;

import java.util.List;
import com.db4o.query.Query;
import modelo.Assunto;

public class DAOAssunto  extends DAO<Assunto>{

	public Assunto read (Object chave) {
		String pal = (String) chave;
		
		Query q = manager.query();
		q.constrain(Assunto.class);
		q.descend("palavra").constrain(pal);
		List<Assunto> resultados = q.execute();
		if (resultados.size()>0)
			return resultados.get(0);
		else
			return null;
	}
}

