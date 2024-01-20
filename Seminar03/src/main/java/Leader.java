import java.math.BigDecimal;
import java.time.LocalDate;

public class Leader extends Employees {

    public Leader(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
        super(FIO, position, phone, salary, birthDate);
    }

    @Override
    public void increaseSalary(int value) {
        // Проверяем, является ли сотрудник руководителем
        if (!getPosition().equals("team lead")) {
            super.increaseSalary(value); // Используем метод родительского класса для повышения зарплаты
        }
    }
}
