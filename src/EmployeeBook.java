public class EmployeeBook {
    private Employee[] employees;

    public EmployeeBook() {
        employees = new Employee[10];
    }

    public boolean addEmployee(Employee employee) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i] == null) {
                employees[i] = employee;
                return true;
            }
        }
        return false;
    }

    public void printAllEmployees() {
        for (Employee e : employees) {
            if (e != null) {
                System.out.println(e.toString());
            }
        }
    }

    public double calculateAverageSalary() {
        int count = 0;
        int totalSalary = 0;

        for (Employee e : employees) {
            if (e != null) {
                count++;
                totalSalary += e.getSalary();
            }
        }

        if (count == 0) return 0.0;
        return (double) totalSalary / count;
    }

    public void printTaxes(String taxType) {
        switch (taxType) {
            case "PROPORTIONAL":
                for (Employee e : employees) {
                    if (e != null) {
                        double tax = e.getSalary() * 0.13;
                        System.out.println("Сотрудник: " + e.getFullName() + ", зарплата: " + e.getSalary() + ", налог (13%): " + tax);
                    }
                }
                break;
            case "PROGRESSIVE":
                for (Employee e : employees) {
                    if (e != null) {
                        int salary = e.getSalary();
                        double rate;
                        if (salary <= 150) {
                            rate = 0.13;
                        } else if (salary <= 350) {
                            rate = 0.17;
                        } else {
                            rate = 0.21;
                        }
                        double tax = salary * rate;
                        System.out.println("Сотрудник: " + e.getFullName() + ", зарплата: " + salary + ", ставка: " + (rate * 100) + "%, налог: " + tax);
                    }
                }
                break;
            default:
                System.out.println("Неизвестный тип расчёта налогов: " + taxType);
        }
    }

    public void indexSalariesInDepartment(int department, double percent) {
        for (Employee e : employees) {
            if (e == null) continue;

            if (e.getDepartment() != department) {
                continue;
            }

            int oldSalary = e.getSalary();
            int newSalary = (int) (oldSalary * (1.0 + percent / 100.0));

            if (newSalary == oldSalary) {
                continue;
            }

            e.setSalary(newSalary);
        }
    }

    public void findFirstAboveSalaryInDepartment(int department, int wage) {
        for (int i = 0; i < employees.length; i++) {
            Employee e = employees[i];
            if (e == null) continue;

            if (e.getDepartment() == department && e.getSalary() > wage) {
                System.out.println("Найден сотрудник (порядковый номер в массиве: " + i + "):");
                e.printShortInfo();
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }

    public void printFirstBelowSalary(int wage, int employeeNumber) {
        int count = 0;
        int i = 0;

        while (i < employees.length) {
            Employee e = employees[i];
            if (e != null && e.getSalary() < wage) {
                e.printShortInfo();
                count++;
                if (count >= employeeNumber) {
                    break;
                }
            }
            i++;
        }

        if (count == 0) {
            System.out.println("Подходящих сотрудников не найдено.");
        }
    }

    public boolean containsEmployeeBySalary(Employee target) {
        for (Employee e : employees) {
            if (e != null && e.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public Employee getEmployeeById(int id) {
        for (Employee e : employees) {
            if (e != null && e.getId() == id) {
                return e;
            }
        }
        return null;
    }
}
