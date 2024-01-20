import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;




public class Employees {
    private String FIO;
    private String position;
    private String phone;
    private BigDecimal salary;
    private LocalDate birthDate;

    public Employees(String FIO, String position, String phone, BigDecimal salary, LocalDate birthDate) {
        this.FIO = FIO;
        this.position = position;
        this.phone = phone;
        this.salary = salary;
        this.birthDate = birthDate;
    }

    public String getFIO() {
        return FIO;
    }

    public String getPosition() {
        return position;
    }

    public String getPhone() {
        return phone;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public LocalDate getBirth() {
        return birthDate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthDate, currentDate).getYears();
    }

    public void setFIO(String FIO) {
        this.FIO = FIO;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {

        return String.format("%s - %s , phone - %s ,salary - %s, age - %s",
                FIO, position, phone, salary, this.getAge());
    }

    public void printInfo() {
        System.out.println(this);
    }

    public void increaseSalary(int value) {
        this.salary = salary.add(BigDecimal.valueOf(value));
    }

    /**
     * 1. Написать прототип компаратора - метод внутри класса сотрудника, сравнивающий две даты, представленные
     * в виде трёх чисел гггг-мм-дд, без использования условного оператора.
     * @param year1
     * @param month1
     * @param day1
     * @param year2
     * @param month2
     * @param day2
     * @return
     */
    public int compareDates(int year1, int month1, int day1, int year2, int month2, int day2) {
        LocalDate date1 = LocalDate.of(year1, month1, day1);
        LocalDate date2 = LocalDate.of(year2, month2, day2);

        return date1.compareTo(date2);
    }
}
