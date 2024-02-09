package com.tinnova.recrutamento.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/somamultiplos")
public class SomaMultiplosController {

    @PostMapping("/calcular")
    public Integer calcular(@RequestBody Integer payload) {
        Integer x = 3;
        Integer z = 5;
        Integer res = 0;

        for(Integer i = 0; i < payload; i++){
            if(i % x == 0 || i % z == 0){
                res += i;
            }
        }
        return res;
    }
}