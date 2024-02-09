package com.tinnova.recrutamento.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bubblesort")
public class BubbleSortController {

    @PostMapping("/ordenar")
    public Integer[] ordenar(@RequestBody Integer[] payload) {
        Integer aux = 0;
        Integer i = 0;

        for(i = 0; i<payload.length; i++){
            for(Integer j = 0; j<payload.length-1; j++){
                if(payload[j] > payload[j + 1]){
                    aux = payload[j];
                    payload[j] = payload[j+1];
                    payload[j+1] = aux;
                }
            }
        }
        return payload;
    }
}