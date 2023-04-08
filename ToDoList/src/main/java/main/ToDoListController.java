package main;

import main.model.ToDoList;
import main.model.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ToDoListController {
    @Autowired
    private ToDoListRepository toDoListRepository;

    @GetMapping("/toDoList/")
    public List<ToDoList> list() {
        Iterable<ToDoList> toDoListIterable = toDoListRepository.findAll();
        ArrayList<ToDoList> toDoLists = new ArrayList<>();
        for (ToDoList toDoList : toDoListIterable) {
            toDoLists.add(toDoList);
        }
        return toDoLists;
    }

    @GetMapping("/toDoList/{id}")
    public ResponseEntity get(@PathVariable int id) {
        Optional<ToDoList> toDoOptional = toDoListRepository.findById(id);
        if (!toDoOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(toDoOptional.get(), HttpStatus.OK);
    }

    @PostMapping("/toDoList/")
    public int add(ToDoList toDo) {
        ToDoList toDoList = toDoListRepository.save(toDo);
        return toDoList.getId();
    }

    @PostMapping("/toDoList/{id}")
    public ResponseEntity post(@PathVariable int id) {
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(null);
    }

    @PutMapping("/toDoList/")
    public ResponseEntity put(List<Integer> idList, List<ToDoList> list) {

        for (int i = 0; i < list.size(); i++) {
            ToDoList toDoList = list.get(i);
            int id = idList.get(i);

            if (!toDoListRepository.findById(id).isPresent()) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
            }
            toDoListRepository.save(toDoList);
        }
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @PutMapping("/toDoList/{id}")
    public ResponseEntity change(ToDoList toDo, @PathVariable int id) {
        if (!toDoListRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        toDoListRepository.save(toDo);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @DeleteMapping("/toDoList/")
    public ResponseEntity deleteToDoList() {
        if (toDoListRepository.count() == 0) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        toDoListRepository.deleteAll();
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }

    @DeleteMapping("/toDoList/{id}")
    public ResponseEntity removeToDo(@PathVariable int id) {
        if (!toDoListRepository.findById(id).isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        toDoListRepository.deleteById(id);
        return (ResponseEntity) ResponseEntity.status(HttpStatus.OK);
    }
}