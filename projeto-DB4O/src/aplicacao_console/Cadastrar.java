package aplicacao_console;

import dao.DAO;

import com.db4o.config.EmbeddedConfiguration;
import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;
import modelo.*;

import modelo.*;

public class Cadastrar {
    protected static ObjectContainer manager;

    public Cadastrar(){
        abrirBancoLocal();
        this.cadastrar();
        this.fecharBanco();
        System.out.println("Encerrando aplicacao");
    }

    public void abrirBancoLocal(){

    	EmbeddedConfiguration config = Db4oEmbedded.newConfiguration();

        config.common().messageLevel(0);  // 0,1,2,3...
        config.common().objectClass(Assunto.class).cascadeOnDelete(true);;
        config.common().objectClass(Assunto.class).cascadeOnUpdate(true);;
        config.common().objectClass(Assunto.class).cascadeOnActivate(true);
        config.common().objectClass(Usuario.class).cascadeOnDelete(true);;
        config.common().objectClass(Usuario.class).cascadeOnUpdate(true);;
        config.common().objectClass(Usuario.class).cascadeOnActivate(true);
        config.common().objectClass(Video.class).cascadeOnDelete(true);;
        config.common().objectClass(Video.class).cascadeOnUpdate(true);;
        config.common().objectClass(Video.class).cascadeOnActivate(true);
        config.common().objectClass(Visualizacao.class).cascadeOnDelete(true);;
        config.common().objectClass(Visualizacao.class).cascadeOnUpdate(true);;
        config.common().objectClass(Visualizacao.class).cascadeOnActivate(true);
        manager = 	Db4oEmbedded.openFile(config, "banco.db4o");
    }

    public void fecharBanco(){
        if(manager != null)
            manager.close();
    }

    public void cadastrar() {
    	
    	System.out.println("Cadastrando");
    	
    	Video v1 = new Video("Favorito","O Cego Espiao");
    	v1.adicionar(new Assunto("Acao"));
    	v1.adicionar(new Visualizacao(1,9,new Usuario("usuario@eu.com"),v1));
    	// Salvando o objeto
    	manager.store(v1);
    	manager.commit();
    }
    
    
    public static void main(String[] args) {
		new Cadastrar();
	}


}