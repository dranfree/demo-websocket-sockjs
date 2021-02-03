package com.dingdong.websocket.sockjs.config;

import com.dingdong.websocket.sockjs.handler.EchoHandler;
import com.dingdong.websocket.sockjs.handler.EchoHandshakeInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * The SockJS client begins by sending "GET /info" to obtain basic information from the server.
 * After that it must decide what transport to use.
 * If possible WebSocket is used.
 * If not, in most browsers there is at least one HTTP streaming option and if not then HTTP (long) polling is used.
 * <p>
 * SockJS request URL:
 * <p>
 * http://host:port/myApp/myEndpoint/{server-id}/{session-id}/{transport}
 *
 * @author dingdong
 * @since 2021/02/03
 */
@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    @Autowired
    private EchoHandler echoHandler;

    @Autowired
    private EchoHandshakeInterceptor handshakeInterceptor;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoHandler, "/echo", "/noise")
                .setAllowedOrigins("http://www.easyswoole.com", "http://localhost:8081")
                .addInterceptors(handshakeInterceptor)
                .withSockJS();
    }
}
