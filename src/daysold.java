/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

public class daysold {


    /**
     * Convert inputted birthday string into a GregorianCalender
     *
     * @param birthday {@code String} The start date in a yyyy-mm-dd format
     */
    public static GregorianCalendar parse_birthday(String birthday) {
        // strip birthday string from its yyyy-mm-dd format to a list of {year, month, day}
        String[] in_date_vars = birthday.split("-");

        int year = Integer.parseInt(in_date_vars[0]);

        // Minus month by one as GregorianCalendar is 0 indexed
        int month = Integer.parseInt(in_date_vars[1]) - 1;

        int day = Integer.parseInt(in_date_vars[2]);

        return new GregorianCalendar(year, month, day);
    }


    /**
     * Convert a GregorianCalender to a string formatted as "month_name day year"
     *
     * @param date {@code GregorianCalender}
     */
    public static String get_date_string(Calendar date) {
        return String.format(
                "%s %s %s",
                date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH),
                date.get(Calendar.DAY_OF_MONTH),
                date.get(Calendar.YEAR)
        );
    }


    /**
     * Calculate how many days between today and the date, and them out
     *
     * @param birthday {@code String} The start date in a yyyy-mm-dd format
     */
    public static void days(String birthday) {
        // get the present day and store it into a Calendar
        Calendar cur_date = GregorianCalendar.getInstance();

        // generate the current date string
        String cur_date_str = get_date_string(cur_date);

        // convert inputted birthday string into a GregorianCalendar
        GregorianCalendar in_date = parse_birthday(birthday);

        // format and print the inputted birthday
        System.out.printf("Birthday: %s ", get_date_string(in_date));

        // if inputted birthday is in the future return error message
        if (in_date.after(cur_date)) {
            System.out.printf("today: %s -- Wrong birthday!\n", cur_date_str);
        }
        // tally and print the difference in days between current and birthday date
        else {
            int passed_days = 0;
            while (in_date.before(cur_date)) {
                in_date.add(Calendar.DAY_OF_MONTH, 1);
                passed_days++;
            }
            System.out.printf("today: %s -- You are %d days old.\n", cur_date_str, passed_days);
        }
    } // public static void days(String birthday)


    /**
     * Main entry
     *
     * @param args {@code String[]} Command line arguments
     */
    public static void main(String[] args) {
        days("1996-7-6"); // My birthday
        days("2000-1-1");
        days("3000-1-1"); // This is a wrong birthday
    } // public static void main(String[] args)

}
