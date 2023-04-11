package main;

import main.model.ToDoList;
import main.model.ToDoListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class DefaultController {
    @Autowired
    ToDoListRepository toDoListRepository;

    @RequestMapping("/")
    public String index(Model model){
        Iterable<ToDoList> IterableToDoLists = toDoListRepository.findAll();
        ArrayList<ToDoList> toDoLists = new ArrayList<>();

        for (ToDoList toDo :IterableToDoLists) {
            toDoLists.add(toDo);
        }

        model.addAttribute("toDo", toDoLists)
                .addAttribute("toDoCount", toDoLists.size());

        return "index";
    }
}
