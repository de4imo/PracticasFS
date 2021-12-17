package com.Practicas._SpringBootI_RS1_controladores;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController("/")
public class Controller {

    //Petición POST: mandando un objeto JSON en el body y recibiendo ese mismo objeto JSON en la respuesta (en el body).
    @PostMapping("")
    public Object getObjectGiveObjectPOST(@RequestBody Object obj){
        return obj;
    }


    //Petición GET: mandando parámetros en el path (http://localhost:8080/user/{id})
    //http://localhost:8080/user/?id=12121212
    @GetMapping("user/")
    public String getObjectGiveObjectGET(@RequestParam(value = "id", defaultValue = "ID NOT SET") String id){
        return id;
    }

    //Petición PUT: mandando Request Params (http://localhost:8080/post?var1=1&var2=2)
    @PutMapping("post/")
    public String getObjectGiveObjectPUT(@RequestParam(value = "var1", defaultValue = "VAR1 NOT SET") String stringVar1,
                                         @RequestParam(value = "var2", defaultValue = "VAR2 NOT SET") String stringVar2){
        return "var1: " + stringVar1 + ",\n" + "var2: " + stringVar2;
    }
}
