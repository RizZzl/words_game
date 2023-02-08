package practice;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList
        while (true) {
            Scanner scanner = new Scanner(System.in);
            String commandStr = scanner.nextLine();

            String commands = commandStr.replaceAll("[^A-Z]+", "");
            String indexStr = commandStr.replaceAll("[^0-9]+", "");
            String list = commandStr.replaceAll(commands, "").replaceAll(indexStr, "").trim();
            int index = 0;
            if (!indexStr.equals("")) {
                index = Integer.parseInt(indexStr);
            }



            if (commands.equals("ADD")) {
                todoList.add(list);
            }
            if (commands.equals("ADD") && !indexStr.equals("")) {
                todoList.add(index, list);
            }
            if (commands.equals("EDIT") && !indexStr.equals("")) {
                todoList.edit(index, list);
            }
            if (commands.equals("DELETE") && !indexStr.equals("")) {
                todoList.delete(index);
            }
            if (commands.equals("LIST")) {
                System.out.println(todoList.getTodos());
            }
        }


    }
}
