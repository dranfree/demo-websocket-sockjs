package com.dingdong.websocket.sockjs.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.net.URI;

/**
 * @author dingdong
 * @since 2021/02/03
 */
@Slf4j
@Component
public class EchoHandler extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) {
        URI uri = session.getUri();
        log.info("request uri: {}", uri);
        log.info("receive message from client: {}", message.getPayload());
    }

}
