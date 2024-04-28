package me.nobody.classdiagram.assosiation;

public class Enrollment {
    private me.nobody.classdiagram.assosiation.Student student;
    private me.nobody.classdiagram.assosiation.Course course;

    public Enrollment(me.nobody.classdiagram.assosiation.Student student, me.nobody.classdiagram.assosiation.Course course) {
        this.student = student;
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public Course getCourse() {
        return course;
    }
}
