package com.tinnova.recrutamento.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/fatorial")
public class FatorialController {

    @PostMapping("/calcular")
    public String calcular(@RequestBody Integer payload) {
        Long fat=1L;
        String mult="";
        for (Integer i=payload; i>1; i--){
            fat *=i;
            mult +=i+" x ";
        }
        return String.valueOf(mult)+"1 = "+String.valueOf(fat);
    }
}