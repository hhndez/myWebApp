package websocket;


import javax.websocket.Endpoint;
import javax.websocket.EndpointConfig;
import javax.websocket.MessageHandler;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpointConfig;
import java.io.IOException;

/**
 * Created on 22/01/16.
 *
 * @author hhernandez
 */
public class EchoEndpoint extends Endpoint {
    @Override
    public void onOpen(final Session session, EndpointConfig config) {
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String msg) {
                try {
                    session.getBasicRemote().sendText(msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        //EN algun lado hay que registrar el servicio
        ServerEndpointConfig.Builder.create(EchoEndpoint.class, "/echo").build();
        //Y se accesa de la siguiente forma:
        //ws://<host>:<port>/<application>/echo

    }
}
