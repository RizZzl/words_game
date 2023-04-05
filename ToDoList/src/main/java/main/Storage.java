package main;

import main.model.ToDoList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    private static int currentId = 1;
    private static final Map<Integer, ToDoList> toDoList = new HashMap<>();

    public static List<ToDoList> getAllToDoList() {
        ArrayList<ToDoList> toDoLists = new ArrayList<ToDoList>();
        toDoLists.addAll(toDoList.values());
        return toDoLists;
    }

    public static int addToDoList(ToDoList toDo) {
        int id = currentId++;
        toDo.setId(id);
        toDoList.put(id, toDo);
        return id;
    }

    public static ToDoList getToDo(int id) {
        if (toDoList.containsKey(id)) {
            return toDoList.get(id);
        }
        return null;
    }

    public static ToDoList removeToDo(int id) {
        if (toDoList.containsKey(id)) {
            return toDoList.remove(id);
        }
        return null;
    }

    public static void deleteToDoList() {
        for (int i = 0; i <= toDoList.size(); i++) {
            toDoList.remove(i);
        }
    }
}
