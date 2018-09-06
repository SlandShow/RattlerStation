package com.slandshow.models;

import javax.persistence.*;

@Entity
@Table(name = "role")
public class Role {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    private String type;

    public Role() {
    }

    public Role(String type) {
        this.type = type;
    }

    // Setters

    public void setId(Long id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getters

    public Long getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
