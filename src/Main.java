import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello it's Task Manager, try to add task");

        Task task1 = new Task("Cleaning","Clean the room",
                RepeatabilityTask.EVERY_DAY,TypeTask.PERSONAL_TASK);

        Task task2 = new Task("Read","Read the english book",
                RepeatabilityTask.EVERY_DAY,TypeTask.PERSONAL_TASK);
        Task task3 = new Task("Walk","Walk outside",
                RepeatabilityTask.EVERY_DAY,TypeTask.PERSONAL_TASK);
        System.out.println(task1);

        TaskList book = new TaskList();
//        book.addTask(task1);
//        book.addTask(task2);
//
//        book.addTask(task3);

       // System.out.println(book);
        while (true) {
            System.out.println("Enter Head name: ");
            String headName = scanner.nextLine();

            if (headName.equals("exit")) {
                break;
            }
            System.out.println("Enter description");
            String description = scanner.nextLine();
            System.out.println("enter one of the suggested options"+"\n"+"ONE_TIME "+"\n" +
                    "EVERY_DAY"+"\n"+"EVERY_WEEK"+"\n"+"EVERY_MONTH"+"\n"+"EVERT_YEAR");
            String repeat = scanner.nextLine();
            try {
                RepeatabilityTask repeatabilityTask = RepeatabilityTask.valueOf(repeat);
                System.out.println("Enter type task: PERSONAL_TASK or WORK_TASK ");
                String type = scanner.nextLine();
                TypeTask typeTask = TypeTask.valueOf(type);
//            System.out.println(task);
                book.addTask(new Task(headName, description, repeatabilityTask, typeTask));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(book);


    }
}