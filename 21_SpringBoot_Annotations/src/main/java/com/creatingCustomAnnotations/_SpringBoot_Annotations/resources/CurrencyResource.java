package com.creatingCustomAnnotations._SpringBoot_Annotations.resources;

import com.creatingCustomAnnotations._SpringBoot_Annotations.aop.SaveInFile;
import com.creatingCustomAnnotations._SpringBoot_Annotations.services.CurrencyService;
import com.creatingCustomAnnotations._SpringBoot_Annotations.util.CurrencyEnum;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.Map;

@RestController
public class CurrencyResource {

    @Autowired
    CurrencyService service;

    @GetMapping("/index")
    public ResponseEntity<List<CurrencyEnum>> index(){

        return  ResponseEntity.ok(this.service.index());
    }

    //http://localhost:8080/exchange/USD?amount=10.333
    @GetMapping("/exchange/{currency}")
    @SaveInFile("files/currencies.txt")
    public ResponseEntity<Map<String, Double>> exchange(@PathVariable CurrencyEnum currency, @RequestParam Double amount){
    //public ResponseEntity<Map<String, Double>> exchange(@PathVariable CurrencyEnum currency, @PathParam("currency") Double amount){
        return ResponseEntity.ok(this.service.exchange(currency, amount));
    }
}
