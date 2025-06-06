package org.acme.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil {

    @Id
    private Long id;

    private String label;

    // ✅ Construtor vazio — obrigatório para JPA
    public Perfil() {}

    // ✅ Construtor para facilitar criação
    public Perfil(Long id, String label) {
        this.id = id;
        this.label = label;
    }

    // ✅ Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
