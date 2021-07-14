package com.john.todonovo.resources;

import java.net.URI;
import java.util.List;
import static java.util.Objects.isNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.john.todonovo.domain.Todo;
import com.john.todonovo.services.TodoService;

@CrossOrigin("*")
@RestController("/api/")
@RequestMapping(value = "todos")
public class TodoResource {

	@Autowired
	private TodoService service;

	@GetMapping("/{id}")
	public ResponseEntity<Todo> findById(@PathVariable("id") Integer id) {

		Todo obj = service.findById(id);

		return ResponseEntity.ok().body(obj);

	}

	@GetMapping("/open")
	public ResponseEntity<List<Todo>> listOpen() {

		List<Todo> list = service.findAllOpen();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/close")
	public ResponseEntity<List<Todo>> listClose() {

		List<Todo> list = service.findAllClose();

		return ResponseEntity.ok().body(list);
	}

	@GetMapping("/")
	public ResponseEntity<List<Todo>> listarAll() {

		List<Todo> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}


	@PostMapping("/")
	public ResponseEntity<Todo> novoTodo(@RequestBody Todo todoBody) {

		/*
		 * { "id": 10, "titulo": "testando o save melhoria 2", "descricao": "salvando",
		 * "dataParaFinalizar" : "05/07/2021 10:20", "finalizado": false }
		 * 
		 */
	
		Todo todo = service.saveTodo(todoBody);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(todo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(todo);
	}

	@DeleteMapping("/{id}")
	public void deletarTodo(@PathVariable("id") Integer id) {

		service.deletarTodo(id);

	} 

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Integer id) {
		
		Todo obj = service.findById(id);
		
		if(isNull(obj)) {
			
		 return ResponseEntity.noContent().build();
				
		} else {		
		
		service.delete(id);
		return ResponseEntity.noContent().build();

		}
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Todo> update(@PathVariable("id") Integer id,@RequestBody Todo todo){
		
		Todo newObj = service.update(id, todo);
		return ResponseEntity.ok().body(newObj);
		
	}
	
}
