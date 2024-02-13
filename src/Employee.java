import java.time.LocalDate;
import java.time.LocalDateTime;

public class Employee {
    private static int id = 0;
    private int tabNum;
    private String telNum;
    private String name;
    private LocalDate hireDate;

    public Employee(String name, String telNum, LocalDate hireDate) {
        this.tabNum = ++id;
        this.telNum = telNum;
        this.name = name;
        this.hireDate = hireDate;
    }

    public int getWorkingExp() {
        return LocalDateTime.now().getYear() - hireDate.getYear();
    }

    public String getTelNum() {
        return telNum;
    }

    public String getName() {
        return name;
    }

    public int getTabNum() {
        return tabNum;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    @Override
    public String toString() {
        return String.format("tabNum: %d\n" +
                "name: %s\n" +
                "telNum: %s\n" +
                "hireDate: %s\n" +
                "workingExp: %d\n", getTabNum(), getName(), getTelNum(), getHireDate(), getWorkingExp());
    }
}
