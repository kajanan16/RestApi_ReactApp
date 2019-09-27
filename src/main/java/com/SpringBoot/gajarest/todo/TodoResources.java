package com.SpringBoot.gajarest.todo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@CrossOrigin("http://localhost:3000")
public class TodoResources {

	@Autowired
	private HardCodedTodos hrd;

	@GetMapping(value = "/users/{username}/todo", produces = "application/json; charset=UTF-8")
	public List<Todo> getAllTodos(@PathVariable String username) {
		return hrd.getAll();
	}

	@GetMapping(value = "/users/{username}/todo/{id}")
	public Todo getTodos(@PathVariable String username, @PathVariable long id) {
		return hrd.findByid(id);
	}

	@DeleteMapping("/users/{username}/todo/{id}")
	public ResponseEntity<Void> deleteTodos(@PathVariable String username, @PathVariable long id) {
		Todo todo = hrd.deleteById(id);
		if (todo != null)
			return ResponseEntity.noContent().build();

		return ResponseEntity.notFound().build();

	}

	@PutMapping("/users/{username}/todo/{id}")
	public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
			@RequestBody Todo todo) {

		Todo updatedTodo = hrd.save(todo);

		return new ResponseEntity<Todo>(todo, HttpStatus.OK);

	}

	@PostMapping("/users/{username}/todo")
	public ResponseEntity<Void> createTodo(@PathVariable String username, @RequestBody Todo todo) {

		Todo createdTodo = hrd.save(todo);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTodo.getId())
				.toUri();

		return ResponseEntity.created(uri).build();

	}

}
