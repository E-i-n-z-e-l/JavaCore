import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Employees employee1 = new Employees("Ivan Petrov",
                "devops",
                "+79765463452",
                BigDecimal.valueOf(100000),
                LocalDate.of(1990, 1, 1));

        Employees employee2 = new Employees("Vasiliy Petrov",
                "programmer",
                "+79765463452",
                BigDecimal.valueOf(200000),
                LocalDate.of(1990, 1, 1));

        Employees employee3 = new Employees("Ivan Ivanov",
                "engineer",
                "+79765463452",
                BigDecimal.valueOf(60000),
                LocalDate.of(1970, 1, 1));

        Employees employee4 = new Employees("Ivan Sidorov",
                "analyst",
                "+79765463452",
                BigDecimal.valueOf(50000),
                LocalDate.of(1990, 1, 1));

        Employees employee5 = new Employees("Petr Petrov",
                "senor",
                "+79765463452",
                BigDecimal.valueOf(300000),
                LocalDate.of(1975, 1, 1));

        Leader leader = new Leader("John Doe",
                "team lead",
                "+79876543210",
                BigDecimal.valueOf(400000),
                LocalDate.of(1985, 5, 10));

        List<Employees> employees = new ArrayList<>(Arrays.asList(employee1,
                employee2,
                employee3,
                employee4,
                employee5,
                leader));

        for (Employees employee : employees) {
            employee.printInfo();
        }
        // Повышаем ЗП всем кроме ТимЛида
        salaryIncreaseForEmployees(employees, 45, 50000);
        System.out.println();

        for (Employees employee : employees) {
            employee.printInfo();
        }

        System.out.println(getAverageSalaryAndAge(employees));
    }

    /**
     * Метод, повышающий зарплату всем сотрудникам старше
     * 45 лет на 50000.
     * <p>
     * Метод должен принимать в качестве параметра массив сотрудников.
     *
     * @param employees
     * @param ageOlder
     * @param bonusValue
     */
    public static void salaryIncreaseForEmployees(List<Employees> employees, int ageOlder, int bonusValue) {
        for (Employees employee : employees) {
            if (employee.getAge() > ageOlder) {
                employee.increaseSalary(bonusValue);
            }
        }
    }

    /**
     * Методы (принимающие на вход массив сотрудников), вычисляющие средний возраст и среднюю
     * зарплату сотрудников
     *
     * @param employees
     * @return
     */
    public static String getAverageSalaryAndAge(List<Employees> employees) {
        double averageSalaries = employees.stream().mapToDouble(x -> x.getSalary().doubleValue()).average().orElseThrow();
        double averageAge = employees.stream().mapToDouble(x -> (double) x.getAge()).average().orElseThrow();

        return String.format("Average salary - %s, age - %s", averageSalaries, averageAge);

    }
}











