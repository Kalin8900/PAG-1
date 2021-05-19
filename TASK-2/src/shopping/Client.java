package shopping;

import java.util.Objects;

public class Client {
    private String surname;
    private Basket basket;

    public Client(String surname, Basket basket) {
        this.surname = surname;
        this.basket = basket;
    }

    public void serve() {
        float total = 0;
        System.out.println("Items:");
        for (var elem : basket.getProducts()) {
            System.out.print(elem.toString());
            total += elem.getPrice();
        }
        System.out.println("Total: ");
        System.out.print(total);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(getSurname(), client.getSurname()) && Objects.equals(getBasket(), client.getBasket());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSurname(), getBasket());
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }
}