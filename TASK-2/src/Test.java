import shopping.Basket;
import shopping.Client;
import shopping.Product;
import shopping.ProductInBasket;

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
        var rng = new RNG(50, 5, 15);

        rng.out();

        var productsPath = System.getProperty("user.dir") + "/data/productsData.txt";
        ArrayList<String[]> productArgsArr = null;
        try {
            productArgsArr = readDataFromFile(productsPath.trim());
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        var clientsPath = System.getProperty("user.dir") + "/data/clientsData.txt";
        ArrayList<String[]> clientArgsArr = null;
        try {
            clientArgsArr = readDataFromFile(clientsPath.trim());
        } catch (InvalidPathException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        if (productArgsArr == null || clientArgsArr == null)
            throw new RuntimeException("Couldn't init and load test data");

        Random rand = new Random();
        ArrayDeque<ProductInBasket> basketContents = new ArrayDeque<>();
        ArrayBlockingQueue<Client> clients = new ArrayBlockingQueue(clientArgsArr.size());

        for (var elem : clientArgsArr) {
            for (int i = 0; i < 5; ++i) {
                Product p = new Product(productArgsArr.get(rand.nextInt(productArgsArr.size() - 1)));
                ProductInBasket pib = new ProductInBasket(p, rand.nextInt());
                basketContents.push(pib);
            }
            Basket b = new Basket(basketContents);
            Client client = new Client(elem[0], b);
            clients.add(client);
            basketContents.clear();
        }
        for (var elem : clients)
            elem.serve();
    }
}
