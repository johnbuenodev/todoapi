package com.john.todonovo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.john.todonovo.domain.Todo;
import com.john.todonovo.repositories.TodoRepository;

import com.john.todonovo.services.exceptions.ObjectNotFoundException;

@Service
public class TodoService {

	@Autowired
	private TodoRepository repository;
	
	public Todo findById(Integer id){
		
		Optional<Todo> obj = this.repository.findById(id);
		
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! id: " + id + ", tipo: " + Todo.class.getName()));
		
	}

	public List<Todo> findAllOpen() {
		
		
		List<Todo> list = repository.findAllOpen();
		
		return list;
	}

	public List<Todo> findAllClose() {
		
		List<Todo> list = repository.findAllClose();
		
		return list;
	}

	public List<Todo> findAll() {
		
		List<Todo> list = repository.findAll();
		
		return list;
	}

	public Todo saveTodo(Todo todoObj) {
		
		
		todoObj.setId(null);

		return repository.save(todoObj);
	}

	public void deletarTodo(Integer id){
		
		Todo objTodoDeletar = this.findById(id);
				
		repository.delete(objTodoDeletar);
	
	}

	public void delete(Integer id) {
		
		repository.deleteById(id);

	}

	public Todo update(Integer id, Todo todo) {
		
		Todo newObj = this.findById(id);
		
		newObj.setTitulo(todo.getTitulo());
		newObj.setDescricao(todo.getDescricao());
		newObj.setDataParaFinalizar(todo.getDataParaFinalizar());
		newObj.setFinalizado(todo.getFinalizado());
		repository.save(newObj);
		return newObj;
		
	}
	
	
}
