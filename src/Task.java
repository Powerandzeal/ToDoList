import java.time.LocalDate;
import java.time.LocalDateTime;

public class Task implements Repeatability {

    private int id  ;
    private String headName ;
    private String description;

    private TypeTask typeTask;
    private LocalDateTime dateTime;

    private static int idGenerator = 0;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TypeTask getTypeTask() {
        return typeTask;
    }

    public void setTypeTask(TypeTask typeTask) {
        this.typeTask = typeTask;
    }

    public static int getIdGenerator() {
        return idGenerator;
    }

    public static void setIdGenerator(int idGenerator) {
        Task.idGenerator = idGenerator;
    }

    public String getHeadName() {
        return headName;
    }

    public void setHeadName(String headName) {
        this.headName = headName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }


    public Task(String headName, String description,TypeTask typeTask,LocalDateTime taskDateTime ) {
        this.headName = headName;
        this.description = description;
        this.typeTask = typeTask;
        this.dateTime = taskDateTime;
        this.id = idGenerator++;

    }


    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", headName='" + headName + '\'' +
                ", description='" + description + '\'' +
                ", typeTask=" + typeTask +
                ", dateTime=" + dateTime +
                '}';
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        return inputDate.isEqual(getDateTime().toLocalDate());
    }
}

