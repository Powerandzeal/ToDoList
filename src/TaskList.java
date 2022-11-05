import java.util.HashMap;
import java.util.Map;


public class TaskList  {
    private static int idCount = 0;
    private Map<Integer,Task > tasksList = new HashMap<>();



    public  void addTask(Task task) {
        System.out.println("Add task" + task);

        tasksList.put(idCount++, task);

    }

    public void removeTask() {
    }


    public void showTask() {

    }

    @Override
    public String toString() {
        return "TaskList{" +
                "tasksList=" + tasksList +
                '}';
    }
}
