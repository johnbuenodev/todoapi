package com.john.todonovo;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.john.todonovo.domain.Todo;
import com.john.todonovo.repositories.TodoRepository;

@SpringBootApplication
public class TodoNovoApplication implements CommandLineRunner {
	
	@Autowired
	private TodoRepository todorepository;

	public static void main(String[] args) {
		SpringApplication.run(TodoNovoApplication.class, args);
	}

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

        
	}

}
