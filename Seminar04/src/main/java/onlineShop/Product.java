package onlineShop;

import lombok.Data;
import java.math.BigDecimal;
@Data
/**
 * Класс Product является моделью для представления информации о товаре.
 */
public class Product {
    private String name;
    private BigDecimal price;
    public Product(String name, BigDecimal price) {
        this.name = name;
        this.price = price;
    }
    public Object getName() {
        return name;
    }
}
