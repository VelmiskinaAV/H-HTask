package ru.arvelm.lesson_1_velmiskina_arina;

public class Student {

    public String name;
    public String surname;
    public String grade;
    public String year;

    Student(String name, String surname, String grade, String year){
        this.name = name;
        this.surname = surname;
        this.grade = grade;
        this.year = year;
    }

    String returnValue() {
        return name + " " + surname + " " + grade + " " + year;
    }
}
