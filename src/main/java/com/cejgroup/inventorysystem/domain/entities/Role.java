package com.cejgroup.inventorysystem.domain.entities;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "Roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }

    @ManyToMany(mappedBy = "roles")
    private Collection<User> users;
    public Role(String name) {
        this.name = name;
    }
    public Long getId() {
        return id;
    }

    public Role() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
