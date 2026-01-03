package br.com.concessionaria.vendas.controller;

import br.com.concessionaria.vendas.model.Veiculo;
import br.com.concessionaria.vendas.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@CrossOrigin("*")
@RestController // Define que esta classe é uma API REST
@RequestMapping("/api/veiculos") // A URL base será localhost:8080/api/veiculos
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @GetMapping // Quando alguém acessar a URL via GET, este method roda
    public List<Veiculo> listarTodos() {
        return service.listarTodos();
    }

    @PostMapping
    //// Para cadastrar um novo veículo via POST
    public Veiculo salvar(@RequestBody Veiculo veiculo) {
        return service.salvarVeiculo(veiculo);
    }

    @DeleteMapping("/{id}") // A URL será algo como /api/veiculos/1
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
