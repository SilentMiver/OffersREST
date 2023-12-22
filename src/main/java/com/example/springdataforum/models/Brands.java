package com.example.springdataforum.models;

import jakarta.persistence.*;


import java.util.Date;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brands extends BaseEntity {

    private String name;

    private Date created;

    private Date modified;

    public Brands(String name, Date created, Date modified) {
        this.name = name;
        this.created = created;
        this.modified = modified;
    }

    protected Brands() {
    }

    @OneToMany(mappedBy = "brand", cascade = CascadeType.REMOVE)
    private List<Models> models;

    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "created")
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Column(name = "modified")
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
