package org.example;


import org.example.entity.Employee;

import java.util.*;

public class Main {

    static List<Employee> employeeList = new ArrayList<>();

    static Map<Integer, Employee> uniqueEmployeeMap = new HashMap<>();

    static List<Employee> nonDuplicateEmployeeList = new LinkedList<>();

    static List<Employee> duplicateEmployeeList = new LinkedList<>();

    public static void main(String[] args) {

        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(1, "Dogancan", "Kinik"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(3, "Anil", "Ensari"));
        employeeList.add(new Employee(4, "Burak", "Cevizli"));
        employeeList.add(null);

        System.out.println(findDuplicates(employeeList));
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        for(Employee employee: employees) {
            if (employee == null) {
                continue;
            }
            else if (!nonDuplicateEmployeeList.contains(employee)) {
                nonDuplicateEmployeeList.add(employee);
            } else {
                duplicateEmployeeList.add(employee);
            }
        }
        return duplicateEmployeeList;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        for(Employee employee: employees) {
            if (employee == null) {
                System.out.println("Null Object.");
                continue;
            }
            else if (!uniqueEmployeeMap.containsKey(employee.getId())) {
                uniqueEmployeeMap.put(employee.getId(), employee);
            }
        }
        return uniqueEmployeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> removedAllDuplicatesEmployeeList = new LinkedList<>(employees);
        List<Employee> duplicatesList = new LinkedList<>();

        List<Employee> duplicates = findDuplicates(employees);

        removedAllDuplicatesEmployeeList.removeAll(duplicates);

        for (Employee employee: removedAllDuplicatesEmployeeList) {
            if (employee == null) {
                continue;
            } else {
                duplicatesList.add(employee);
            }
        }

        return duplicatesList;
    }
}