package threading;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestObj {
    //SimpleDateFormat is not thread safe
   //private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");

    public static Date parseDate(String dateStr) throws ParseException {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("d/M/yyyy");
            Date date = simpleDateFormat.parse(dateStr);
            System.out.println("Successfully Parsed Date " + date);
            return date;
   }

}
