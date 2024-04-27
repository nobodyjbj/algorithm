package org.example.classdiagram.aggregation;

public class Company {
    private Person person;

    public Company(Person teacher) {
        this.person = teacher;
    }

    public Person getPerson() {
        return person;
    }
}
