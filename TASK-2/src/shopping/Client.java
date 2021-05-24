package shopping;

import java.util.Objects;

public class Client {
    private String surname;
    private Basket basket;

    public Client(String surname, Basket basket) {
        this.surname = surname;
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Client: " + '\n' +
                "surname: " + surname + '\n' +
                "basket: " + basket + '\n';
    }

    public Client(String surname){
        this.surname = surname;
        this.basket = null;
    }

    public void serveClient() {
        float total = 0;
        System.out.println(getSurname() + ":");
        for (var elem : basket.getProducts()) {
            System.out.print(elem.toString() + ' ');
            total += elem.getPrice() * elem.getQuantity();
        }
        System.out.println('\n' + getSurname() + "'s total: " + total + '\n');
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