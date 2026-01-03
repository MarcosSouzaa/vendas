package br.com.concessionaria.vendas.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@DiscriminatorValue("CAMINHAO")
public class Caminhao extends Veiculo{
    private Integer quantidadeEixos;
    private Double capacidadeCargaToneladas;
}
