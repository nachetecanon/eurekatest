package com.bbva.microservicio.repo;

import com.bbva.microservicio.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by icanon on 26/10/16.
 */
@Repository
public class EmployeesRepository {

    private static final ConcurrentHashMap<String, Employee> database = new ConcurrentHashMap<>();

    static {
        database.put("icanon", new Employee("icanon", "Ignacio Cañón", "616030896", "icanon@paradigmadigital.com"));
        database.put("gmartinez", new Employee("gmartinez", "Guillermo Martínez", "693785214", "gmartinez@paradigmadigital.com"));
        database.put("malaguita", new Employee("malaguita", "Pablo Note Hablo", "777555888", "pablonotehablo@paradigmadigital.com"));
    }

    private Optional<Employee> findByUserId(final String userId) {
        return Optional.ofNullable(database.get(userId));
    }

    public String findNameByUserId(final String userId) {
        return findByUserId(userId).
                flatMap(ob -> Optional.of(ob.getName())).
                orElseGet(() -> null);
    }

    public String findPhoneByUserId(final String userId) {
        return findByUserId(userId).
                flatMap(ob -> Optional.of(ob.getPhone())).
                orElseGet(() -> null);
    }

    public String findEmailByUserId(final String userId) {
        return findByUserId(userId).
                flatMap(ob -> Optional.of(ob.getEmail())).
                orElseGet(() -> null);
    }


}
