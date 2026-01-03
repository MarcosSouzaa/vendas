package br.com.concessionaria.vendas.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data // O Lombok cria Getters, Setters e toString sozinho
@EqualsAndHashCode(callSuper = true) //compara aqui e também se são iguais na super classe
@Entity // Avisa ao Hibernate que isso vira uma tabela no banco
@DiscriminatorValue("CARRO")
public class Carro extends Veiculo{
    private Integer quantidadePortas;
    private  String tipoCombustivel;
}
