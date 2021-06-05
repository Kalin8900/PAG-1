import java.io.File;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        var rc = new RowConverter();
        var inputFile = new File(System.getProperty("user.dir") + "/data/input2.txt");
        var outputFile = new File(System.getProperty("user.dir") + "/data/output2.txt");
        rc.read("input.txt");
        System.out.println(rc.toString());
        try {
            rc.write("output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rc.read(inputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            rc.write(outputFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(rc.toString());
    }
}
