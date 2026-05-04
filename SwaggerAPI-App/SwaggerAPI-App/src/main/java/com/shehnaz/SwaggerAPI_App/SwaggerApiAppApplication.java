package com.shehnaz.SwaggerAPI_App;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(title="Tourist API",version="1.0",description="API for Tourist"), servers = @Server(
		url="http://localhost:8080",
		description = "This app deploy on Local Server"
))
public class SwaggerApiAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SwaggerApiAppApplication.class, args);
	}

}
