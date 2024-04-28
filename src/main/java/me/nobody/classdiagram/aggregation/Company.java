package me.nobody.classdiagram.aggregation;

public class Company {
    private me.nobody.classdiagram.aggregation.Person person;

    public Company(me.nobody.classdiagram.aggregation.Person teacher) {
        this.person = teacher;
    }

    public Person getPerson() {
        return person;
    }
}
