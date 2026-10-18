public class Main {
    public static void main(String[] args) {
        EmployeeBook book = new EmployeeBook();

        boolean[] results = new boolean[11];
        results[0] = book.addEmployee(new Employee("Колпаков В.Н.", 1, 100));
        results[1] = book.addEmployee(new Employee("Сидоров П.К.", 2, 200));
        results[2] = book.addEmployee(new Employee("Лукашенко А.Г.", 3, 300));
        results[3] = book.addEmployee(new Employee("Медведев Д.А.", 4, 400));
        results[4] = book.addEmployee(new Employee("Трамп Д.Д.", 5, 150));
        results[5] = book.addEmployee(new Employee("Васильев В.В.", 1, 250));
        results[6] = book.addEmployee(new Employee("Си Д.Ч.", 2, 350));
        results[7] = book.addEmployee(new Employee("Путин В.В.", 3, 450));
        results[8] = book.addEmployee(new Employee("Достоевский Ф.М.", 4, 120));
        results[9] = book.addEmployee(new Employee("Пушкин А.С.", 5, 320));
        results[10] = book.addEmployee(new Employee("Гоголь Н.В.", 1, 280));
        System.out.println();

        System.out.println("Результаты добавления сотрудников:");
        System.out.println();
        for (int i = 0; i < results.length; i++) {
            System.out.println("Добавление сотрудника " + (i + 1) + ": " + results[i]);
        }
        System.out.println();

        System.out.println("--- Список всех сотрудников ---");
        System.out.println();
        book.printAllEmployees();
        System.out.println();

        System.out.println("--- Средняя зарплата ---");
        System.out.println();
        System.out.println("Средняя зарплата: " + book.calculateAverageSalary());
        System.out.println();

        System.out.println("--- Налоги (PROPORTIONAL) ---");
        System.out.println();
        book.printTaxes("PROPORTIONAL");
        System.out.println();

        System.out.println("--- Налоги (PROGRESSIVE) ---");
        System.out.println();
        book.printTaxes("PROGRESSIVE");
        System.out.println();

        System.out.println("--- Индексация зарплат отдела 1 на 10% ---");
        System.out.println();
        book.indexSalariesInDepartment(1, 10);
        book.printAllEmployees();
        System.out.println();

        System.out.println("--- Поиск первого сотрудника отдела 2 с зарплатой > 200 ---");
        System.out.println();
        book.findFirstAboveSalaryInDepartment(2, 200);
        System.out.println();

        System.out.println("--- Первые 3 сотрудника с зарплатой < 300 ---");
        System.out.println();
        book.printFirstBelowSalary(300, 3);
        System.out.println();

        System.out.println("--- Проверка наличия сотрудника с такой же зарплатой ---");
        Employee testEmployee = new Employee("Проверка", 1, 300);
        System.out.println();
        System.out.println("Есть ли сотрудник с такой же зарплатой? " + book.containsEmployeeBySalary(testEmployee));
        System.out.println();

        System.out.println("--- Поиск сотрудника по ID ---");
        System.out.println();
        Employee found = book.getEmployeeById(3);
        if (found != null) {
            found.printShortInfo();
        } else {
            System.out.println("Сотрудник с таким ID не найден.");
        }
        System.out.println();

        System.out.println("--- Edge-case: пустой EmployeeBook ---");
        System.out.println();
        EmployeeBook emptyBook = new EmployeeBook();
        System.out.println("Средняя зарплата в пустом массиве: " + emptyBook.calculateAverageSalary());
        emptyBook.printTaxes("PROPORTIONAL");
    }
}