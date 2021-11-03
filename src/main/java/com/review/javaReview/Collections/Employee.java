package com.review.javaReview.Collections;

import java.util.*;

public class Employee {
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    int age;


    public Employee(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee employee = (Employee) obj;
        return employee.getAge() == this.getAge() && employee.getName() == this.getName();
    }

    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + age;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}

class Client {
    public static void main(String[] args) {
        Employee emp = new Employee("Ela", 15);
        Employee emp1 = new Employee("Shree", 15);
        Employee emp2 = new Employee("Ela", 15);

        HashSet<Employee> employees = new HashSet<Employee>();
        employees.add(emp);

        System.out.println(employees.contains(emp2));

        System.out.println("employee.hashCode():" + emp.hashCode()
        +"employee2.hashcode():" + emp2.hashCode());


        Collection<String> data = new LinkedList<>();
        new LinkedHashSet(data);

        int sum = Arrays.stream(new int[] {1,2,3})
                .filter(i -> i >= 2)
                .map(i -> i * 3)
                .sum();

        Iterator<String> itr = data.iterator();




    }
}