package com.heroku.demo;

import javax.persistence.*;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "OPTION")
public class Option {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty
    private int id;
    @NotEmpty
    private String owner;
    @NotEmpty
    private String value;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
