package com.dingdong.websocket.sockjs.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

/**
 * @author dingdong
 * @since 2021/02/03
 */
@Slf4j
@Controller
public class EchoController {

    @MessageMapping("/hola")
    public String hello() {
        log.info("hola...");
        return "world!!!";
    }
}
