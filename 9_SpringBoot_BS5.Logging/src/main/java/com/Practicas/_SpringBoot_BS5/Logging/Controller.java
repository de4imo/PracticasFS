package com.Practicas._SpringBoot_BS5.Logging;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@Slf4j
public class Controller {


    @RequestMapping(value = "/logs", method = GET)
    public String logs(){
        log.trace("Esto es un log.trace");
        log.debug("Esto es un log.debug");
        log.info("Esto es un log.info");
        log.warn("Esto es un log.warn");
        log.error("Esto es un log.error");

        log.trace("Esto es un log.trace");
        log.debug("Esto es un log.debug");
        log.info("Esto es un log.info");
        log.warn("Esto es un log.warn");
        log.error("Esto es un log.error");

        log.trace("Esto es un log.trace");
        log.debug("Esto es un log.debug");
        log.info("Esto es un log.info");
        log.warn("Esto es un log.warn");
        log.error("Esto es un log.error");
        return "logs";
    }
}
