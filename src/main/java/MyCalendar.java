import java.time.DayOfWeek;
import java.time.YearMonth;
import java.util.Arrays;
import java.util.List;

public abstract class MyCalendar {

    public static final int DAYS_IN_WEEK = 7;

    public void printMonth(YearMonth yearMonth, int highlightedDay) {
        printStartOfMonth();
        printHeaderOfMonth();
        DayOfWeek firstDayOfMonth = yearMonth.atDay(1).getDayOfWeek();
        printOffsettedDays(firstDayOfMonth);
        printNumbersOfDays(yearMonth.lengthOfMonth(), highlightedDay, firstDayOfMonth);
        printEndOfMonth();
    }

    private void printNumbersOfDays(int lengthOfMonth, int highlightedDay, DayOfWeek firstDayOfMonth) {
        for (int dayOfMonth = 1; dayOfMonth <= lengthOfMonth; dayOfMonth++) {
            int alignedDayOfMonth = dayOfMonth + firstDayOfMonth.getValue();

            if (isStartOfWeek(alignedDayOfMonth)) {
                printStartOfWeek();
            }

            if (dayOfMonth == highlightedDay) {
                printHighlightedDay(dayOfMonth);
            } else if (isWeekend(alignedDayOfMonth)) {
                printWeekend(dayOfMonth);
            } else{
                printDay(dayOfMonth);
            }
            if (isEndOfWeek(alignedDayOfMonth)) {
                printEndOfWeek();
            }

        }
    }

    protected boolean isWeekend(int dayOfMonth) {
        return dayOfMonth % DAYS_IN_WEEK == 1 || dayOfMonth % DAYS_IN_WEEK == 0;
    }

    private boolean isEndOfWeek(int dayOfMonth) {
        return dayOfMonth % DAYS_IN_WEEK == 0;
    }

    private boolean isStartOfWeek(int dayOfMonth) {
        return dayOfMonth % DAYS_IN_WEEK == 1;
    }


    protected void printStartOfWeek() {
    }

    protected void printStartOfMonth() {
    }

    protected void printEndOfMonth() {
    }

    protected abstract void printEndOfWeek();

    protected abstract void printDay(int j);

    protected abstract void printOffsettedDays(DayOfWeek firstDayOfMonth);

    protected abstract void printWeekend(int j);

    protected abstract void printHighlightedDay(int j);

    protected abstract void printHeaderOfMonth();
}