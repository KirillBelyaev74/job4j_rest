package ru.job4j.job4j_rest.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "inn")
    private int inn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created")
    private Date created;

    @OneToOne
    @JoinColumn(name = "person_id")
    private Person person;

    public Employee() {
    }

    public Employee(String name, String surname, int inn) {
        this.name = name;
        this.surname = surname;
        this.inn = inn;
        this.created = new Date();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getInn() {
        return inn;
    }

    public void setInn(int inn) {
        this.inn = inn;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Employee employee = (Employee) o;
        return id == employee.id
                && inn == employee.inn
                && Objects.equals(name, employee.name)
                && Objects.equals(surname, employee.surname)
                && Objects.equals(created, employee.created)
                && Objects.equals(person, employee.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, inn, created, person);
    }

    @Override
    public String toString() {
        return "Employee { "
                + "id = " + id
                + ", name = '" + name + '\''
                + ", surname = '" + surname + '\''
                + ", inn = " + inn
                + '}';
    }
}
