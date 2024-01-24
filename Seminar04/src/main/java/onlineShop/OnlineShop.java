package onlineShop;



import onlineShop.exceptions.CustomerNotExistException;
import onlineShop.exceptions.ProductNotExistException;
import onlineShop.exceptions.QuantityException;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;
@Data
public class OnlineShop {
    // Список клиентов
    private static List<Customer> customerList = new ArrayList<>();
    // Список товаров
    private static List<Product> productList = new ArrayList<>();
    // Список заказов
    private static List<Order> orderList = new ArrayList<>();
    public static List<Customer> getCustomerList() {
        return customerList;
    }
    public static List<Product> getProductList() {
        return productList;
    }
    public static List<Order> getOrderList() {
        return orderList;
    }

    /**
     * Метод принимает информацию о клиенте, товаре и количестве и выполняет проверки наличия клиента,
     * товара и корректности количества. Если все проверки пройдены успешно, метод возвращает новый объект Order.
     * @param customerFIO
     * @param productName
     * @param quantityOfProducts
     * @return
     * @throws QuantityException
     * @throws CustomerNotExistException
     * @throws ProductNotExistException
     */
    public static Order buyProduct(String customerFIO, String productName, String quantityOfProducts) throws QuantityException, CustomerNotExistException, ProductNotExistException {
        // Создаются два объекта типа Customer и Product, которые будут использоваться для создания заказа.
        Customer currentCustomer = null;
        // Проводим поиск клиента:
        for (Customer customer : customerList) {
            if (customer.getFIO().equals(customerFIO)) {
                currentCustomer = customer;
                break;
            }
        }
        Product currentProduct = null;
        // Проводим поиск продукта:
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                currentProduct = product;
                break;
            }
        }
        /* Значение параметра quantityOfProducts преобразуется в тип int с помощью метода Integer.parseInt().
        Таким образом, строка, представляющая количественное значение товара, конвертируется в числовое
        значение currentQuantity. */
        int currentQuantity = Integer.parseInt(quantityOfProducts);
        /* Если значение currentQuantity меньше или равно 0, или больше 100, генерируется исключение
        QuantityException с передачей имени клиента и названия товара в конструктор исключения.*/
        if (currentQuantity <= 0 || currentQuantity > 100) {
            throw new QuantityException(customerFIO, productName);
        }
        /* Если значение currentCustomer равно null, то выполняется генерация исключения CustomerNotExistException.*/
        if (currentCustomer == null) {
            throw new CustomerNotExistException();
        }
        /* Если значение currentProduct равно null, то выполняется генерация исключения ProductNotExistException.*/
        if (currentProduct == null) {
            throw new ProductNotExistException();
        }
        return new Order(currentCustomer, currentProduct, currentQuantity);
        /*
        Таким образом, метод buyProduct выполняет проверки наличия клиента и товара, а также проверку
        корректного количества. Если все условия выполнены, создается объект заказа на основе найденных
        значений и возвращается. В противном случае, генерируются соответствующие исключения, чтобы сообщить
        об ошибке.
         */
    }
}
