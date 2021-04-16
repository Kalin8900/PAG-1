import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args ) {
        File f = new File("D:\\Projekty\\IntelliJ\\PAG-1\\TASK-1\\src\\data.txt");
        ArrayList<String[]> argsArray = new ArrayList<>();
        try {
            Scanner s = new Scanner(f);
            while(s.hasNextLine()) {
                String data = s.nextLine();
                String[] token = data.split(" ");
                argsArray.add(token);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(String[] elem : argsArray) {
            Plane p = new Plane(elem);
            System.out.println(Arrays.toString(elem));
            System.out.println(p.toString());
            p.calculateEfficiency();
        }
    }
}
