import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public class MyCalendar {

    public static final int DAYS_IN_WEEK = 7;

    public void printMonth(YearMonth yearMonth, int highlightedDay) {
        printHeaderOfMonth();
        DayOfWeek firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek();
        printOffsettedDays(firstDayOfMonth);
        printNumbersOfDays(yearMonth.lengthOfMonth(), highlightedDay, firstDayOfMonth);
    }

    private void printNumbersOfDays(int lengthOfMonth, int highlightedDay, DayOfWeek firstDayOfMonth) {
        for (int dayOfMonth = 1; dayOfMonth <= lengthOfMonth; dayOfMonth++) {
            int alignedDayOfMonth = dayOfMonth + firstDayOfMonth.getValue();

            if (dayOfMonth == highlightedDay) {
                printHighlightedDay(dayOfMonth);
            } else if (isWeekend(alignedDayOfMonth)) {
                printWeekend(dayOfMonth);
            } else{
                printDay(dayOfMonth);
            }
            if (isEndOfWeek(alignedDayOfMonth)) {
                System.out.println();
            }

        }
    }

    private void printDay(int j) {
        System.out.printf("%3s ", j);
    }

    private boolean isEndOfWeek(int dayOfMonth) {
        return dayOfMonth % DAYS_IN_WEEK == 0;
    }

    private void printOffsettedDays(DayOfWeek firstDayOfMonth) {
        for (int i = 0; i < firstDayOfMonth.getValue(); i++) {
            System.out.print("    ");
        }
    }

    private boolean isWeekend(int dayOfMonth) {
        return dayOfMonth % DAYS_IN_WEEK == 1 || dayOfMonth % DAYS_IN_WEEK == 0;
    }

    private void printWeekend(int j) {
        System.out.printf("\u001B[31m%3s\u001B[0m ", j);
    }

    private void printHighlightedDay(int j) {
        System.out.printf("\u001B[32m%3s\u001B[0m ", j);
    }

    private void printHeaderOfMonth() {
        List<String> dayList = Arrays.asList("Sun", "Mon", "Tue", "Wen", "Thu", "Fri", "Sat");
        for (String day : dayList) {
            System.out.printf("\u001B[36m%3s \u001B[0m", day);
        }
        System.out.println();
    }
}