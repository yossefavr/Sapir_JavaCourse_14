public class App {

    public static void main(String[] args) {

        TodoMenu menu = new TodoMenu();
        TaskList taskList = new TaskList();

        // Temporary test data
        taskList.addTask(
            new Task(1, "Learn JDBC", false)
        );

        taskList.addTask(
            new Task(2, "Learn Java OOP", true)
        );

        taskList.addTask(
            new Task(3, "Learn Servlets", false)
        );

        int choice;

        do {

            choice = menu.showMenu();

            switch (choice) {

                case 1:
                    menu.showTasks(taskList);
                    break;

                case 2:
                    Task newTask = menu.readNewTask();

                    taskList.addTask(newTask);

                    menu.showMessage("Task added.");
                    break;

                case 3:
                    int deleteId = menu.readTaskId();

                    Task taskToDelete =
                        taskList.getTaskById(deleteId);

                    if (taskToDelete != null) {

                        taskList.removeTask(taskToDelete);

                        menu.showMessage(
                            "Task deleted."
                        );

                    } else {

                        menu.showMessage(
                            "Task not found."
                        );
                    }

                    break;

                case 4:
                    int toggleId = menu.readTaskId();

                    Task task =
                        taskList.getTaskById(toggleId);

                    if (task != null) {

                        task.setCompleted(
                            !task.isCompleted()
                        );

                        menu.showMessage(
                            "Task updated."
                        );

                    } else {

                        menu.showMessage(
                            "Task not found."
                        );
                    }

                    break;

                case 0:
                    menu.showMessage("Goodbye!");
                    break;

                default:
                    menu.showMessage(
                        "Invalid choice."
                    );
            }

        } while (choice != 0);

        menu.close();
    }
}