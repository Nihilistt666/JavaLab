package com.lab4;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Employee> employees = new ArrayList<>();

        System.out.print("Введіть кількість працівників: ");
        int count = scanner.nextInt();
        scanner.nextLine(); // очищення буфера

        for (int i = 0; i < count; i++) {
            System.out.println("\n=== Працівник #" + (i + 1) + " ===");

            System.out.print("ПІБ: ");
            String fullName = scanner.nextLine();

            System.out.print("Посада: ");
            String position = scanner.nextLine();

            System.out.print("Зарплата (грн): ");
            double salary = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Відділ: ");
            String department = scanner.nextLine();

            System.out.print("Стаж (років): ");
            int experience = scanner.nextInt();
            scanner.nextLine();

            Employee emp = new Employee(fullName, position, salary, department, experience);
            employees.add(emp);
        }

        // Вивід усіх працівників
        System.out.println("\n" + "=".repeat(60));
        System.out.println("СПИСОК ПРАЦІВНИКІВ");
        System.out.println("=".repeat(60));

        for (Employee e : employees) {
            System.out.println(e);
        }

        System.out.println("Кількість працівників: " + employees.size());
    }
}
