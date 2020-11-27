package client;

import br.com.renanalencar.moreaqui.Estate;

public class App {
    public static void main(String[] args) throws Exception {
        Estate estate = new Estate("type", "size", "123", "inConstruction");

        DaoImpl daoImpl = new DaoImpl();
        Invoker invoker = new Invoker(DAO.HOST, DAO.PORT);
        SendData sendData = new SendData();
        sendData.setKey(1L);
        sendData.setValue(estate);
        invoker.invoke(daoImpl, sendData);

    }
}
