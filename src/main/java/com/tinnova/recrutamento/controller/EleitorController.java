package com.tinnova.recrutamento.controller;

import com.tinnova.recrutamento.model.Eleitor;
import com.tinnova.recrutamento.model.Voto;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/eleitor")
public class EleitorController {

    @GetMapping("/calcular")
    public Voto calcular(@RequestBody Eleitor payload) {
        Voto voto = new Voto();
        voto.setPercVotosValidos(calculaValidos(payload));
        voto.setPercVotosBrancos(calculaBrancos(payload));
        voto.setPercVotosNulos(calculaNulos(payload));
        return voto;
    }

    private Double calculaValidos(Eleitor eleitor) {
        return eleitor.getValidos().doubleValue()/eleitor.getTotalEleitores().doubleValue();
    }

    private Double calculaBrancos(Eleitor eleitor) {
        return eleitor.getBrancos().doubleValue()/eleitor.getTotalEleitores().doubleValue();
    }

    private Double calculaNulos(Eleitor eleitor) {
        return eleitor.getNulos().doubleValue()/eleitor.getTotalEleitores().doubleValue();
    }
}
