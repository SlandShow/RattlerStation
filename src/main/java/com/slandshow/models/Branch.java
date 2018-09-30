package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "branch")
public class Branch {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    public Branch() {
    }

    public Branch(String name) {
        this.name = name;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Branch (id: " + id + " name: " + name + ")";
    }
}
