import reading.ReadingRoom;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {

    public static void main(String[] args) {
        var rr = new ReadingRoom(10, 1000);
        var t = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS").format(new Date());
        System.out.println(rr);
        System.out.println(t);
    }
}
