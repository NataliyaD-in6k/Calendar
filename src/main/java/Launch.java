import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Launch {
    public static void main(String[] args) throws ParseException {
        MyCalendar calendar = new MyCalendar();
        if(args.length>0){
            System.out.println(args[0]);

        }
        String monthName = args[0];
        Date date = new SimpleDateFormat("MMM", Locale.ENGLISH).parse("Feb");
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int month = cal.get(Calendar.MONTH);
        System.out.println(month == Calendar.FEBRUARY);








        int currentDay = LocalDate.now().getDayOfMonth();
        YearMonth currentMonth = YearMonth.now();
        calendar.printMonth(currentMonth, currentDay);
        System.out.println();
    }
}