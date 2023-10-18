package com.luxoft.springadvanced.projections;

public class NameOnlyProjection {

    private final String lastname;
    private final String firstname;

    public NameOnlyProjection(String lastname, String firstname) {
        this.lastname = lastname;
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }
}
