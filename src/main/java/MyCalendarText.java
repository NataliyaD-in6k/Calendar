import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class MyCalendarText extends MyCalendar{
    protected PrintStream printStream;

    public MyCalendarText(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void printDay(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printOffsettedDays(DayOfWeek firstDayOfMonth) {
        for (int i = 0; i < firstDayOfMonth.getValue(); i++) {
            printStream.print("    ");
        }
    }

    protected void printWeekend(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printHighlightedDay(int j) {
        printStream.printf("%3s ", j);
    }

    protected void printEndOfWeek() {
        printStream.println();
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        printStartOfWeek();
        for (String day : dayList) {
            printStream.printf("%3s ", day);
        }
        printEndOfWeek();
    }
}
