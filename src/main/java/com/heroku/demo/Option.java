package com.heroku.demo;

import javax.persistence.*;

@Entity
@Table(name = "OPTION")
public class Option {

    @Id
    private String owner;
    private String value;

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
