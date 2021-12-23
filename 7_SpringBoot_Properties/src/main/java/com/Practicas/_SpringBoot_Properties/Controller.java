package com.Practicas._SpringBoot_Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class Controller {
    @Autowired
    AllProperties propiedades;


    @RequestMapping(value = "/valores", method = GET)
    public String getValues(){
        return "Valor de var1 es: " + propiedades.getVar1()+ ".   Valor de my.var2 es: " + propiedades.getVar2();
    }

    @RequestMapping(value = "/var3", method = GET)
    public String getValue3(){
        return "Valor de var3 es: " + propiedades.getVar3()+ ". ";
    }
}
