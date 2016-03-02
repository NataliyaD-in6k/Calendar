import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class MyCalendarConsole extends MyCalendar {

    private PrintStream printStream;

    public MyCalendarConsole(PrintStream printStream) {
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
        printStream.printf("\u001B[31m%3s\u001B[0m ", j);
    }

    protected void printHighlightedDay(int j) {
        printStream.printf("\u001B[32m%3s\u001B[0m ", j);
    }

    protected void printEndOfWeek() {
        printStream.println();
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        for (String day : dayList) {
            printStream.printf("\u001B[36m%3s \u001B[0m", day);
        }
        printStream.println();
    }
}
