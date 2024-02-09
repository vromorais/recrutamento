package com.tinnova.recrutamento.controller;

import com.tinnova.recrutamento.model.Veiculo;
import com.tinnova.recrutamento.model.repository.VeiculoRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/veiculo")
public class VeiculoController {
    @Autowired
    private VeiculoRepository veiculoRepository;

    @PostMapping("/veiculos")
    public String criarVeiculo(@RequestBody Veiculo payload) throws Exception {
        payload.setCreated(LocalDateTime.now());
        veiculoRepository.save(payload);
        return ("Veículo criado com sucesso.");
    }

    @PutMapping("/veiculos/{id}")
    public String atualizarVeiculo(@PathVariable long id, @RequestBody Veiculo payload) throws Exception {
        try {
            Veiculo updateVeiculo = veiculoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado"));
            updateVeiculo.setVeiculo(payload.getVeiculo());
            updateVeiculo.setAno(payload.getAno());
            updateVeiculo.setDescricao(payload.getDescricao());
            updateVeiculo.setMarca(payload.getMarca());
            updateVeiculo.setVendido(payload.getVendido());
            updateVeiculo.setUpdated(LocalDateTime.now());
            veiculoRepository.save(updateVeiculo);
            return "Veículo atualizado com sucesso.";
        } catch (ResourceNotFoundException re) {
            return "Veículo não encontrado na base de dados.";
        }
    }

    @PatchMapping("/veiculos/{id}")
    public String atualizarVeiculoParcial(@PathVariable long id, @RequestBody Veiculo payload) throws Exception {
        try {
            Veiculo updateVeiculo = veiculoRepository.findById(id)
                    .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado"));
            updateVeiculo.setVeiculo(Objects.isNull(payload.getVeiculo()) ? updateVeiculo.getVeiculo() : payload.getVeiculo());
            updateVeiculo.setAno(Objects.isNull(payload.getAno()) ? updateVeiculo.getAno() : payload.getAno());
            updateVeiculo.setDescricao(Objects.isNull(payload.getDescricao()) ? updateVeiculo.getDescricao() : payload.getDescricao());
            updateVeiculo.setMarca(Objects.isNull(payload.getMarca()) ? updateVeiculo.getMarca() : payload.getMarca());
            updateVeiculo.setVendido(Objects.isNull(payload.getVendido()) ? updateVeiculo.getVendido() : payload.getVendido());
            updateVeiculo.setUpdated(LocalDateTime.now());
            veiculoRepository.save(updateVeiculo);
            return "Veículo atualizado com sucesso.";
        } catch (ResourceNotFoundException re) {
            return "Veículo não encontrado na base de dados.";
        }
    }

    @GetMapping("/veiculos/{id}")
    public Veiculo consultarVeiculo(@PathVariable Long id) throws Exception {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado"));
        return veiculo;
    }

    @GetMapping("/veiculos/")
    public List<Veiculo> consultarTodosVeiculos() throws Exception {
        List<Veiculo> listaVeiculos = veiculoRepository.findAll();
        return listaVeiculos;
    }

    @DeleteMapping("/veiculos/{id}")
    public String deletarVeiculo(@PathVariable Long id) throws Exception {
        Veiculo veiculo = veiculoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Veiculo não encontrado"));
        veiculoRepository.delete(veiculo);
        return "Veículo deletado com sucesso.";
    }
}


