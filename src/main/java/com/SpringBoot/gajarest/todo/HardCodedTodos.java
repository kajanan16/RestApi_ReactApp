package com.SpringBoot.gajarest.todo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class HardCodedTodos {

	private static List<Todo> todos = new ArrayList<Todo>();
	private static long userid = 0;

	static {

		todos.add(new Todo(++userid, "kajanan", "learnt to be expert in React", new Date(), false));
		todos.add(new Todo(++userid, "kajanan", "Practice Programming", new Date(), false));
		todos.add(new Todo(++userid, "kajanan", "Learn Swimming", new Date(), false));
		todos.add(new Todo(++userid, "kajanan", "Practice Coding", new Date(), false));
	}

	public List getAll() {
		return todos;
	}

	public Todo deleteById(long id) {
		Todo todo = findByid(id);
		if (todo == null)
			return null;

		if (todos.remove(todo)) {
			return todo;
		}

		return null;

	}

	public Todo save(Todo todo) {
		if (todo.getId() == -1 || todo.getId() == 0) {
			todo.setId(++userid);
			todos.add(todo);
		} else {
			deleteById(todo.getId());
			todos.add(todo);
		}
		return todo;
	}

	public Todo findByid(long id) {
		for (Todo tds : todos) {
			if (tds.getId() == id) {
				return tds;
			}
		}

		return null;
	}

}
