package com.lab4;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Головний клас програми для лабораторної №6.
 * Демонструє enum, статичний лічильник, конструктор копіювання та агрегацію.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== Практична робота №6 - Enum, Static, Aggregation ===");

        Department itDepartment = new Department("Інформаційні Технології", "Київ");

        while (true) {
            printMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1 -> addEmployee(itDepartment);
                    case 2 -> printDepartment(itDepartment);
                    case 3 -> demonstrateStaticAndCopy(itDepartment);
                    case 0 -> {
                        System.out.println("Програма завершена.");
                        return;
                    }
                    default -> System.out.println("Невірний вибір!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Помилка: введіть число!");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Помилка: " + e.getMessage());
            }
        }
    }

    private static void printMenu() {
        System.out.println("\n" + "=".repeat(55));
        System.out.println("1. Додати нового працівника");
        System.out.println("2. Показати відділ та працівників");
        System.out.println("3. Демонстрація static + copy constructor");
        System.out.println("0. Вийти");
        System.out.println("=".repeat(55));
        System.out.print("Ваш вибір: ");
    }

    private static void addEmployee(Department dept) {

        System.out.println("Функція додавання працівника (тимчасово спрощена)");
    }

    private static void printDepartment(Department dept) {
        System.out.println(dept);
        for (Employee e : dept.getEmployees()) {
            System.out.println("   → " + e);
        }
    }

    private static void demonstrateStaticAndCopy(Department dept) {
        System.out.println("\n=== Демонстрація статичного лічильника ===");
        System.out.println("Всього створено працівників: " + Employee.getTotalEmployeesCreated());

        if (!dept.getEmployees().isEmpty()) {
            Employee original = dept.getEmployees().get(0);
            Employee copy = new Employee(original);

            System.out.println("\n=== Конструктор копіювання ===");
            System.out.println("Оригінал: " + original);
            System.out.println("Копія:    " + copy);
        }
    }
}
