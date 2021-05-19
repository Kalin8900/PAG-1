package shopping;

import java.util.ArrayDeque;
import java.util.Objects;

public class Basket {
    private ArrayDeque<ProductInBasket> products;

    public Basket(ArrayDeque<ProductInBasket> ps) {
        this.products = ps;
    }

    @Override
    public String toString() {
        return "Basket contents:" + products;
    }

    public void giveth(ProductInBasket p) {
        this.products.push(p);
    }

    public void takethAway() {
        this.products.pop();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Basket basket = (Basket) o;
        return Objects.equals(getProducts(), basket.getProducts());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProducts());
    }

    public ArrayDeque<ProductInBasket> getProducts() {
        return products;
    }

    public void setProducts(ArrayDeque<ProductInBasket> products) {
        this.products = products;
    }
}
