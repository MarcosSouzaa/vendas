package br.com.concessionaria.vendas.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;

import java.math.BigDecimal;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type" // Isso cria um campo extra no JSON para decidirmos o tipo
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Carro.class, name = "carro"),
        @JsonSubTypes.Type(value = Caminhao.class, name = "caminhao")
})
@Data // O Lombok cria Getters, Setters e toString sozinho
@Entity // Avisa ao Hibernate que isso vira uma tabela no banco
@Inheritance(strategy = InheritanceType.JOINED ) // Estratégia de herança para o banco
@DiscriminatorColumn(name = "tipo_veiculo") // Cria uma coluna oculta para o tipo
public abstract class Veiculo {

    @Id //indica ao Spring Data JPA que o atributo logo abaixo dele é o identificador exclusivo daquela entidade

    /* Enquanto o @Id diz qual é a chave, o @GeneratedValue diz como ela deve ser criada.
     * @GeneratedValue: Indica que o valor do ID será gerado automaticamente pelo sistema, e não preenchido manualmente
       por você no código Java.
     * strategy = GenerationType.IDENTITY: Esta estratégia específica delega a responsabilidade de criar o número para
       o banco de dados.
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    private Long id;

    private String marca;
    private String modelo;
    private Integer ano;
    // BigDecimal é o padrão ouro para dinheiro em Java (evita erros de centavos)
    private BigDecimal preco;
}
