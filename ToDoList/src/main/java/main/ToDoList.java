package main;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class ToDoList {

    @RequestMapping
    public String index() {
        Random random = new Random();
        return random.toString();
    }
}