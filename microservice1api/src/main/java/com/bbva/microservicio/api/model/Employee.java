package com.bbva.microservicio.api.model;

import java.util.Objects;

/**
 * Created by icanon on 26/10/16.
 */
public class Employee {
    private String userId;
    private String name;
    private String phone;
    private String email;

    public Employee(String userId, String name, String phone, String email) {
        this.userId = userId;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(userId, employee.userId) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(phone, employee.phone) &&
                Objects.equals(email, employee.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, name, phone, email);
    }
}
