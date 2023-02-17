package com.app.employee.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import java.io.Serializable;

// use Serializable to transform data into different types
@Entity
public class Employee implements Serializable {
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String name;
    private String rollNumber;
    private int language;
    private int maths;
    private int physics;
    private int science;
    private int total;
    private int rank;
    public String getName() {
        return name;
    }
    public String getRollNumber() {
        return rollNumber;
    }

    public int getLanguage() {
        return language;
    }

    public int getMaths() {
        return maths;
    }

    public int getPhysics() {
        return physics;
    }

    public int getScience() {
        return science;
    }

    public int getTotal() {
        return total;
    }

    public int getRank() {
        return rank;
    }

    public void setRollNumber(String rollNumber) {
        this.rollNumber = rollNumber;
    }

    public void setLanguage(int language) {
        this.language = language;
    }

    public void setMaths(int maths) {
        this.maths = maths;
    }

    public void setPhysics(int physics) {
        this.physics = physics;
    }

    public void setScience(int science) {
        this.science = science;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", rollNumber='" + rollNumber + '\'' +
                ", language=" + language +
                ", maths=" + maths +
                ", physics=" + physics +
                ", science=" + science +
                ", total=" + total +
                ", rank=" + rank +
                '}';
    }
}
