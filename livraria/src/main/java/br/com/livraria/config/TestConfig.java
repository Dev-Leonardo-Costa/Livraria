package br.com.livraria.config;

import br.com.livraria.service.DBService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {

    @Autowired
    private DBService dbService;

    @Bean
    public void instaciarBaseDeDados(){
        this.dbService.instanciaBaseDeDados();
    }
}
