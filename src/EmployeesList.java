import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class EmployeesList {

    List<Employee> employeeList;

    public EmployeesList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public List<Employee> getEmployeeByWorkingExp(int workingExp) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getWorkingExp() == workingExp) newList.add(employee);
        }
        return newList;
    }

    public List<String> getEmployeeTelByEmployeeName(String name) {
        List<String> newList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (Objects.equals(employee.getName(), name)) newList.add(employee.getTelNum());
        }
        return newList;
    }

    public List<Employee> getEmployeeByTubNum(int tubName) {
        List<Employee> newList = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getTabNum() == tubName) newList.add(employee);
        }
        return newList;
    }

    public void addEmployee(Employee employee) {
        employeeList.add(employee);
    }
}
