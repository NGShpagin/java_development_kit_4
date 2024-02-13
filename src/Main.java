
/*
    Задание 1.
    В рамках задачи необходимо:
    - создать коллекцию мужских и женских имен с помощью интерфейса List
    - отсортировать коллекцию в алфавитном порядке
    - Отсортировать коллекцию по количеству букв в слове
    - Развернуть коллекцию
 */

/*
    Задание 2.
    Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения.
    Получите уникальный список Set на основании List.
    Определите наименьший элемент (алфавитный порядок).
    Определите наименьший элемент (по количеству букв в слове, но в обратном порядке).
    Удалите все элементы, содержащие букву 'А'
 */

/*
    Задание 3.
    Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение.
    Найдите человека с самым маленьким номером телефона.
    Найдите номер телефона человека чье имя самое большое в алфавитном порядке.
 */

/*
    Создать класс справочник сотрудников, который содержит внутри коллекции сотрудников - каждый сотрудник должен иметь:
    - Табельный номер,
    - Номер телефона,
    - Имя,
    - Стаж.
    Добавить метод, который ищет сотрудников по стажу (может быть список).
    Добавить метод, который выводит номер телефона сотрудников по имени (может быть список).
    Добавить метод, который ищет сотрудников по табельному номеру.
    Добавить метод добавления нового сотрудника в справочник сотрудников.
 */


import java.time.LocalDate;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        // Задание 1
        List<String> menList = new ArrayList<>();
        menList.add("Nik");
        menList.add("Maks");
        menList.add("Leonid");
        menList.add("Vladimir");
        menList.sort(String::compareTo);
        System.out.println(menList);

        Comparator<String> lengthCompare = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() > o2.length())
                    return 1;
                else if (o1.length() < o2.length()) {
                    return -1;
                }
                return 0;
            }
        };

        menList.sort(lengthCompare);
        System.out.println(menList);
        menList.sort(Comparator.reverseOrder());
        System.out.println(menList);

        // Задание 2
        List<String> womenList = new ArrayList<>();
        womenList.add("Ksenia");
        womenList.add("Ilyana");
        womenList.add("Nika");
        womenList.add("Kseny");
        womenList.add("Nika");
        womenList.add("Ilyana");
        womenList.add("Veli");

        Set<String> mySet = new HashSet<>(womenList);
        System.out.println(mySet);
        womenList.sort(String::compareTo);
        String smallestElem = womenList.get(0);
        System.out.println(smallestElem);

        womenList.sort(lengthCompare);
        System.out.println(womenList.get(0));

        womenList.removeIf(el -> el.contains("a") || el.contains("A"));
        System.out.println(womenList);

        // Задание 3

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.putIfAbsent("+7916401016", "Nik");
        phoneBook.putIfAbsent("+791640138", "Ilyana");
        phoneBook.putIfAbsent("+791640313038", "Valya");
        phoneBook.putIfAbsent("+79164018", "Ivan");
        phoneBook.putIfAbsent("+0956dfgdfgdfg75", "Vladislav");

        String minNum = null;
        String maxName = null;
        String tel = null;

        for (String s : phoneBook.keySet()) {
            if (minNum == null || s.length() < minNum.length()) minNum = s;
            if (maxName == null || (phoneBook.get(s)).length() > maxName.length()) {
                maxName = phoneBook.get(s);
                tel = s;
            }
        }
        System.out.println(minNum);
        System.out.printf("max name = %s (tel: %s)\n", maxName, tel);

        List<Map.Entry<String, String>> value = new ArrayList<>(phoneBook.entrySet());
        value.sort(Map.Entry.comparingByValue());
        System.out.println(value);

        // Задание 4
        Employee nik = new Employee("Nik", "791648271", LocalDate.of(2014, 1, 1));
        Employee ilyana = new Employee("Ilyana", "734648271", LocalDate.of(2008, 3, 27));
        EmployeesList employeesList = new EmployeesList(new ArrayList<>());
        employeesList.addEmployee(nik);
        employeesList.addEmployee(ilyana);
        System.out.println(employeesList.getEmployeeByTubNum(2));
        System.out.println(employeesList.getEmployeeByWorkingExp(16));
        System.out.println(employeesList.getEmployeeTelByEmployeeName("Nik"));
    }
}