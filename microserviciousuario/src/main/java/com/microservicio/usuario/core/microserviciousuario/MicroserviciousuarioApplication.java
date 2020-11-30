package com.microservicio.usuario.core.microserviciousuario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.commonsalumnos.commonsalumnos.models.entity"})
public class MicroserviciousuarioApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviciousuarioApplication.class, args);
	}

}
