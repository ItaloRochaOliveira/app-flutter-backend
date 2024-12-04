package com.app_flutter_backend.models.entity;

import java.sql.Date;

import javax.validation.constraints.*;

import org.hibernate.annotations.CreationTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name="users")
@Entity
public class Users {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)  // Use a geração automática ou UUID manualmente
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @NotBlank(message = "O nome não pode ser vazio ou conter apenas espaços")
    @NotNull(message = "O nome não pode ser nulo")
    @Size(min = 3, max = 50, message = "O nome deve ter entre 3 e 50 caracteres")
    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @NotBlank(message = "O email não pode ser vazio ou conter apenas espaços")
    @NotNull(message = "O email não pode ser nulo")
    @Size(min = 3, max = 50, message = "O email deve ter entre 3 e 50 caracteres")
    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @NotBlank(message = "O telefone não pode ser vazio ou conter apenas espaços")
    @NotNull(message = "O telefone não pode ser nulo")
    @Size(min = 3, max = 50, message = "O telefone deve ter entre 3 e 50 caracteres")
    @Column(name = "telefone", nullable = false, length = 17)
    private String telefone;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false)
    private Date created_at;

    @CreationTimestamp
    @Column(name = "updated_at", nullable = false)
    private Date updated_at;

    // Construtor padrão
    public Users() {}

    // Construtor com parâmetros
    public Users(String id, String name, String email, String telefone, Date created_at, Date updated_at) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.telefone = telefone;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
