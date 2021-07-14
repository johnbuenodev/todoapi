package com.john.todonovo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import com.john.todonovo.domain.Todo;
import com.john.todonovo.repositories.TodoRepository;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class TodoNovoApplication extends SpringBootServletInitializer {
	///CommandLineRunner
	
	//@Autowired
	//private TodoRepository todorepository;

	public static void main(String[] args) throws ParseException {
		SpringApplication.run(TodoNovoApplication.class, args);
		
		
	}
    //http://localhost:8080/swagger-ui/
	//http://localhost:8080/v2/api-docs/
	
	@Bean
	public Docket swaggerConfiguration(){
		
		
		///default .paths(PathSelectors.ant("/api*"))
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.paths(PathSelectors.ant("/**"))
				.apis(RequestHandlerSelectors.basePackage("com.john.todonovo"))
				.build()
				.apiInfo(this.apiDetails());
		
	}
	
	private ApiInfo  apiDetails() {
	
		return new ApiInfo(
				"Todo Api",
				"Api Exemplo",
				"1.0",
				"Uso Livre",
				new springfox.documentation.service.Contact("João Paulo R Bueno", "https://github.com/johnbuenodev", ""),
				"API License",
				"https://github.com/johnbuenodev",
				Collections.emptyList());
		
	}
	

	
	/*
	@Override
	public void run(String... args) throws Exception {
// "dd/MM/yyyy HH:mm"
				SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

				Todo t1 = new Todo(null, "nodejs", "inicial",
						formatter.parse("09/07/2022"), true);
				Todo t2 = new Todo(null, "PHP", "inicial",
						formatter.parse("09/07/2022"), true);
				Todo t3 = new Todo(null, "Typescript", "inicial",
						formatter.parse("09/07/2022"), false);
				Todo t4 = new Todo(null, "Java", "inicial",
						formatter.parse("09/07/2022"), false);
				Todo t5 = new Todo(null, "Solid", "avançado",
						formatter.parse("09/07/2022"), false);
				Todo t6 = new Todo(null, "Spring", "intermediario",
						formatter.parse("09/07/2022"), true);
				Todo t7 = new Todo(null, "Angular", "intermediario",
						formatter.parse("09/07/2022"), false);

				todorepository.saveAll(Arrays.asList(t1,t2,t3,t4,t5,t6,t7));
        
	} */
}
