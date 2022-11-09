import java.time.LocalDate;
import java.time.LocalDateTime;

public class DayTask extends Task{
    public DayTask(String headName, String description, TypeTask typeTask, LocalDateTime taskDateTime) {
        super(headName, description, typeTask, taskDateTime);
    }

    @Override
    public boolean isAvailable(LocalDate inputDate) {
        LocalDate startDate = getDateTime().toLocalDate();
        while (!startDate.isAfter(inputDate)) {
            if (startDate.equals(inputDate)) {
                return true;
            }
            startDate = startDate.plusDays(1);
        }
        return false ;
    }
}
