package com.paf.microservicio_cliente_paises;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.client.RestTemplate;

@ComponentScan(basePackages = {"controller","service"})
@EntityScan(basePackages = {"model"})
@SpringBootApplication
public class MicroservicioClientePaisesApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicioClientePaisesApplication.class, args);
    }

    @Bean
    public RestTemplate template(){
        return new RestTemplate();
    }

}
