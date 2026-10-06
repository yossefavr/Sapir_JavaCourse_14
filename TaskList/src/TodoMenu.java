import java.util.Scanner;

public class TodoMenu {

    private Scanner scanner;

    public TodoMenu() {
        scanner = new Scanner(System.in);
    }

    public int showMenu() {

        System.out.println();
        System.out.println("===== TODO LIST =====");
        System.out.println("1. Show tasks");
        System.out.println("2. Add task");
        System.out.println("3. Delete task");
        System.out.println("4. Toggle completed");
        System.out.println("0. Exit");
        System.out.print("Choose: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public void showTasks(TaskList taskList) {

        System.out.println();
        System.out.println("----- TASKS -----");

        if (taskList.getTasks().size() == 0) {
            System.out.println("No tasks.");
            return;
        }

        for (Task task : taskList.getTasks()) {
            System.out.println(task);
        }
    }

    public Task readNewTask() {

        System.out.print("Enter task: ");

        String text = scanner.nextLine();

        return new Task(text);
    }

    public int readTaskId() {

        System.out.print("Enter task ID: ");

        return Integer.parseInt(scanner.nextLine());
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void close() {
        scanner.close();
    }
}