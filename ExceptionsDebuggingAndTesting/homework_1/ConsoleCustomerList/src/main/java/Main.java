import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;



public class Main {

    private static final Logger LOGGER = LogManager.getLogger(Main.class);

    private static final String ADD_COMMAND = "add Василий Петров " +
            "vasily.petrov@gmail.com +79215637722";
    private static final String COMMAND_EXAMPLES = "\t" + ADD_COMMAND + "\n" +
            "\tlist\n\tcount\n\tremove Василий Петров";
    private static final String COMMAND_ERROR = "Wrong command! Available command examples: \n" +
            COMMAND_EXAMPLES;
    private static final String helpText = "Command examples:\n" + COMMAND_EXAMPLES;


    public static void main(String[] args) throws IllegalAccessException {
        Scanner scanner = new Scanner(System.in);
        CustomerStorage executor = new CustomerStorage();

        while (true) {
            String command = scanner.nextLine();
            String[] tokens = command.split("\\s+", 2);
            try {
                if (tokens[0].equals("add")) {
                    executor.addCustomer(tokens[1]);
                    LOGGER.info(command);
                } else if (tokens[0].equals("list")) {
                    executor.listCustomers();
                    LOGGER.info(command);
                } else if (tokens[0].equals("remove")) {
                    executor.removeCustomer(tokens[1]);
                    LOGGER.info(command);
                } else if (tokens[0].equals("count")) {
                    System.out.println("There are " + executor.getCount() + " customers");
                    LOGGER.info(command);
                } else if (tokens[0].equals("help")) {
                    System.out.println(helpText);
                    LOGGER.info(command);
                } else {
                    System.out.println(COMMAND_ERROR);
                }
            } catch (IllegalArgumentException ex) {
                LOGGER.error(ex.getMessage());
                System.out.println(ex.getMessage());
            }
        }
    }
}