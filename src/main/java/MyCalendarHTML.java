import java.io.PrintStream;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class MyCalendarHTML extends MyCalendar{
    PrintStream printStream;

    public MyCalendarHTML(PrintStream printStream) {
        this.printStream = printStream;
    }

    protected void printDay(int j) {
        printStream.printf("<td>%d</td>", j);
    }

    protected void printEndOfWeek() {
        printStream.println("</tr>");
    }

    protected void printStartOfWeek() {
        printStream.print("<tr>");
    }

    protected void printStartOfMonth() {
        printStream.print("<table border=\"1\">");
    }

    protected void printEndOfMonth() {
        printStream.print("</table>");
    }

    protected void printHighlightedDay(int j) {
        printDay(j);
    }

    protected void printWeekend(int j) {
        printDay(j);
    }

    protected void printOffsettedDays(DayOfWeek firstDayOfMonth) {
        printStartOfWeek();
        printStream.print("<td colspan=\"" + firstDayOfMonth.getValue() + "\"></td>");
    }

    protected void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        printStartOfWeek();
        for (String day : dayList) {
            printStream.printf("<td>%3s</td>", day);
        }
        printEndOfWeek();
    }
}
