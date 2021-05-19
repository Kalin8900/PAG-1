package shopping;

import java.util.Objects;

public class Product {

    private String name;
    private float price;

    public Product(String name, float price) {
        this.name = name;
        this.price = price;
    }

    public Product(String[] args) {
        this.name = args[0];
        this.price = Float.parseFloat(args[1]);
    }

    public Product(Product p) {
        this.name = p.name;
        this.price = p.price;
    }

    @Override
    public String toString() {
        return name + ": " + price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.getPrice(), getPrice()) == 0 && Objects.equals(getName(), product.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPrice());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
