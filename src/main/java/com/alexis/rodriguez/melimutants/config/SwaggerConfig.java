package com.alexis.rodriguez.melimutants.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;


@Configuration
public class SwaggerConfig {
	
	
//	public Docket configDocumentation() {
//		
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.alexis.rodriguez.melimutants.controllers"))
//				.paths(PathSelectors.any())
//				.build();
//	}
	
	@Bean
	public OpenAPI meliMutantOpenAPI() {
	      return new OpenAPI()
	              .info(new Info().title("Alexis Rodriguez - Meli Mutant API")
	              .description("Api de consulta DNA Mutante")
	              .version("v0.0.1"))
	              .externalDocs(new ExternalDocumentation()
	              );
	  }

}
