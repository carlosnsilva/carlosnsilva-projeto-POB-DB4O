import com.db4o.Db4oEmbedded;
import com.db4o.ObjectContainer;
import com.db4o.config.EmbeddedConfiguration;
import com.db4o.cs.Db4oClientServer;
import com.db4o.cs.config.ClientConfiguration;

import modelo.*;

public class Cadastrar {
    protected static ObjectContainer manager;

    public Cadastrar(){
        abrirBancoLocal();
    }

    public void abrirBancoLocal(){
        EmbedderConfiguration config = Db4oEmbedder.newConfiguration();

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
            manager.close()
    }


}