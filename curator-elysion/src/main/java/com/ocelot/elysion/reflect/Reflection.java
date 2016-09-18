package com.ocelot.elysion.reflect;

import java.lang.reflect.Method;

import static org.joor.Reflect.*;

/**
 * Created by gaoxiang on 16/8/24.
 */
public class Reflection {

    private void reflectCreateString() {
        String substring = on("java.lang.String")
                .create("Hello World")
                .as(StringProxy.class) // Create a proxy for the wrapped object
                .substring(6);         // Call a proxy method
    }

    private final String street = "JIN SONG";

    public static void main(String[] args) {
        Reflection.oor();
    }

    public static void oor() {
        Department department = new Department();
        Employee[] employees = on(department).call("getEmployees").get();

        for (Employee employee : employees) {
            String street = on(employee).call("getAddress").call("getStreets").get();
            System.out.println(street);
        }
    }

    private void normal() {
        try {
            Department department = new Department();
            Method m1 = department.getClass().getMethod("getEmployees");
            Employee[] employees = (Employee[]) m1.invoke(department);

            for (Employee employee : employees) {
                Method m2 = employee.getClass().getMethod("getAddress");
                Address address = (Address) m2.invoke(employee);

                Method m3 = address.getClass().getMethod("getStreet");
                String street = (String) m3.invoke(address);

                System.out.println(street);
            }
        } catch (Exception e) {

            // ... or maybe just wrap in your preferred runtime exception:
            throw new RuntimeException(e);
        }
    }
}
