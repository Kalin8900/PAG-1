package shopping;

import java.util.*;

public class Shop {
    private ArrayList<Product> products;
    private ArrayList<Client> clients;
    private LinkedList<Client> queue;

    public Shop(ArrayList<String[]> productsArgs, ArrayList<String[]> clientsArgs) {
        var ps = new ArrayList<Product>();
        for (var elem : productsArgs) {
            Product p = new Product(elem);
            ps.add(p);
        }
        this.setProducts(ps);

        var cs = new ArrayList<Client>();
        for (var elem : clientsArgs) {
            Client c = new Client(elem[0]);
            cs.add(c);
        }
        this.setClients(cs);

        queue = new LinkedList<Client>();
    }

    public void generateBaskets() {
        Random rand = new Random();
        for (var elem : clients) {
            int types = rand.nextInt(9) + 1; //to make sure no empty baskets are generated
            Basket b = new Basket();
            for (int i = 0; i < types; ++i) {
                ProductInBasket p = new ProductInBasket(products.get(rand.nextInt(products.size() - 1)), rand.nextInt(99) + 1);
                b.giveth(p);
            }
            elem.setBasket(b);
        }
    }

    public void makeQueue() {
        queue.addAll(clients);
    }

    public void serve() {
        while (!queue.isEmpty()) {
            var cur = queue.remove();
//            System.out.println(cur.getSurname() + ':');
//            System.out.println(cur.getBasket());
//            float total = 0;
//            for (var product : cur.getBasket().getProducts()) {
//                total += product.getPrice() * product.getQuantity();
//            }
//            System.out.println(cur.getSurname() + "'s total: " + total);
//            System.out.println(' ');
            cur.serveClient();
        }
    }

    @Override
    public String toString() {
        return "Shop:\n" +
                "products: " + products + '\n' +
                "clients: \n" + clients + '\n' +
                "queue: \n" + queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return Objects.equals(getProducts(), shop.getProducts()) && Objects.equals(getClients(), shop.getClients()) && Objects.equals(getQueue(), shop.getQueue());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducts(), getClients(), getQueue());
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public ArrayList<Client> getClients() {
        return clients;
    }

    public void setClients(ArrayList<Client> clients) {
        this.clients = clients;
    }

    public Queue<Client> getQueue() {
        return queue;
    }

    public void setQueue(LinkedList<Client> queue) {
        this.queue = queue;
    }
}
