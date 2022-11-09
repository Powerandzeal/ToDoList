import java.time.LocalDate;
import java.time.LocalDateTime;

public class EveryYearTask extends Task{
    public EveryYearTask(String headName, String description, TypeTask typeTask, LocalDateTime taskDateTime) {
        super(headName, description, typeTask, taskDateTime);
    }

    public boolean isAvailable(LocalDate inputDate) {
        LocalDate startDate = getDateTime().toLocalDate();
        while (!startDate.isAfter(inputDate)) {
            if (startDate.equals(inputDate)) {
                return true;
            }
            startDate = startDate.plusYears(1);
        }
        return false ;
    }
}
