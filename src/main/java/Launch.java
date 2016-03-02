import sun.util.calendar.BaseCalendar;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Launch {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
//        PrintStream printStream = new PrintStream("Calendar.html");
        MyCalendar calendar = new MyCalendarConsole(System.out);
        if (args.length > 0) {
            System.out.println(args[0]);
            printReceivedMonth(calendar, args[0], args[1]);
        } else {

            printCurrentMonth(calendar);
        }


    }

    private static void printReceivedMonth(MyCalendar calendar, String monthName, String year) throws ParseException {
//        Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse(month);


        YearMonth receivedMonth = YearMonth.of(2016, getMonthValue(monthName));


        calendar.printMonth(receivedMonth, 1);
    }
    public static int getMonthValue(String monthName){
        String[] monthNames = new String[]{"jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec"};
        monthName = monthName.substring(0, 3);
        for (int i = 0; i < monthNames.length; i++) {
            if (monthName.equalsIgnoreCase(monthNames[i])) {
                return i + 1;
            }
        }
        throw new IllegalArgumentException();
    }

    private static void printCurrentMonth(MyCalendar calendar) {
        int currentDay = LocalDate.now().getDayOfMonth();
        YearMonth currentMonth = YearMonth.now();
        calendar.printMonth(currentMonth, currentDay);
        System.out.println();
    }
}