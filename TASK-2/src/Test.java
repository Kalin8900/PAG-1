import shopping.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
        var rng = new RNG(100, 5, 15);

        System.out.println("RNG: ");
        rng.out();


        System.out.println("\nShop: ");
        var productsPath = System.getProperty("user.dir") + "/data/productsData.txt";
        var clientsPath = System.getProperty("user.dir") + "/data/clientsData.txt";

        var productsData = readDataFromFile(productsPath);
        var clientsData = readDataFromFile(clientsPath);

        Shop s = new Shop(productsData, clientsData);
        s.generateBaskets();
        s.makeQueue();
        s.serve();
    }
}
