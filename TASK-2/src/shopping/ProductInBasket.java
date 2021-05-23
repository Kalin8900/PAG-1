package shopping;

import java.util.Objects;

public class ProductInBasket extends Product{

    private int quantity;

    public ProductInBasket(String name, float price, int quantity) {
        super(name, price);
        this.quantity = quantity;
    }

    public ProductInBasket(Product p, int quantity) {
        super(p);
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return  getName() + ": " + getPrice()  + " pln times " + quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ProductInBasket that = (ProductInBasket) o;
        return getQuantity() == that.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getQuantity());
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
