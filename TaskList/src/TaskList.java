import java.util.ArrayList;
import java.util.List;

public class TaskList {

    private List<Task> tasks;

    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public Task getTaskById(int id) {

        for (Task task : tasks) {

            if (task.getId() == id) {
                return task;
            }
        }

        return null;
    }

    public void toggleTaskCompletion(int id) {

        Task task = getTaskById(id);

        if (task != null) {
            task.setCompleted(!task.isCompleted());
        }
    }

    public List<Task> getTasks() {
        return tasks;
    }
}