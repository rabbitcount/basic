package com.ocelot.elysion.reflect;

public class Department {

    public Employee[] getEmployees() {
        Employee e1 = new Employee(new Address("street1"));
        Employee e2 = new Employee(new Address("street2"));
        Employee[] es = new Employee[2];
        es[0] = e1;
        es[1] = e2;
        return es;
    }
}
