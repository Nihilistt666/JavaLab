package com.lab4;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class EmployeeTest {

    @Test
    void shouldThrowExceptionWhenFullNameIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("", "Manager", 15000, "IT", 5, "+380123456789", true);
        });
    }

    @Test
    void shouldThrowExceptionWhenSalaryIsNegative() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Employee("Іванов І.І.", "Manager", -1000, "IT", 5, "+380123456789", true);
        });
    }

    @Test
    void shouldThrowExceptionWhenExperienceIsInvalid() {
        Employee emp = new Employee("Петренко П.П.", "Developer", 25000,
                "IT", 3, "+380987654321", true);

        assertThrows(IllegalArgumentException.class, () -> {
            emp.setExperienceYears(-1);
        });
    }

    @Test
    void shouldCreateEmployeeWithValidData() {
        assertDoesNotThrow(() -> {
            Employee emp = new Employee("Сидоренко С.С.", "Analyst", 30000,
                    "Finance", 7, "+380501234567", false);
            assertEquals("Сидоренко С.С.", emp.getFullName());
            assertEquals(30000, emp.getSalary());
        });
    }
}
