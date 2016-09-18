package com.ocelot.elysion.reflect;

public class Employee {

    public Employee(Address address) {
        this.address = address;
    }

    private Address address;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
