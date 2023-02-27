package com.lab06;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.io.Serializable;

@Data
@Entity
@Table(name="student")
@NoArgsConstructor
@Setter @Getter

public class Student implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String phone;
    private String major;

    public Student(Integer id, String name, String phone, String major)
    {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.major = major;
    }
    public Student(String name, String phone, String major)
    {
        this.name = name;
        this.phone = phone;
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + id + '\'' +
                ", Name='" + name + '\'' +
                ", Phone=" + phone +
                ", Major='" + major + '\'' +
                '}';
    }

}

