//import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.Scanner;
import java.util.ArrayList;

public class Test {

    private static ArrayList<String[]> readDataFromFile(String path) {
        if (path.isEmpty())
            throw new InvalidPathException(path, "Path length must be greater than 0");
        var argsArr = new ArrayList<String[]>();
        var file = new File(path);
        if (!file.isFile())
            throw new InvalidPathException(path, "Couldn't find file from given path");

        try {
            var s = new Scanner(file);
            while (s.hasNextLine()) {
                String data = s.nextLine();
                String[] token = data.split(" ");
                argsArr.add(token);
            }
        } catch (IOException e) {
            System.out.println("Error occurred when loading the file from path " + path);
            e.printStackTrace();
        }
        return argsArr;
    }

    public static void main(String[] args) {
        var path = System.getProperty("user.dir") + "/TASK-1/data/data.txt";
        ArrayList<String[]> argsArr = null;
        try {
            argsArr = readDataFromFile(path.trim());
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if (argsArr == null)
            throw new RuntimeException("Couldn't init and load test data");

        var cnt = 0;
        var errCnt = 0;
        elements:
        for (String[] elem : argsArr) {
            try {
                Plane p = null;

                try {
                    p = new Plane(elem);
                } catch (IllegalArgumentException e) {
                    if (cnt == 0 && e.getMessage().equals(Plane.constructorExceptionMessage)) {
                        System.out.println("Exception correctly thrown for constructor");
                        ++cnt;
                        continue elements;
                    } else {
                        e.getStackTrace();
                        System.out.println(e.getMessage());
                    }
                }

                if (p == null)
                    throw new RuntimeException("Couldn't init Plane Class");

                System.out.println(p);
//                System.out.println(p.toString());

                try {
                    p.setMaxAltitude(-200);
                } catch (IllegalArgumentException e) {
                    System.out.println("Correctly thrown exception for setter");
                }

                p.setPassengerCapacity(10);
                p.setMaxAltitude(5000);
                p.autonomize();
                if (p.getPassengerCapacity() != 10 || p.getMaxAltitude() != 5000 || p.getCrew() != 0 || p.isManned())
                    System.out.println("Error! Malfunction of setter or getter methods");

                var eqFirst = new Plane(elem);
                var eqSecond = new Plane(elem);

                if (!eqFirst.equals(eqSecond))
                    throw new RuntimeException("Malfunction of .equals() method");

                if(eqFirst.hashCode() == eqSecond.hashCode())
                    System.out.println("Hashcode of a Plane object: " + eqFirst.hashCode());

                ++cnt;
            } catch (Exception e) {
                ++errCnt;
                System.out.println("UNEXPECTED ERROR: " + e.getMessage());
            }
        }

        System.out.println((errCnt == 0) ? "All test passed" : "TEST NOT PASSED. ERRORS NUMBER: " + errCnt);
    }
}
