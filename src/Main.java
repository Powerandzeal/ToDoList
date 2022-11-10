import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {


    public static void main(String[] args) {
        TaskList taskList = new TaskList();


        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Hello it's Task Manager ");
            printMenu();
            System.out.println("Choose number ");
            if (scanner.hasNext()) {
                int menu = scanner.nextInt();

                switch (menu) {
                    case 1:
                        addTaskTo(taskList, scanner);
                        break;
                    case 2:
                        removeTask(taskList, scanner);
                        break;
                    case 3:
                        showTaskOnDay(taskList, scanner);
                        break;
                    case 4:
                        return;


                }
            }


        }
    }

    public static void printMenu() {
        System.out.println("""
                1. Add Task      
                2. Remove Task
                3. Tasks for the selected day
                4  Exit            """);
    }

    private static void addTaskTo(TaskList taskList, Scanner scanner) {
        System.out.println("Enter Head Name");
        String headName = scanner.next();
        scanner.nextLine();

        System.out.println("Enter description ");
        String description = scanner.nextLine();
        LocalDate taskOfDate = null;

        boolean checkDate = true;
        while (checkDate) {
            try {
                System.out.println("Enter Date in format: dd.mm.yyyy  ");
                String date = scanner.nextLine();
                taskOfDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
                checkDate = false;
            } catch (Exception e) {
                System.out.println("Not correct field, try again");
            }
        }

        LocalTime taskTime = null;
        boolean checkTime = true;
        while (checkTime) {
            try {
                System.out.println("Enter Time in format: HH:mm  ");
                String time = scanner.nextLine();
                taskTime = LocalTime.parse(time, DateTimeFormatter.ofPattern("HH:mm"));
                checkTime = false;
            } catch (Exception e) {
                System.out.println("Not correct field, try again");
            }
        }
        LocalDateTime resultDate = LocalDateTime.of(taskOfDate, taskTime);

        System.out.println("Enter Type task : Person(1) or Work (2)");
        int type = scanner.nextInt();
        TypeTask taskType = type == 1 ? TypeTask.PERSONAL_TASK : TypeTask.WORK_TASK;
        System.out.println("""
                Enter the Repeatability task
                1. Day task
                2. Every Day Task
                3. Week Day Task
                4. Month Day Task
                5. Year Day Task
                """);
        int typeTask = scanner.nextInt();
        switch (typeTask) {
            case 1:
                taskList.addTask(new Task(headName, description, taskType, resultDate));
                break;
            case 2:
                taskList.addTask(new DayTask(headName, description, taskType, resultDate));
                break;
            case 3:
                taskList.addTask(new EveryWeekTask(headName, description, taskType, resultDate));
                break;
            case 4:
                taskList.addTask(new EveryMonthTask(headName, description, taskType, resultDate));
                break;
            case 5:
                taskList.addTask(new EveryYearTask(headName, description, taskType, resultDate));
                break;
            default:
                throw new RuntimeException("This task not exist");
        }
    }

    public static void removeTask(TaskList taskList, Scanner scanner) {
        System.out.println("Enter id task which you would remove");
        int id = scanner.nextInt();
        taskList.removeTask(id);
    }

    private static void showTaskOnDay(TaskList taskList, Scanner scanner) {
        System.out.println("Enter Date in format: dd.mm.yyyy  ");
        scanner.nextLine();
        String date = scanner.nextLine();

        LocalDate taskOfDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        Collection<Task> allByDate = taskList.getAllByDate(taskOfDate);
        System.out.println("Tasks on " + date);
        for (Task tasks : allByDate) {
            System.out.println(tasks);
        }
    }

//    public static void showAllTask(TaskList taskList,Scanner scanner) {
//        System.out.println(taskList);
//        System.out.println("All tasks");
//
//    }


    //    public static void controlMenu(Scanner scanner) {
//        if (scanner.equals("Add Task")) {
//            enterTask();
//        } else if (scanner.equals("Remove Task")) {
//
//        }
//    }

//    public static void enterTask() {
//        Scanner scanner = new Scanner(System.in);
//
//
//        while (true) {
//            System.out.println("Enter Head name: ");
//            String headName = scanner.nextLine();
//
//            if (headName.equals("exit")) {
//                break;
//            }
//            System.out.println("Enter description");
//            String description = scanner.nextLine();
//            System.out.println("enter one of the suggested options" + "\n" + "ONE_TIME " + "\n" +
//                    "EVERY_DAY" + "\n" + "EVERY_WEEK" + "\n" + "EVERY_MONTH" + "\n" + "EVERT_YEAR");
//            String repeat = scanner.nextLine();
//            try {
//                RepeatabilityTask repeatabilityTask = RepeatabilityTask.valueOf(repeat);
//                System.out.println("Enter type task: PERSONAL_TASK or WORK_TASK ");
//                String type = scanner.nextLine();
//                TypeTask typeTask = TypeTask.valueOf(type);
////            System.out.println(task);
//
//                book.addTask(new Task(headName, description, repeatabilityTask, typeTask));
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }

//        book.addTask(task1);
//        book.addTask(task2);
//
//        book.addTask(task3);

    // System.out.println(book);
//        while (true) {
//            System.out.println("Enter Head name: ");
//            String headName = scanner.nextLine();
//
//            if (headName.equals("exit")) {
//                break;
//            }
//            System.out.println("Enter description");
//            String description = scanner.nextLine();
//            System.out.println("enter one of the suggested options" + "\n" + "ONE_TIME " + "\n" +
//                    "EVERY_DAY" + "\n" + "EVERY_WEEK" + "\n" + "EVERY_MONTH" + "\n" + "EVERT_YEAR");
//            String repeat = scanner.nextLine();
//            try {
//                RepeatabilityTask repeatabilityTask = RepeatabilityTask.valueOf(repeat);
//                System.out.println("Enter type task: PERSONAL_TASK or WORK_TASK ");
//                String type = scanner.nextLine();
//                TypeTask typeTask = TypeTask.valueOf(type);
////            System.out.println(task);
//                book.addTask(new Task(headName, description, repeatabilityTask, typeTask));
//            } catch (IllegalArgumentException e) {
//                System.out.println(e.getMessage());
//            }
//        }
//        System.out.println(book);
}







