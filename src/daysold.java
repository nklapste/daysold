/**
 * Assignment 1: Using standard libraries <br />
 * Calculate age in days
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class daysold {


    /**
     * Convert inputted birthday string into a Calender
     *
     * @param birthday {@code String} The start date in a yyyy-mm-dd format
     */
    private static Calendar parse_birthday(String birthday) {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            cal.setTime(sdf.parse(birthday));
        } catch (java.text.ParseException e) {
            e.printStackTrace();
        }
        return cal;
    } // private static Calendar parse_birthday(String birthday)


    /**
     * Convert a Calender to a string formatted as "month_name day year"
     *
     * @param date {@code Calender}
     */
    private static String get_date_string(Calendar date) {
        return String.format(
                "%s %s %s",
                date.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.ENGLISH),
                date.get(Calendar.DAY_OF_MONTH),
                date.get(Calendar.YEAR)
        );
    } // private static String get_date_string(Calendar date)


    /**
     * Calculate how many days between today and the date, and them out
     *
     * @param birthday {@code String} The start date in a yyyy-mm-dd format
     */
    public static void days(String birthday) {
        // get the present day and store it into a Calendar
        Calendar cur_date = Calendar.getInstance();

        // generate the current date string
        String cur_date_str = get_date_string(cur_date);

        // convert inputted birthday string into a Calendar
        Calendar in_date = parse_birthday(birthday);

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
        days("2017-9-1");
        days("3000-1-1"); // This is a wrong birthday
    } // public static void main(String[] args)

}
