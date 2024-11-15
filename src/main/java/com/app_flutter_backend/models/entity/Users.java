package com.app_flutter_backend.models.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

enum Roles {
    normal,
    admin
}

@Table(name="users")
@Entity
public class Users {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.UUID)  // Use a geração automática ou UUID manualmente
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Roles role = Roles.normal;

    @Column(name = "name", nullable = true, length = 100)
    private String name;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    // Construtor padrão
    public Users() {}

    // Construtor com parâmetros
    public Users(String id, String name, String email, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // // Método chamado antes da persistência
    // @PrePersist
    // public void prePersist() {
    //     if (id == null) {
    //         // Gerar UUID
    //         UUID uuid = UUID.randomUUID();
    //         this.id = uuid.toString();  // Armazene o UUID como String
    //     }
    // }

    // Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }
}
