package onlineShop;

import lombok.Data;
import java.time.LocalDate;
@Data
/**
 * Класс Customer представляет собой модель данных для представления информации о клиенте магазина онлайн-шопинга.
 */
public class Customer {
    private String FIO;
    private LocalDate dateOfBirth;
    private String phone;

    public Customer(String FIO, LocalDate dateOfBirth, String phone) {
        this.FIO = FIO;
        this.dateOfBirth = dateOfBirth;
        this.phone = phone;
    }
    public Object getFIO() {
        return FIO;
    }
}
