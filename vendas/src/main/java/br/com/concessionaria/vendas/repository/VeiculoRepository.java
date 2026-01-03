package br.com.concessionaria.vendas.repository;

import br.com.concessionaria.vendas.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    /*
    * Apenas com essa linha, você já tem: save(), findAll(), findById(), delete()...
    * Ao dar um extends JpaRepository, o Spring entende que você quer todas as operações de banco de dados para
    * a entidade Veiculo (que tem ID do tipo Long).*/
}
