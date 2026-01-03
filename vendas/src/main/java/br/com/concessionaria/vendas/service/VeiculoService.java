package br.com.concessionaria.vendas.service;

import br.com.concessionaria.vendas.model.Veiculo;
import br.com.concessionaria.vendas.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Indica que esta classe contém a lógica de negócio
public class VeiculoService {

    @Autowired // O Spring injeta o repositório automaticamente aqui (Injeção de Dependência)
    private VeiculoRepository repository;

    /*Method buscar veículo
    * O findById do JPA já retorna um Optional. Usando o .orElseThrow(),
    * você garante que o código trate o erro de forma limpa*/
    public Veiculo buscarPorId(Long id) {
        // findById do JPA já retorna um Optional
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veículo não encontrado com o ID: " + id));
    }

    // Method para listar todos os veículos
    public List<Veiculo> listarTodos(){
        return repository.findAll();
    }
    // Method para salvar um novo veículo
    public Veiculo salvarVeiculo(Veiculo veiculo){
        //// Aqui poderíamos colocar regras, como: "Não aceitar veículos com ano futuro"
        return repository.save(veiculo);
    }
    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
