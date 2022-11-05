import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.chrono.ChronoLocalDate;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Task {

//    Scanner scanner1 = new Scanner(System.in);
//    Scanner scanner2 = new Scanner(System.in);
//    Scanner scanner3 = new Scanner(System.in);

    private String headName ;
    private String decription;
    private TypeTask typeTask;



    private RepeatabilityTask repeatabilityTask;

   private Date date;

    public Task(String headName, String decription,
                RepeatabilityTask repeatabilityTask, TypeTask typeTask) {
        this.headName = headName;
        this.decription = decription;
        this.typeTask = typeTask;
        this.date =  new Date();
        this.repeatabilityTask = repeatabilityTask;

    }

    public void createTask() {




    }

    @Override
    public String toString() {
        return "Task{" +
                "headName='" + headName + '\'' +
                ", decription='" + decription + '\'' +
                ", date=" + date +
                '}'+"\n";
    }
}

