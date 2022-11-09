import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;


public class TaskList {
    private static int idCount = 0;
    private Map<Integer, Task> tasksList = new HashMap<>();
    private Collection<Task> removedTask;


    public void addTask(Task task) {
        System.out.println("Add task" + task);

        tasksList.put(idCount++, task);

    }

    public void removeTask(int id) {
        System.out.println("Remove task " );
        tasksList.remove(id);

    }

    public Collection<Task> getAllByDate(LocalDate inputDate) {
        List<Task> resultList = new ArrayList<>();
        for (Map.Entry<Integer, Task> integerTaskEntry : tasksList.entrySet()) {
            Task task = integerTaskEntry.getValue();
            if (task.isAvailable(inputDate)) {
                resultList.add(task);
            }
        }
        return resultList;
    }


    @Override
    public String toString() {
        return "TaskList{" +
                "tasksList=" + tasksList +
                '}';
    }
}
