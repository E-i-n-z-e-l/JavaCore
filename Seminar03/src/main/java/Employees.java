import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;


//@AllArgsConstructor
//
//@Data
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
}
