package websocket;

import javax.websocket.OnMessage;
import javax.websocket.PongMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.nio.ByteBuffer;

import static java.lang.System.out;

/**
 * Created on 22/01/16.
 *
 * @author hhernandez
 */
@ServerEndpoint("/receive")
public class ReceiveEndpoint {
    @OnMessage
    public void textMessage(Session session , String msg) {
        out.println("Text message : " + msg);
    }

    @OnMessage
    public void binaryMessage(Session session, ByteBuffer msg) {
        out.println("Binary message: " + msg.toString());
    }

    @OnMessage
    public void pongMessage(Session session, PongMessage msg) {
        out.println("Pong message: " + msg.getApplicationData().toString());
    }
}
