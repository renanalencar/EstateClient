package client;

import br.com.renanalencar.moreaqui.Estate;

public class ClientMainThread {
    public static void main(String[] args) throws Exception {
    	// declara e inicializa um objeto do tipo Estate
        Estate estate = new Estate("Casa", "Grande", "81999999999", "Em Construção");

        // declara uma implementação o DAO para realizar
        // as operações no "banco de dados" (Map) do lado do servidor
        DaoImpl daoImpl = new DaoImpl();
        // instancia um objeto do tipo Invoker para
        // invocar uma conexão com a aplicação servidor
        Invoker invoker = new Invoker(DAO.HOST, DAO.PORT);
        // Declara um objeto do tipo SendData
        // para serealizar um objeto do tipo Estate
        SendData sendData = new SendData();
        // configura a chave (id) do objeto
        sendData.setKey(1L);
        // configura o objeto que será enviado
        // via serialização
        sendData.setValue(estate);
        // invoker executa a ação de enviar os dados
        // serializados
        invoker.invoke(daoImpl, sendData);

    }
}
