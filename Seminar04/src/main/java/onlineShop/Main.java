package onlineShop;

import onlineShop.exceptions.CustomerNotExistException;
import onlineShop.exceptions.ProductNotExistException;
import onlineShop.exceptions.QuantityException;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;

public class Main {
    public enum Holiday {
        NONE,
        NEW_YEAR,
        INTERNATIONAL_WOMENS_DAY,
        DEFENDER_OF_THE_FATHERLAND_DAY,
        DEFENDER_OF_THE_EDUCATION_DAY
    }

    private static boolean isHolidayToday(Holiday holiday) {
        LocalDate currentDate = LocalDate.now();

        switch (holiday) {
            case NEW_YEAR:
                // проверяем, является ли сегодня Новым Годом (1 января)
                return currentDate.getMonth() == Month.JANUARY && currentDate.getDayOfMonth() == 1;
            case INTERNATIONAL_WOMENS_DAY:
                // проверяем, является ли сегодня 8 марта
                return currentDate.getMonth() == Month.MARCH && currentDate.getDayOfMonth() == 8;
            case DEFENDER_OF_THE_FATHERLAND_DAY:
                // проверяем, является ли сегодня 23 февраля
                return currentDate.getMonth() == Month.FEBRUARY && currentDate.getDayOfMonth() == 23;
            case DEFENDER_OF_THE_EDUCATION_DAY:
                return currentDate.getMonth() == Month.JANUARY && currentDate.getDayOfMonth() == 24;
            default:
                return false;
        }
    }

    private static Holiday getHoliday(LocalDate currentDate) {
        if (isHolidayToday(Holiday.NEW_YEAR)) {
            return Holiday.NEW_YEAR;
        } else if (isHolidayToday(Holiday.INTERNATIONAL_WOMENS_DAY)) {
            return Holiday.INTERNATIONAL_WOMENS_DAY;
        } else if (isHolidayToday(Holiday.DEFENDER_OF_THE_FATHERLAND_DAY)) {
            return Holiday.DEFENDER_OF_THE_FATHERLAND_DAY;
        } else if (isHolidayToday(Holiday.DEFENDER_OF_THE_EDUCATION_DAY)) {
            return Holiday.DEFENDER_OF_THE_EDUCATION_DAY;
        } else {
            return Holiday.NONE;
        }
    }

    private static void congratulateCustomer(Customer customer, Holiday holiday) {
        String gender = customer.getGender() == Customer.Gender.MALE ? "мужчина" : "женщина";
        String holidayMessage = "";

        switch (holiday) {
            case NEW_YEAR:
                holidayMessage = "С Новым Годом!";
                break;
            case INTERNATIONAL_WOMENS_DAY:
                holidayMessage = "С 8 Марта!";
                break;
            case DEFENDER_OF_THE_FATHERLAND_DAY:
                holidayMessage = "С Днем защитника Отечества!";
                break;
            case DEFENDER_OF_THE_EDUCATION_DAY:
                holidayMessage = "С Днем Образования!";
        }
        System.out.println(customer.getFIO() + " (" + gender + "): " + holidayMessage);
    }

    public static void congratulateEmployees(Customer[] customers) {
        LocalDate currentDate = LocalDate.now();
        Holiday currentHoliday = getHoliday(currentDate);

        for (Customer customer : customers) {
            if (isHolidayToday(currentHoliday)) {
                congratulateCustomer(customer, currentHoliday);
            }
        }
    }

    public static void main(String[] args) throws CustomerNotExistException, ProductNotExistException, QuantityException {
        System.out.println("online shop");

        OnlineShop.getCustomerList().add(new Customer("Ivanov Ivan", LocalDate.of(1987, 12, 9), "+9867566473"));
        OnlineShop.getCustomerList().get(0).setGender(Customer.Gender.MALE); // Добавление гендера покупателю "Ivanov Ivan"
        OnlineShop.getCustomerList().add(new Customer("Petrov Petr", LocalDate.of(1988, 12, 20), "+9867566475"));
        OnlineShop.getCustomerList().get(1).setGender(Customer.Gender.MALE); // Добавление гендера покупателю "Petrov Petr"
        OnlineShop.getProductList().add(new Product("apple", BigDecimal.valueOf(10L)));
        OnlineShop.getProductList().add(new Product("pineapple", BigDecimal.valueOf(50L)));

        try {
            Order order = null;
            order = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");


            OnlineShop.getOrderList().add(order);
            System.out.println(OnlineShop.getOrderList());

            Order order2 = OnlineShop.buyProduct("Ivanov Ivan", "apple", "20");
            OnlineShop.getOrderList().add(order2);
            System.out.println(OnlineShop.getOrderList());

            Order order3 = OnlineShop.buyProduct("Petrov Petr", "pineapple", "300");
            OnlineShop.getOrderList().add(order3);


        } catch (QuantityException e) {
            OnlineShop.getOrderList().add(OnlineShop.buyProduct(e.getCustomer(), e.getProduct(), "1"));
        } catch (ProductNotExistException e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            throw e;
        }

        System.out.println(OnlineShop.getOrderList());
        System.out.println(OnlineShop.getOrderList().size() + " orders received");

        Customer[] customersArray = OnlineShop.getCustomerList().toArray(new Customer[0]);
        congratulateEmployees(customersArray);
    }
}