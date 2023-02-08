package practice;

import java.util.ArrayList;

public class TodoList {
    ArrayList<String> todoList = new ArrayList<>();
    final char dm = (char) 34;
    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        todoList.add(todo);
        System.out.println("Добавлено дело " + dm + todo + dm);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= todoList.size()) {
            todoList.add(index, todo);
            System.out.println("Добавлено дело " + dm + todoList.get(index) + dm);
        } else {
            todoList.add(todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index <= todoList.size()) {
            System.out.println("Дело " + dm + todoList.get(index) + dm + " заменено на " + dm + todo + dm);
            todoList.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index <= todoList.size()) {
            System.out.println("Дело " + dm + todoList.get(index) + dm + " удалено");
            todoList.remove(index);
        } else {
            System.out.println("Дело с таким номером не существует");
        }
    }

    public String getTodos() {
        String todos = "";
        for (int i = 0; i < todoList.size(); i++) {
            todos = todos + todoList.get(i) + ", ";
        }
        todos = '[' + todos.substring(0, todos.length() - 2) + ']';
        return todos.toString();
    }

//    public ArrayList<String> getTodos() {
//        // TODO: вернуть список дел
//        return new ArrayList<>();
//    }

}