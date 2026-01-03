package br.com.concessionaria.vendas.config;

import br.com.concessionaria.vendas.model.Caminhao;
import br.com.concessionaria.vendas.model.Carro;
import br.com.concessionaria.vendas.repository.VeiculoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration // Indica que esta classe contém definições de configurações e Beans do Spring
public class DataInicializer {

    @Bean // Indica que o objeto retornado será gerenciado pelo Spring e poderá ser injetado em outros lugares
    CommandLineRunner iniDataBase(VeiculoRepository repository) {
        return args ->{
            //Criando um carro
            Carro c1 = new Carro();
            c1.setMarca("Toyota");
            c1.setModelo("Corolla");
            c1.setAno(2023);
            c1.setPreco(new BigDecimal("150000.00"));
            c1.setQuantidadePortas(4);
            c1.setTipoCombustivel("Flex");

            // Criando um caminhão
            Caminhao cam1 = new Caminhao();
            cam1.setMarca("Volvo");
            cam1.setModelo("FH 540");
            cam1.setAno(2022);
            cam1.setPreco(new BigDecimal("750000.00"));
            cam1.setQuantidadeEixos(6);
            cam1.setCapacidadeCargaToneladas(74.0);

            //Salvando no banco
                repository.save(c1);
                repository.save(cam1);

            System.out.println("Estoque inicial carregado com sucesso!");
        };
    }
}
