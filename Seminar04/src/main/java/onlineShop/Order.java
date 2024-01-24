package onlineShop;

import lombok.Data;
@Data
/**
 * Класс Order представляет заказы в магазине. Он содержит поля для клиента (customer), товара (product)
 * и количества (quantity).
 */
public class Order {
    private Customer customer;
    private Product product;
    private int quantity;
    public Order(Customer customer, Product product, int quantity) {
        this.customer = customer;
        this.product = product;
        this.quantity = quantity;
    }
}
