package com.john.todonovo.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.todonovo.domain.Todo;
import com.john.todonovo.repositories.TodoRepository;

@Service
public class DBService {

	@Autowired
	private TodoRepository todorepository;

	public void instanciaBaseDeDados() throws ParseException {

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM//yyyy");

		Todo t1 = new Todo(null, "Estudar", "Springboot 2 e Angular 11",
				formatter.parse("25/03/2022"), false);

		todorepository.saveAll(Arrays.asList(t1));

	}

}
