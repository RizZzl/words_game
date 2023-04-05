package main;

import main.model.ToDoList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ToDoListController {
    @GetMapping("/toDoList/")
    public List<ToDoList> list() {
        return Storage.getAllToDoList();
    }

    @GetMapping("/toDoList/{id}")
    public ResponseEntity get(@PathVariable int id) {
        ToDoList toDo = Storage.getToDo(id);
        if (toDo == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDo, HttpStatus.OK);
    }

    @PostMapping("/toDoList/")
    public int add(ToDoList toDo) {
        return Storage.addToDoList(toDo);
    }

    @PostMapping("/toDoList/{id}")
    public ResponseEntity post(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/toDoList/{id}")
    public ResponseEntity change(ToDoList toDo, @PathVariable int id) {
        ToDoList toDoList = Storage.getToDo(id);
        if (toDoList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.addToDoList(toDoList);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @DeleteMapping("/toDoList/")
    public ResponseEntity deleteToDoList() {
        if (!Storage.getAllToDoList().isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.deleteToDoList();
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @DeleteMapping("/toDoList/{id}")
    public ResponseEntity removeToDo(@PathVariable int id) {
        ToDoList toDoList = Storage.getToDo(id);
        if (toDoList == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Storage.removeToDo(id);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }
}