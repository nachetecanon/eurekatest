package com.bbva.microservicio2.repo;

import com.bbva.microservicio2.model.Customer;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by icanon on 26/10/16.
 */
@Repository
public class CustomerRepository {

    private static final ConcurrentHashMap<String, Customer> database = new ConcurrentHashMap<>();

    static {
        database.put("menganito", new Customer("menganito", "dato prueba nombre", "9495955", "miratu@paradigmadigital.com"));
        database.put("jorgito", new Customer("jorgito", "prueba nombre jorge", "45222444", "concoc@paradigmadigital.com"));
        database.put("alvarito", new Customer("alvarito", "cualquier nombre", "151515555", "asasas@paradigmadigital.com"));
    }

    private Optional<Customer> findByUserId(final String userId) {
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
